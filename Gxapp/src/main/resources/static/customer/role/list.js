var $table = $("#table1");
$(function() {
	/*
	 * $("#btn").on('click', function () { // $table.bootstrapTable("refresh")
	 * resh(); });
	 */
	var $table = $("#table1");
	$table.bootstrapTable({
		url : "role/list?rad=" + new Date().getTime(),
		columns : tableColumns(),
		method : 'get',
		idField : "rId",
		// 请求方式（*）
		// toolbar: '#toolbar', //工具按钮用哪个容器
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sortable : false, // 是否启用排序
		sortOrder : "asc", // 排序方式
		queryParams : qp,// 传递参数（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 2, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）

	});
	setTimeout(function() {
		$table.bootstrapTable('resetView');
	}, 200);
});
function qp(params) {
	// params.s_name = $('#name').val();
	params.sjs = new Date().getTime();
	console.log(params);
	return params;
}
function resh() {
	$table.bootstrapTable("refresh");
}
function tableColumns() {
	return [ [ {
		checkbox : true,
		width : "30px",
	}, {
		field : 'rName',
		title : '账户名',
		width : "200px",
		align : 'center',
		valign : 'middle'
	}, {
		field : 'rDescription',
		title : '账户名',
		width : "200px",
		align : 'center',
		valign : 'middle'
	}, {
		field : 'rCreateTime',
		title : '账户名',
		width : "200px",
		align : 'center',
		valign : 'middle'
	}
	] ]
}