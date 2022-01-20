var getCategoryDetail = function () {
    $.ajax({url: "category-detail-data", success: function(result){
        console.log(result);
        showCategoryDetail(result);
    }});
}

var showCategoryDetail = function(categoryDetailList){
     var html = '';
     for (var item of categoryDetailList){
     html += ' <a aria-label="Bao da - Ốp lưng - Dán màn hình (2 mục)"'
               + 'class="tag-cloud-link tag-link-47 tag-link-position-2"'
               + 'href="categoryDetail?id='+ item.id +'"'
               + 'style="font-size: 11.111111111111pt;"> ' + item.name +'</a>';
     }
     $('#div_categoryDetail').html(html);
}