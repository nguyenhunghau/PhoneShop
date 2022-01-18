var loadData = function () {
    var params = new URLSearchParams(window.location.search);
    var id = params.get('id');
    $.ajax({url: "product/" + id, success: function(result){
        console.log(result);
        $("#product_title").text(result.name);
         $("#product_price").text(result.price);
        showParameter(result.parameter);
        showInfoDetail(result.detail);
        showPhoto(result.productphotoList);
        showDesciption(result.description);
        showCategoryLink(result);
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
        if(!item.trim()) {
            continue;
        }
        var itemArray = item.trim().split("\t");
        html += ' <tr><td>' + itemArray[0] + '</td><td class="last">' + itemArray[1] + '</td></tr>';
    }
    $("#tbl_detail tbody").html(html);
}

var showPhoto = function(photoList) {
    var index = 1;
    for(var item of photoList) {
        if(item.default) {
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