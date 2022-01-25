var productCart = [];
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

var addToCart = function () {
    if(localStorage['productCart']) {
        productCart = $.parseJSON(localStorage['productCart']);
    }
    var productInCart = productCart.filter(item => item.id == currentProduct.id);
    if(productInCart) {
        return;
    }
    currentProduct.quantity = parseInt($('#product_quantity').val());
    productCart.push(currentProduct);
    localStorage['productCart'] = JSON.stringify(productCart);
}

var showProductInCart = function() {
    if(productCart.length == 0) {
        $('.mini-cart').hide();
        $('.mini-cart-empty').show();
        return;
    }
    $('.mini-cart').show();
    $('.mini-cart-empty').hide();
    html = '<li class="woocommerce-mini-cart-item mini_cart_item">'
                 + '<a href="" onclick="removeProductInCart(' + currentProduct.id + ')" class="remove remove_from_cart_button" aria-label="Xóa sản phẩm này">×</a>'
                 + '<a href="product-detail?id=' + currentProduct.id + '">'
                 + '    <img width="180" height="180" src="' + getMainPhoto(currentProduct)
                 + '" class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image" alt="" srcset="" sizes="(max-width: 180px) 100vw, 180px">' + currentProduct.name + '&nbsp;'
                 + '</a>'
                 + '<span class="quantity">' + currentProduct.quantity + ' × <span class="woocommerce-Price-amount amount">' + formatNumber(currentProduct.price) + '&nbsp;<span class="woocommerce-Price-currencySymbol">₫</span></span></span>'
             + '</li>';
     $('#cart_List').append(html);
     $('.woocommerce-mini-cart__total').html('<strong>Tổng cộng:</strong> <span class="woocommerce-Price-amount amount">' + formatNumber(getTotalMoney()) + '&nbsp;<span class="woocommerce-Price-currencySymbol">₫</span></span>');
}

var removeProductInCart = function(productId) {
    if(localStorage['productCart']) {
        productCart = $.parseJSON(localStorage['productCart']);
    }
    for(var index in productCart) {
        if(productCart[index].id == productId) {
            productCart.splice(index, 1);
            showProductInCart();
            return;
        }
    }
}

var getTotalMoney = function() {
    var total = 0;
    for(var item of productCart) {
        total += item.quantity * item.price;
    }
    return total;
}

var getMainPhoto = function(product) {
    for(var item of product.productphotoList) {
        if(item.default) {
            return item.photo;
        }
    }
    return '';
}

$('#add_cart').click(function() {
    addToCart();
    showProductInCart();
})