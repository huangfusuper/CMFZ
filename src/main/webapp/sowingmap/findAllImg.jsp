
<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
    <script>
        $(function () {
            //初始化表格
            $("#imgFindAllTable").edatagrid({
                url:"${pageContext.request.contextPath}/sowingMap/findAllPage",
                updateUrl:"${pageContext.request.contextPath}/sowingMap/updateData",
                destroyUrl:"${pageContext.request.contextPath}/sowingMap/removeOneDataByID",
                columns:[[
                    {field:'name',title:'图片名称',width:1,align: 'center'},
                    {
                        field:'level',title:'轮播图状态',width:1,editor:{
                            type:"text",
                            options:{
                                required:true
                            }
                        }
                    },
                    {field:'url',title:'图片路径',width:1,align:'center'},
                    {field:'date',title:'上传时间',width:1,align:'center'},
                    {field:'xx',align:'center',formatter:opent,title:'操作'}
                ]],
                fitColumns:true,
                striped:true,
                pagination:true,
                rownumbers:true,
                pageSize:5,
                pageList:[5,10,15,20,25],
                toolbar:"#imgBut",
                view:detailview,
                detailFormatter:function (rowIndex,rowData) {
                    return "<table border='4px' cellspacing='0px'>" +
                        "<tr>" +
                            "<td rowspan=2 style='border: 0px'><img style='width: 20%;height: 20%' src=\"../main/img/upload/"+rowData.url+"\"/></td>" +
                            "<td style='border: 1px;'>" +
                                "<p>图片名称："+rowData.name+"</p>" +
                                "<p>图片上传时间:"+rowData.date+"</p>" +
                                "<p>图片状态:"+rowData.level+"</p>" +
                            "</td>"+
                        "</tr>" +
                        "</table>"
                }

            })

            //初始化添加按钮
            $("#addImgBut").linkbutton({
                onClick:function () {
                    $("#addImgdialogView").dialog("open")
                },
                plain:true
            })
            //初始化修改按钮
            $("#updateImgBut").linkbutton({
                onClick:function () {
                    var row = $("#imgFindAllTable").edatagrid("getSelected");
                    if(row==null){
                        alert("必须选中一个数据")
                    }else{

                        $("#imgFindAllTable").edatagrid("editRow",$("#imgFindAllTable").edatagrid("getRowIndex",row))
                    }
                },
                plain:true
            })
            //初始化保存按钮
            $("#saveImgBut").linkbutton({
                onClick:function () {
                    $("#imgFindAllTable").edatagrid("saveRow")
                },
                plain:true
            })
            //初始化添加对话框
            $("#addImgdialogView").dialog({
                title:"上传轮播图",
                href:'${pageContext.request.contextPath}/sowingmap/addImg.jsp',
                width:500,
                height:400,
                cache:false,
                closed:true
            })


        })
        function opent(value,row,index) {
            return "<a class='l-btn' onclick='removeimg(\""+row.id+"\",\""+row.url+"\")' >删除</a>";
        }

        //删除
        function removeimg(id,name) {
            $.messager.alert({
                title:"警告",
                msg:"确认删除?",
                icon:"warning",
                fn:function () {
                    $.get(
                        "${pageContext.request.contextPath}/sowingMap/removeOneDataByID",
                        "id="+id+"&fileName="+name,
                        function () {
                            $.messager.show({
                                title:"提示",
                                msg:"删除成功"
                            })

                            $("#imgFindAllTable").datagrid("reload")
                        }
                    )
                }
            })
        }
    </script>
    <table id="imgFindAllTable"></table>
    <%--定义工具栏--%>
    <div id="imgBut">
        <a style="width: 33%;border: 1px #95A8E7 solid;" id="addImgBut">添加</a>
        <a style="width: 33%;border: 1px #95A8E7 solid;" id="updateImgBut">修改</a>
        <a style="width: 33%;border: 1px #95A8E7 solid;" id="saveImgBut">保存</a>
    </div>
    <div id="addImgdialogView"></div>
