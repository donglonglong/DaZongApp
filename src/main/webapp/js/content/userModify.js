$(function() {
	common.showMessage($("#message").val());
	$("#mainForm").validate({
		rules : {
			"title" : "required",
			"link" : "required",
			"weight" : {
				required : true,
				digits : true,
				maxlength : 5
			}
		},
		messages : {
            "title" : "请输入标题",
            "link" : "请输入超链接",
            "weight" : {
                required : "",
                digits : "",
                maxlength : ""
            }
		}
	});
});

function modify() {
	$("#mainForm").submit();
}

function goback() {
	location.href = $('#basePath').val() + '/ad';
}