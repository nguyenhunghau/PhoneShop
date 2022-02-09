
var currentProduct = {};

var loadData = function () {
    var params = new URLSearchParams(window.location.search);
    var id = params.get('id');
    $.ajax({url: "product/" + id, success: function(result){// use id to return a object
        console.log(result);
        currentProduct = result;
        $("#product_title").text(result.name);
         $("#product_price").text(formatNumber(result.price));
        showParameter(result.parameter);
        showInfoDetail(result.detail);
        showPhoto(result.productphotoList);
        showDesciption(result.description);
        showCategoryLink(result);
        handleForVariants(result.variantList);
    }});
}

var showParameter = function(parameter) {
    var array = parameter.split('\n');
    var html = '';
    for(var item of array) {
        html += '<tr><td width="283">' + item + '</td></tr>';
    }
    $("#tbl_parameter tbody").html(html);
}

var showInfoDetail = function(detail) {
    var array = detail.split('\n');
    var html = '';
    for(var item of array) {
        if(!item.trim()) {// if item don't have whitespace
            continue;
        }
        var itemArray = item.trim().split("\t");// item delete whitespace and  split to array by tab
        html += ' <tr><td>' + itemArray[0] + '</td><td class="last">' + itemArray[1] + '</td></tr>';
    }
    $("#tbl_detail tbody").html(html);
}

var showPhoto = function(photoList) {
    var index = 1;
    for(var item of photoList) {// browse all photo of a a product
        if(item.default) {// if item is a default photo is add that picture to attributes has nominated id
            $("#main_photo").attr("data-thumb", item.photo);
            $("#main_photo a").attr("href", item.photo);
            $("#main_photo img").attr("data-large_image", item.photo);
            $("#main_photo img").attr("data-src", item.photo);
            $("#main_photo img").attr("src", item.photo);
            $(".is-nav-selected img").attr("src", item.photo);
        } else {
            $("#photo_" + index).attr("src", item.photo);
            $("#photo_" + index).attr("srcset", item.photo);
            $("#slide_" + index).attr("data-thumb", item.photo);
            $("#slide_" + index + " a").attr("href", item.photo);
            $("#slide_" + index + " img").attr("data-large_image", item.photo);
             $("#slide_" + index + " img").attr("data-src", item.photo);
             $("#slide_" + index + " img").attr("src", item.photo);
             $("#slide_" + index + " img").attr("srcset", item.photo);
            index++;
        }
    }
}

var showDesciption = function(description){
    $("#information-detail").html(description);
}

var showCategoryLink = function(product) {
    $("#nav_product a:eq(1)").text(product.categoryDetail.category.name);
    $("#nav_product a:eq(1)").attr('href', 'category/' + product.categoryDetail.category.id);
    $("#nav_product a:eq(2)").text(product.categoryDetail.name);
    $("#nav_product a:eq(2)").attr('href', 'category-detail/' + product.categoryDetail.id);
}

var handleForVariants = function(variantList) {
    if(variantList.length == 0) {
        $('.variations_form').remove();
        return;
    }
    var html = '<option value="">Chọn một tùy chọn</option>';
    for(var item of variantList) {
        html += '<option value="' + item.id + '" data-price="'  + item.price + '">' + item.name + '</option>';
    }
    $('#cbo_variant').html(html);
    $('#add_cart').addClass('disabled');
    $('#cbo_variant').change(function() {
        changeVariant($(this).val(), $(this).find('option:selected').data('price'));
    })
}

var changeVariant = function(variantId, price) {
    if(variantId) {
        $('#add_cart').removeClass('disabled');
        $('#product_price').text(formatNumber(parseFloat(price)));
    } else {
        $('#add_cart').addClass('disabled');
    }
}

$('#plus_button').click(function() {
    var currentQuantity = parseInt($('#product_quantity').val());
    $('#product_quantity').val(currentQuantity + 1);
})

$('#minus_button').click(function() {
    var currentQuantity = parseInt($('#product_quantity').val());
    if(currentQuantity > 1) {
        $('#product_quantity').val(currentQuantity - 1);
    }
})

$('#add_cart').click(function() {
    if($(this).hasClass('disabled')) {
        alert('Hãy chọn 1 màu tương ứng');
    } else {
        addToCart();
    }
})