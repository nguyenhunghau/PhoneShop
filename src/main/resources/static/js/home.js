var loadData = function () {
    $.ajax({url: "product/important" , success: function(result){
        console.log(result);
        showMobilePhone(result[0]);
        showLaptop(result[1]);
        showTablet(result[4]);
        showAccessory(result[5]);
    }});
}
var loadCompanyPhoto = function(){
 $.ajax({url: "/producer-data" , success: function(result){
        console.log(result);
        var index = 0;
        for(var item of result){
            if(item.photo != null){
                var $imageItem = $(".company-picture-item:eq(0)").clone();
                 $imageItem.find('.link-product img:eq(0)').attr('src', item.photo);
                 $imageItem.find('.link-product img:eq(0)').attr('srcset', '');
                  $imageItem.show();
                  if(index == 0) {
                     $('#company-picture').html('');
                  }
                  index++;
                $('#company-picture').append($imageItem);
            }

        }

    }});
}

var showMobilePhone = function(importantProduct) {
    var category = importantProduct.category;
    var productList = importantProduct.productList;
    var index = 0;
    for(var item of productList) {
        var $productItem = $('.product-item:eq(0)').clone();
        $productItem.find('.link-product').attr('href', 'product-detail?id=' + item.id);
        var mainPhoto = getMainPhoto(item);
        var hoverPhoto = getHoverPhoto(item);
        $productItem.find('.link-product img:eq(0)').attr('src', mainPhoto);
        $productItem.find('.link-product img:eq(1)').attr('src', hoverPhoto);
        $productItem.find('.link-product img:eq(0)').attr('srcset', '');
        $productItem.find('.link-product img:eq(1)').attr('srcset', '');
        $productItem.find('.woocommerce-Price-amount').html(formatNumber(item.price) + '&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span>');
        $productItem.find('.woocommerce-Price-amount').data('price', item.price);
        $productItem.find('.link-product:eq(1)').text(item.name);
        if(index == 0) {
            $('#phone-product').html('');
        }
        $productItem.show();
        $('#phone-product').append($productItem);
        index++;
    }
}

var showLaptop = function(importantProduct) {
    var category = importantProduct.category;
    var productList = importantProduct.productList;
    var index = 0;
    for(var item of productList) {
        var $productItem = $('.laptop-item:eq(0)').clone();
        $productItem.find('.link-product').attr('href', 'product-detail?id=' + item.id);
        var mainPhoto = getMainPhoto(item);
        var hoverPhoto = getHoverPhoto(item);
        $productItem.find('.link-product img:eq(0)').attr('src', mainPhoto);
        $productItem.find('.link-product img:eq(1)').attr('src', hoverPhoto);
        $productItem.find('.link-product img:eq(0)').attr('srcset', '');
        $productItem.find('.link-product img:eq(1)').attr('srcset', '');
        $productItem.find('.woocommerce-Price-amount').html(formatNumber(item.price) + '&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span>');
        $productItem.find('.woocommerce-Price-amount').data('price', item.price);
        $productItem.find('.link-product:eq(1)').text(item.name);
        if(index == 0) {
            $('#laptop-product').html('');
        }
        $productItem.show();
        $('#laptop-product').append($productItem);
        index++;
    }
}


var showTablet = function(importantProduct) {// xem-  hiểu lại hàm này
    var category = importantProduct.category;
    var productList = importantProduct.productList;
    var index = 0;
    for(var item of productList) {
        var $productItem = $('.tablet-item:eq(0)').clone();
        $productItem.find('.link-product').attr('href', 'product-detail?id=' + item.id);
        var mainPhoto = getMainPhoto(item);
        var hoverPhoto = getHoverPhoto(item);
        $productItem.find('.link-product img:eq(0)').attr('src', mainPhoto);
        $productItem.find('.link-product img:eq(1)').attr('src', hoverPhoto);
        $productItem.find('.link-product img:eq(0)').attr('srcset', '');
        $productItem.find('.link-product img:eq(1)').attr('srcset', '');
        $productItem.find('.woocommerce-Price-amount').html(formatNumber(item.price) + '&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span>');
        $productItem.find('.woocommerce-Price-amount').data('price', item.price);
        $productItem.find('.link-product:eq(1)').text(item.name);
        if(index == 0) {
            $('#tablet-product').html('');
        }
        $productItem.show();
        $('#tablet-product').append($productItem);
        index++;
    }
}

var showAccessory = function(importantProduct) {
    var category = importantProduct.category;
    var productList = importantProduct.productList;
    var index = 0;
    for(var item of productList) {
        var $productItem = $('.accessory-item:eq(0)').clone();
        $productItem.find('.link-product').attr('href', 'product-detail?id=' + item.id);
        var mainPhoto = getMainPhoto(item);
        var hoverPhoto = getHoverPhoto(item);
        $productItem.find('.link-product img:eq(0)').attr('src', mainPhoto);
        $productItem.find('.link-product img:eq(1)').attr('src', hoverPhoto);
        $productItem.find('.link-product img:eq(0)').attr('srcset', '');
        $productItem.find('.link-product img:eq(1)').attr('srcset', '');
        $productItem.find('.woocommerce-Price-amount').html(formatNumber(item.price) + '&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span>');
        $productItem.find('.woocommerce-Price-amount').data('price', item.price);
        $productItem.find('.link-product:eq(1)').text(item.name);
        if(index == 0) {
            $('#accessory-product').html('');
        }
        $productItem.show();
        $('#accessory-product').append($productItem);
        index++;
    }
}


var getMainPhoto = function(product) {
    for(var item of product.productphotoList) {
        if(item.default) {
            return item.photo;
        }
    }
    return '';
}

var getHoverPhoto = function(product) {
    for(var item of product.productphotoList) {
        if(!item.default) {
            return item.photo;
        }
    }
    return '';
}

var getSlides = function() {
    $.ajax({url: "product/slides" , success: function(result){
        showSlides(result);
    }});
}

var showSlides = function(showSlides) {
    var index = 0;
    for(var item of showSlides) {
        var $slideItem = $('.slide-item:eq(0)').clone();
        $slideItem.find('img').attr('src', item.photo);
        if(index == 0) {
            $('#slides').html('');
        }
        $slideItem.show();
        $('#slides').append($slideItem);
        index++;
    }
}

var showWatchedProduct = function() {
    var watchedProduct = [];
    if(localStorage['watchedProduct']) {
        watchedProduct = $.parseJSON(localStorage['watchedProduct']);
    }
    var index = 0;
    for(var item of watchedProduct) {
        var $slideItem = $('.watched-item:eq(0)').clone();
        $slideItem.find('img:eq(0)').attr('src', item.mainPhoto);
        $slideItem.find('img:eq(1)').attr('src', item.hoverPhoto);
        $slideItem.find('.watched-link').attr('href', 'product-detail?id=' + item.id);
        if(item.promotion) {
            $slideItem.find('.badge-circle').show();
        }
        if(index == 0) {
            $('#watched_product').html('');
        }
        $slideItem.show();
        $('#watched_product').append($slideItem);
        index++;
    }
}