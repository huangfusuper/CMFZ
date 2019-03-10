<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

        <script>
            $(function () {
                $('#userFindAllTable').edatagrid({
                    url: '${pageContext.request.contextPath}/user/findAll',
                    columns:[[
                        {field:'userName',title:'用户名',width:1,align:'center'},
                        {field:'password',title:'用户密码',width:1,align:'center'},
                        {field:'name',title:'用户真实姓名',width:1,align:'center'},
                        {field:'nickName',title:'用户昵称',width:1,align:'center'},
                        {field:'sex',title:'用户性别',width:1,align:'center'},
                        {field:'time',title:'注册时间',width:1,align:'center'},
                        {field:'address',title:'用户地址',width:1,align:'center'},
                        {field:'imgPath',title:'用户头像',width:1,align:'center'},
                        {field:'sign',title:'用户签名',width:1,align:'center'},
                        {
                            field:'level',title:'用户状态',width:1,align:'center',editor:{
                                type:"text",
                                options:{
                                    required:true
                                }
                            }

                        }
                    ]],
                    pagination:true,
                    fitColumns:true,
                    view: detailview,
                    detailFormatter: function(rowIndex, rowData) {
                        var tr="";
                        for(var i=0;i<rowData.lessons.length;i++){
                            var content = "";
                            var s = JSON.stringify(rowData.lessons[i]);
                            content="<div data-options='plain:false' onclick='findOne("+s+")' style='width:96%;margin: 3px 0px 3px 0px;border: 1px #95B8E7 solid;' class='easyui-linkbutton'>"+rowData.lessons[i].name+"</div>"
                            tr+="<tr>" +
                                "<th>"+content+"</th>" +
                                "</tr>"
                        }
                        return "<table style='width: 100%' border='0px' cellspacing='0px' align='center'>" +
                            ""+tr+"" +
                            "</table>"
                    },
                    striped:true,
                    toolbar:"#userbut"
                })
                $("#userFindOneView").dialog({
                    title:"查看单个用户",
                    width:700,
                    height:600,
                    cache:false,
                    closed:true
                })



                //修该按钮初始化
                $("#updateuserBut").linkbutton({
                    onClick:function () {
                        var row = $("#userFindAllTable").edatagrid("getSelected");
                        if(row==null){
                            alert("必须选中一个数据")
                        }else{
                            if(row.level==0){
                                alert("此用户已经是冻结对象")
                            }else{
                                $.get(
                                    "${pageContext.request.contextPath}/user/update",
                                    "id="+row.id+"&level="+0,
                                    function () {
                                        $("#userFindAllTable").edatagrid("reload")
                                    }
                                )


                            }
                        }
                    },
                    plain:true
                })
                //解封按钮初始化
                $("#saveuserBut").linkbutton({
                    onClick:function () {
                        var row = $("#userFindAllTable").edatagrid("getSelected");
                        if(row==null){
                            alert("必须选中一个数据")
                        }else{
                            if(row.level==1){
                                alert("此用户不需要解封")
                            }else{
                                $.get(
                                    "${pageContext.request.contextPath}/user/update",
                                    "id="+row.id+"&level="+1,
                                    function () {
                                        $("#userFindAllTable").edatagrid("reload")
                                    }
                                )
                            }
                        }
                    },
                    plain:true
                })



                $("#ExcelExmopt").linkbutton({
                    plain:true,
                    onClick:function () {
                        $("#custom_dialog").dialog("open")
                    }
                })
                
                $("#treeSubmit").linkbutton({
                    onClick:function () {
                         var a = $("#getComboxcc").combotree("getText")
                         var b = $("#getComboxcc").combotree("getValues")
                        var c =""
                        $.each(b,function (idx,cc) {
                            if(idx!=b.length-1){
                                c+=cc+","
                            }else{
                                c+=cc
                            }

                        })
                         $("#treeForm").form("submit",{
                             queryParams:{"titles":a,"values":b},
                             url:"${pageContext.request.contextPath}/user/customerExport",
                             success:function () {
                                 $("#custom_dialog").dialog("close")
                             }

                         })
                    }
                })

            })
            function findOne(s) {
                for(var i=0;i<s.counts.length;i++){
                    var spanName = $("<span style='size: 20px' />").text("计数器名称："+s.counts[i].name).append("<br/>")
                    var spanCount = $("<span style='size: 20px' />").text("功课数量："+s.counts[i].count).append("<hr/>")
                    $("#userFindOneView").append(spanName).append(spanCount)
                }
                $("#userFindOneView").dialog("open")
            }
        </script>
        <table id="userFindAllTable"></table>
        <div style="text-align: center"  id="userFindOneView">
            <h1>功课计数器</h1>
        </div>
<div id="userbut">
    <a style="width: 33%" id="updateuserBut">冻结用户</a>
    <a style="width: 33%" id="ExcelExmopt">自定义导出Excel</a>
    <a style="width: 33%" id="saveuserBut">恢复用户</a>
</div>



<div id="custom_dialog" class="easyui-dialog" title="My Dialog" style="width: 400px;height: 200px;"
    data-options="iconCls:'icon-save',resizable:true,closed:true">
<div style="text-align: center;">
    <form  id="treeForm" method="post">
        <h1>自定义导出</h1>
        <select id="getComboxcc" class="easyui-combotree" style="width: 200px;" data-options="url:'${pageContext.request.contextPath}/comboTree/comboTree.jsp',requuired:true,onlyLeafCheck:true,multiple:true"></select><br/>
        <a id="treeSubmit" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确认提交</a>
    </form>
</div>
</div>