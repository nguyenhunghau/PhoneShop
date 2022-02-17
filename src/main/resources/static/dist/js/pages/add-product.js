$('#upload_single').click(function(event) {
    // You can directly create form data from the form element
    // (Or you could get the files from input element and append them to FormData as we did in vanilla javascript)
    var formData = new FormData();
    formData.append("file", $('#main_photo')[0].files[0]);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/uploadFile",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            console.log(response);
            $('#img_main').attr('src', response.fileDownloadUri);
        },
        error: function (error) {
            console.log(error);
            // process error
        }
    });

    event.preventDefault();
});

$('#upload_multiple').click(function(event) {
    // You can directly create form data from the form element
    // (Or you could get the files from input element and append them to FormData as we did in vanilla javascript)
    var formData = new FormData();
    for(var index = 0; index < $('#other_photo')[0].files.length; index++) {
            formData.append("files", $('#other_photo')[0].files[index]);
    }
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/uploadMultipleFiles",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            console.log(response);
            var html = '';
            for(var item of response) {
                html += '<img class="img-other" src="' + item.fileDownloadUri + '" style="width: 100px; height:50px"/>'
            }
            $('#list_photo').html(html);
        },
        error: function (error) {
            console.log(error);
            // process error
        }
    });

    event.preventDefault();
});
$(document).ready(function() {
    $("#inputDescription").summernote({
        placeholder: "Write your content here",
        height: 200,
    });
});