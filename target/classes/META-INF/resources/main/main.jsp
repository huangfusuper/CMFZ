<%@ page import="com.baizhi.entity.Admin" %>
<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script src="${pageContext.request.contextPath}/easyui/echarts/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/easyui/echarts/china.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.edatagrid.js"></script>


    <script>
        <%
            Admin admin = (Admin) session.getAttribute("admin");
            if(admin == null){
        %>
                window.location.href = '${pageContext.request.contextPath}/admin/login.jsp'
        <%
            }
        %>
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true,height:100" style="height:60px;background-color:#5C160C">
        <div style="font-size: 30px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
        <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 400px;float:right;padding-top:15px">
            欢迎您:${sessionScope.admin.name} &nbsp;
            <a href="${pageContext.request.contextPath}/admin/exitAdmin" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
        </div>
    </div>
    <div data-options="href:'${pageContext.request.contextPath}/main/left.jsp',width:260,region:'west',title:'导航栏',split:true,iconCls:'icon-more',collapsedSize:22"></div>
    <div data-options="href:'${pageContext.request.contextPath}/main/tabs.jsp',region:'center',split:true"></div>
</body>
</html>
