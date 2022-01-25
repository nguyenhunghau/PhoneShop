$('#filter_price').click(function () {
    filterPrice();
})

var getCategory = function () {
    $.ajax({url: "category-data", success: function(result){ // go to category-date to get data from model
        console.log(result);
        showCategory(result);
        showCategoryLeft(result);
    }});
}

var showCategory = function(categoryList) {
    var html = '';
    for(var item of categoryList) {
        html += '<li class="menu-item menu-item-type-taxonomy menu-item-object-product_cat  menu-item-446"'
                    +  'id="menu-item-446">'
                    +  '<a class="menu-image-title-after menu-image-not-hovered nav-top-link" '
                    +  'href="category?id=' +  item.id + '"><img alt="" '
                    +  'class="menu-image menu-image-title-after" '
                    +  'height="24" '
                    +  'sizes="(max-width: 24px) 100vw, 24px" '
                    +  'src="' + item.photo + '" srcset="" '
                    +  'width="24"/><span class="menu-image-title">' + item.name + '</span></a></li>';
    }
    $('#ul_category').html(html);
}

var getProductByCategory = function(sort) {
    var params = new URLSearchParams(window.location.search);
    var id = params.get('id');
    var url = "product?category-id=" + id;
    if(sort) {
        url += "&sort=" + sort;
    }
    $.ajax({url: url, success: function(result){
        console.log(result);
        showProduct(result);
    }});
}

var showProduct = function(productList) {
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
            $('#div_product').html('');
        }
        $productItem.show();
        $('#div_product').append($productItem);
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

var showCategoryLeft = function(categoryList) {
    var html = '';
    var params = new URLSearchParams(window.location.search);
    var idParam = params.get('id');

    for(var item of categoryList) {
        var focusClass= '';
        if(item.id == parseInt(idParam)) {
            focusClass= 'current-menu-item';
        }
        html += '<li class="menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-446 ' + focusClass + '">'
        + '<a href="category?id=' +  item.id + '" data-id="' +  item.id + '" class="menu-image-title-after menu-image-not-hovered">'
        + '<img width="24" height="24" src="' + item.photo + '" class="menu-image menu-image-title-after" alt="" srcset="" sizes="(max-width: 24px) 100vw, 24px" />'
        + '<span class="menu-image-title">' + item.name + '</span></a></li>';
    }
    $('#main_menu').html(html);
}

var filterPrice = function() {
    var maxPrice = parseFloat($('#max_price').val());
    var minPrice = parseFloat($('#min_price').val());

    $('.product-item').each(function() {
        var price = $(this).find('.woocommerce-Price-amount').data('price');
        if(price >= minPrice && price <= maxPrice) {
            $(this).show();
        } else {
            $(this).hide();
        }
    })
}

$('.header-nav .cart-item').hover(
  function() {
    $(this).addClass('current-dropdown');
  }, function() {
    $(this).removeClass('current-dropdown');
  }
);