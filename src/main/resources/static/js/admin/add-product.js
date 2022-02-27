$('#upload_single').click(function(event) {
    // You can directly create form data from the form element
    // (Or you could get the files from input element and append them to FormData as we did in vanilla javascript)
    var formData = new FormData();
    formData.append("file", $('#main_photo')[0].files[0]);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/uploadFile",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            console.log(response);
            $('#img_main').attr('src', response.fileDownloadUri);
        },
        error: function (error) {
            console.log(error);
            // process error
        }
    });

    event.preventDefault();
});

$('#upload_multiple').click(function(event) {
    // You can directly create form data from the form element
    // (Or you could get the files from input element and append them to FormData as we did in vanilla javascript)
    var formData = new FormData();
    for(var index = 0; index < $('#other_photo')[0].files.length; index++) {
            formData.append("files", $('#other_photo')[0].files[index]);
    }
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/uploadMultipleFiles",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            console.log(response);
            var html = '';
            var index = 0;
            for(var item of response) {
                html += '<img class="img-other-new-' + index + '" src="' + item.fileDownloadUri
                + '" style="width: 100px; height:50px"/><button type="button" class="primary delete-photo-new-' + index + '" onclick="deletePhoto(\'new-' + index + '\')">Delete</button>';
                index++;
            }
            $('#list_photo').append(html);
        },
        error: function (error) {
            console.log(error);
            // process error
        }
    });

    event.preventDefault();
});

var deletePhoto = function(id) {
    $('.img-other-' + id).remove();
    $('.delete-photo-' + id).remove();
}

var getCategoryDetail = function () {
    $.ajax({url: "category-detail-data", success: function(result){
        console.log(result);
        showCategoryDetail(result);
    }});
}

var showCategoryDetail = function(categoryDetailList){
     var html = '';
     for (var item of categoryDetailList){
        html += '<option value="' + item.id + '">' + item.name + '</option>';
     }
     $('#cbo_category').html(html);
}

var loadProducer = function(){
 $.ajax({url: "/producer-data" , success: function(result){
        var index = 0;
         var html = '';
        for(var item of result){
            html += '<option value="' + item.id + '">' + item.name + '</option>';
        }
        $('#cbo_producer').html(html);
    }});
}

var addProduct = function() {
    var newProduct = {
        "name": $('#txt_name').val(),
        "parameter": $('#txt_parameter').val(),
        "detail": $('#txt_detail').val(),
        "description": $('#txt_description').summernote('code'),
        "price": parseFloat($('#txt_price').val()),
        "categoryDetail": {
            "id": parseInt($('#cbo_category').val())
        },
        "producer": {
            "id": parseInt($('#cbo_producer').val())
        },
        "productphotoList": createProductphotoList(),
        "variantList": createVariantList()
    }

     $.ajax({url: "product", type: "POST", contentType: 'application/json', data: JSON.stringify(newProduct), success: function(result){ // go to category-date to get data from model
        console.log(result);
        if(result.id) {
            location.href="admin-product";
        } else {
            alert('Error when add new product');
        }
    }});
}

var updateProduct = function() {
    var params = new URLSearchParams(window.location.search);
    var id = params.get('id');
    var newProduct = {
        "id": parseInt(id),
        "name": $('#txt_name').val(),
        "parameter": $('#txt_parameter').val(),
        "detail": $('#txt_detail').val(),
        "description": $('#txt_description').summernote('code'),
        "price": parseFloat($('#txt_price').val()),
        "categoryDetail": {
            "id": parseInt($('#cbo_category').val())
        },
        "producer": {
            "id": parseInt($('#cbo_producer').val())
        },
        "productphotoList": createProductphotoList(),
        "variantList": createVariantList()
    }

     $.ajax({url: "product", type: "PUT", contentType: 'application/json', data: JSON.stringify(newProduct), success: function(result){ // go to category-date to get data from model
        console.log(result);
        if(result.id) {
            alert('Update product successfully');
        } else {
            alert('Error when update product');
        }
    }});
}

var getProductDetail = function(id) {
     $.ajax({url: "product/" + id, success: function(result){// use id to return a object
            $('#txt_name').val(result.name);
            $('#txt_parameter').val(result.parameter);
            $('#txt_detail').val(result.detail);
            $('#txt_price').val(result.price);
            $('#txt_description').summernote('code', result.description);
            $('#cbo_category').val(result.categoryDetail.category.id);
            $('#cbo_producer').val(result.producer.id);
            for(var item of result.productphotoList) {
                if(item.isDefault) {
                    $('#img_main').attr('src', item.photo);
                } else {
                    $('#list_photo').append('<img class="img-other-old-' + item.id + '" src="' + item.photo
                    + '" style="width: 100px; height:50px"/><button type="button" class="primary delete-photo-old-' + item.id + '" onclick="deletePhoto(\'old-' + item.id + '\')">Delete</button>');
                }
            }

            var variantData = '';
            for(var item of result.variantList) {
                variantData += item.name + ':' + item.price + '\n';
            }
            $('#txt_variant').val(variantData.trim());
            $('#btn_add_product').val('Update product');
            $('#btn_add_product').click(function() {
                updateProduct();
            })
        }
     });
}

var createProductphotoList = function() {
    var result = [];
    var mainPhoto = $('#img_main').attr('src');
    result.push({
            "photo": mainPhoto,
            "isDefault": true
    });
    $('#list_photo').find('img').each(function() {
        result.push({
                "photo": $(this).attr('src'),
                "isDefault": false
            });
    })
    return result;
}

var createVariantList = function() {
    var result = [];
    if($('#txt_variant').val()) {
        var variantData = $('#txt_variant').val().split("\n");
        for(var item of variantData) {
            var data = item.split(':');
            result.push({"name": data[0].trim(), "category": "color", "price": parseFloat(data[1].trim())});
        }
    }
    return result;
}


$(document).ready(function() {
    getCategoryDetail();
    loadProducer();

    $("#txt_description").summernote({
        placeholder: "Write your content here",
        height: 200,
    });
    var params = new URLSearchParams(window.location.search);
    var id = params.get('id');
    if(id){
        getProductDetail(id);
    } else {
        $('#btn_add_product').click(function() {
            addProduct();
        })
    }

});