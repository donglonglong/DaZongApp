$(function() {
	common.showMessage($("#message").val());
});

function search(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

function remove(id) {
	if(confirm("确定要删除这条广告吗?")) {
		$("#id").val(id);
		$("#mainForm").attr("action",$("#basePath").val() + "/user/remove");
		$("#mainForm").submit();
	}
}

function modifyInit(id) {
	$("#id").val(id);
	$("#mainForm").attr("action",$("#basePath").val() + "/user/modifyInit");
	$("#mainForm").submit();
}