var createAccount = function() {
    if(!$('#txt_firstname').val() || !$('#txt_lastname').val() || !$('#txt_username').val()
        || !$('#txt_password').val() || !$('#txt_email').val() || !$('#cbo_gender').val()) {
        alert('Fill up all information  please');
        return;
    }
    if($('#txt_password').val() != $('#txt_password_confirm').val()) {
        alert('Password does not match with the password confirm');
        return;
    }

    var user = {
            firstname: $('#txt_firstname').val(),
            lastname: $('#txt_lastname').val(),
            username: $('#txt_username').val(),
            password: $('#txt_password').val(),
            email: $('#txt_email').val(),
            gender: $('#cbo_gender').val() === 'male'
        }
     $.ajax({url: "user/register", type: "POST", contentType: 'application/json', data: JSON.stringify(user), success: function(result){ // go to category-date to get data from model
             console.log(result);
             if(result) {
                 alert('Đặt kí thành công');
                 location.href = "login";
             }
     }});
}

$('#btn_register').click(function() {
    createAccount();
});