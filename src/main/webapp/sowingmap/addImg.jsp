<%@ page isELIgnored="false"  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {

        $("#uploadImgBut").linkbutton({
            onClick:function () {
                $("#addImgFrom").form("submit",{
                    url:"${pageContext.request.contextPath}/sowingMap/upload",
                    onSubmit:function () {
                        return $("#addImgFrom").form("validate");
                    },
                    success:function () {
                        $.messager.show({
                            title:"提示",
                            msg:"上传成功"
                        })
                        $("#addImgdialogView").dialog("close")
                        $("#imgFindAllTable").datagrid("reload")
                    }
                })
            }
        })

        $("#imgName").textbox({
            required:true,
            width:250
        })
        $("#uploadFileImg").filebox({
            required:true,
            buttonText:"浏览",
            buttonIcon:"icon-search",
            width:250
        })
    })
</script>
<div style="text-align: center">
    <h1>文件上传</h1>
<form id="addImgFrom" enctype="multipart/form-data" method="post">
    图片名称:<input id="imgName" name="name"/><br/><br/>
    选择文件:<input id="uploadFileImg" name="file"/><br/><br/>
    <a id="uploadImgBut">上传文件</a>
</form>
</div>

