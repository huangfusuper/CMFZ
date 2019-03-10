
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $("#tabs").tabs({
            fit:true
        });
    })
</script>
<%--创建面板基础标签--%>
<div id="tabs">
    <div  style="background-image:url(${pageContext.request.contextPath}/main/img/t.jpg);background-repeat: no-repeat;background-size:100% 100%;" data-options="title:'欢迎光临'"></div>
</div>

