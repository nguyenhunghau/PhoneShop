

var loadData = function () {
    $.ajax({url: "product/getAll", success: function(result){// use id to return a object
        console.log(result);
        showListProduct(result);
    }});
}

var showListProduct = function(productList) {
    var html = '';
    for(var item of productList) {
        html += '<tr id="row-' + item.id + '"><td>' + item.id + '</td><td>'
        + item.name + '</td><td>' + item.parameter + '</td><td>' + item.categoryDetail.name
        + '</td><td>' + item.producer.name + '</td><td>' + item.price
        + '</td><td>' + item.productLaunchDate + '</td><td><a class="btn btn-default" href="admin-add-product?id='
        + item.id + '">Edit</a><a class="btn btn-default" onclick="deleteProduct('
                                   + item.id + ')">Delete</a></td></tr>'
    }
    $('#tbl_product tbody').html(html);
}

var deleteProduct = function(productId) {
    $.ajax({url: "product/" + productId, type: "DELETE", success: function(result){ // go to category-date to get data from model
         if(result) {
            alert('Delete product successfully');
            $('#row-' + productId).remove();
        } else {
            alert('Error when delete product');
        }
    }});
}