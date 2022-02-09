var showCartList = function()  {
    var productList = [];
    if(localStorage['productCart']) {
        productList = $.parseJSON(localStorage['productCart']);
    }
    var html = '';
    for(var item of productList) {
        html += '<tr class="cart_item">'
                     + '<td class="product-name">'
                     + item.name + ' - ' + (item.variantName || '') + '&nbsp;<strong class="product-quantity">&times; ' + item.quantity + '</strong></td>'
                     + '<td class="product-total">'
                     + '    <span class="woocommerce-Price-amount amount">' + formatNumber(item.quantity * item.price) + '&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></td>'
                 + '</tr>';
    }
    $('#tbl_billing tbody').html(html);
    $('.total-price').html(formatNumber(getTotalMoney(productList)) + '&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span>');
}

var getTotalMoney = function(productList) {
    var total = 0;
    for(var item of productList) {
        total += item.quantity * item.price;
    }
    return total;
}

var createOrder = function() {
    var user = {
        firstname: $('#first_name').val(),
        lastname: $('#last_name').val(),
        email: $('#billing_email').val(),
        gender: $('#gender').val() === 'true'
    }

    var order = {
        address: $('#billing_address_1').val() + ' ' + $('#billing_city').val() + ' ' + $('#billing_country option:selected').text(),
        orderDetailList: createOrderDetailList()
    }

    var billingOrder = {user: user, order: order};
    $.ajax({url: "order", type: "POST", contentType: 'application/json', data: JSON.stringify(billingOrder), success: function(result){ // go to category-date to get data from model
        console.log(result);
        if(result) {
            alert('Đặt hàng thành công');
        }
    }});

}

var createOrderDetailList = function() {
    var productList = [];
    var orderDetailList = [];
    if(localStorage['productCart']) {
        productList = $.parseJSON(localStorage['productCart']);
    }
    for(var item of productList) {
        var orderDetail = {productId: item.id, quantity: item.quantity};
        if(item.variantId) {
            orderDetail['variantId'] = item.variantId;
        }
        orderDetailList.push(orderDetail);
    }
    return orderDetailList;
}

$('#btn_order').click(function() {
    createOrder();
})

showCartList();