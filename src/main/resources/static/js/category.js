var getCategory = function () {
    $.ajax({url: "category-data", success: function(result){ // go to category-date to get data from model
        console.log(result);
        showCategory(result);
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

