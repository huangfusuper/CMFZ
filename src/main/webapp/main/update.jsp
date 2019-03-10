<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $("#updatePaaword").linkbutton({
            onClick:function () {
                $("#updateadmin").form("submit",{
                    url:"${pageContext.request.contextPath}/admin/update",
                    onSubmit:function () {
                        return  $("#updateadmin").form("validate");
                    },
                    success:function () {
                        $.messager.show({
                            title:"修改成功",
                            msg:"修改成功"
                        })
                    }
                })
            }
        })

        $("#textPassword").textbox({
            required:true
        })
    })
</script>
<form id="updateadmin">
    <input name="id" value="${sessionScope.admin.id}" type="hidden"/><br/>
    请输入新密码：<input id="textPassword" name="password"/><br/>
    <a id="updatePaaword">修改密码</a>
</form>