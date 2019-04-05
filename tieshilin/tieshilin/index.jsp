<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<% request.setAttribute("ctx",request.getContextPath()); %> 
<link rel="stylesheet" type="text/css" href="${ctx }/resource/js/jquery-easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx }/resource/js/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${ctx }/resource/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/resource/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx }/resource/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
$(function(){ 
	//查询所有数据表格
	$('#info').datagrid({
		pagination:true,
	    url:"${ctx}/computer/findAllList.do",
	    columns:[[
	        {field:'bh',title:'编号',width:100},
	        {field:'mc',title:'名称',width:100},
	        {field:'js',title:'介绍',width:100},
	        {field:'jg',title:'价格',width:100},
	        {field:'ssrq',title:'上市日期',width:100}
	    ]],height:360
	});  

});
//条件查询
function toSelect(){
	 $("#info").datagrid("load",{
		 mc:$("#mc").textbox("getValue"),
		 statSssj:$("#statSssj").datebox("getValue"),
		 endSssj:$("#endSssj").datebox("getValue"),
		 statJg:$("#statJg").textbox("getValue"),
		 endJg:$("#endJg").textbox("getValue")
	 });
}

</script>
<style type="text/css">
.ziti{
	font-size:20px;
}
</style>
</head>
<body>   
   <div class="easyui-panel" title="电脑明细查询">
		<form id="selForm"><table>
			<tr>
				<td class="ziti" align="right">名称：</td>
				<td><input id="mc" name="mc" class="easyui-textbox"></td>
			</tr>
			<tr>
				<td class="ziti" align="right">上市时间：</td>
				<td><input id="statSssj" name="statSssj" class="easyui-datebox">~<input id="endSssj" name="endSssj" class="easyui-datebox"></td>
			</tr>
			<tr>
				<td class="ziti" align="right">价格：</td>
				<td><input id="statJg" name="statJg" class="easyui-textbox">~<input id="endJg" name="endJg" class="easyui-textbox"></td>
			
				<td colspan="2" align="right"><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:toSelect()">查询</a></td>
			</tr>
		</table></form>
	</div>
	
	<table id="info"></table>
</body> 
</html>