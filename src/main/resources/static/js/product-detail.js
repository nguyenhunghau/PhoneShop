var loadData = function (id) {
    $.ajax({url: "product/" + id, success: function(result){
        console.log(result);
        $("#product_title").text(result.name);
         $("#product_price").text(result.price);
        showParameter(result.parameter);
        showPhoto(result.productphotoList);
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

var showPhoto = function(photoList) {
    var index = 1;
    for(var item of photoList) {
        if(item.default) {
            $("#main_photo").attr("data-thumb", item.photo);
            $("#main_photo a").attr("href", item.photo);
            $("#main_photo a").attr("data-large_image", item.photo);
            $("#main_photo a").attr("data-src", item.photo);
            $("#main_photo a").attr("src", item.photo);
        } else {
            $("#photo_" + index).attr("src", item.photo);
            index++;
        }
    }
}