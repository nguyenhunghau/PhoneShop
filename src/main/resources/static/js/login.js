var login = function() {
    if(!$('#txt_username').val() || !$('#txt_password').val() ) {
        alert('Fill up all information  please');
        return;
    }

    var user = {
            username: $('#txt_username').val(),
            password: $('#txt_password').val()
        }
     $.ajax({url: "user/login", type: "POST", contentType: 'application/json', data: JSON.stringify(user), success: function(result){ // go to category-date to get data from model
             if(result == 'fail') {
                alert('Sai username hoặc password');
             } else {
                sessionStorage["sessionId"] = result;
                location.href = "home";
             }
     }});
}

var checkUserLogin = function() {
    var sessionId = sessionStorage["sessionId"];
    if(sessionId) {
        $.ajax({url: "user/getUser?session-id=" + sessionId, success: function(result){
            console.log(result);
            $('#user_login').text(result.username);
        }});
    }
}

$('#btn_login').click(function() {
    login();
});