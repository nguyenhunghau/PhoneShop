var loadData = function () {
    $.ajax({url: "product/important" , success: function(result){
        console.log(result);
        showMobilePhone(result[0]);
        showLaptop(result[1]);
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