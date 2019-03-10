<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
    <script>
        $(function () {
            $('#guruFindAll').edatagrid({
                url: '${pageContext.request.contextPath}/guru/findAll',
                updateUrl:"${pageContext.request.contextPath}/guru/update",
                columns:[[
                    {field:'name',title:'大师姓名',width:1,align:'center'},
                    {field:'aliasname',title:'上师法名',width:1,align:'center'},
                    {field:'guruImgPath',title:'上师头像',width:1,align:'center'},
                    {
                        field:'level',title:'上师状态',width:1,align:'center',editor:{
                            type:"text",
                            options:{
                                required:true
                            }
                        }

                    }
                ]],
                fitColumns:true,
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    var children = rowData.children;
                    var content = "<tr>" +
                        "<th style='color: red'>文章标题</th>" +
                        "<th style='color: red'>文章上传时间</th>" +
                        "<th style='color: red'>文章详细信息</th>" +
                        "<th style='color: red'>文章路径</th>" +
                        "</tr>";
                    for(var i=0;i<children.length;i++){
                        content+="<tr>" +
                            "<th>"+children[i].name+"</th>" +
                            "<th>"+children[i].date+"</th>" +
                            "<th>"+children[i].detalis+"</th>" +
                            "<th>"+children[i].arUrl+"</th>" +
                            "</tr>";
                    }

                    return "<table style='width: 100%' border='1px' cellspacing='0px' align='center'>"+content+"</table>"
                },
                striped:true,
                toolbar:"#gurubut"
            })
            /*初始化添加上师对话框*/
            $("#addGuruDialog").dialog({
                title:"添加上师",
                width:500,
                height:400,
                cache:false,
                closed:true
            })
            //初始化提交按钮--------------
            $("#guruAddFormSubmit").linkbutton({
                onClick:function () {
                    $.messager.alert({
                        title:"提示",
                        msg:"确认添加信息无误？",
                        icon:"warning",
                        fn:function () {
                            $("#addGuruForm").form("submit",{
                                url: "${pageContext.request.contextPath}/guru/addguru",
                                onSubmit:function () {
                                    return $("#addGuruForm").form("validate");
                                },
                                success:function () {
                                    $.messager.show({
                                        title:"提示",
                                        msg:"添加成功",
                                    })
                                    $('#guruFindAll').edatagrid("reload")
                                    $("#addGuruDialog").dialog("close")
                                }
                            })
                        }
                    })
                }
            })
            //初始化文本框
            $("#guruName").textbox({
                required:true
            })
            $("#gurualiasname").textbox({
                required:true
            })
            $("#guruImgPath").filebox({
                required:true,
                buttonText: '浏览'
            })
            //初始化功能按钮
            $("#addGuruBut").linkbutton({
                onClick:function () {
                    $("#addGuruDialog").dialog("open")
                },
                plain:true
            })
            //差一个按钮初始化
            $("#findOneGuruBut").linkbutton({
                onClick:function () {
                    var row = $('#guruFindAll').edatagrid("getSelected");
                    $("#GuruImgView").attr("src","../main/img/upload/"+row.guruImgPath);
                    $("#GuruNameView").text(row.name)
                    $("#GurualiasnameView").text(row.aliasname)
                    var level = row.level;
                    if(level==0){
                        $("#GuruLeveView").attr("style","color: red");
                        $("#GuruLeveView").text("异常")
                    }else{
                        $("#GuruLeveView").attr("style","color: black");
                        $("#GuruLeveView").text("正常")
                    }
                    $("#findOneGuruView").dialog("open")

                },
                plain:true
            })
            //修改按钮初始化
            $("#updateGuruBut").linkbutton({
                onClick:function () {
                    var row = $("#guruFindAll").edatagrid("getSelected");
                    if(row==null){
                        alert("必须选中一个数据")
                    }else{

                        $("#guruFindAll").edatagrid("editRow",$("#guruFindAll").edatagrid("getRowIndex",row))
                    }
                },
                plain:true
            })
            //上传按钮初始化
            $("#uploadGuruBut").linkbutton({
                onClick:function () {
                    var row = $("#guruFindAll").edatagrid("getSelected");
                   if(row==null){
                       alert("请选择上师")
                   }else{
                       $("#ArticleFormID").attr("value",row.id);
                       $("#addArticleView").dialog("open")
                   }
                },
                plain:true
            })
            //初始化上传文章的文本框
            $("#ArticleFormName").textbox({
                required:true
            })
            $("#Articleupload").filebox({
                required:true,
                buttonText: '浏览'
            })
            //详情文本框
            $("#Articledetalis").textbox({
                required:true,
                height:100,
                //允许多行
                multiline:true
            })

            //初始化详细面板
            $("#findOneGuruView").dialog({
                title:"上师详细",
                width:500,
                height:400,
                cache:false,
                closed:true
            })
            //初始化详细面板
            $("#addArticleView").dialog({
                title:"添加文章",
                width:500,
                height:400,
                cache:false,
                closed:true
            })
            /*初始化文章提交按钮*/
            $("#addArticleFormSubmit").linkbutton({
                onClick:function () {
                    $.messager.alert({
                        title:"提示",
                        msg:"确认信息无误？",
                        icon:"",
                        fn:function () {
                            $("#addArticleForm").form("submit",{
                                url:"${pageContext.request.contextPath}/article/addDate",
                                onSubmit:function () {
                                    return $("#addArticleFormSubmit").form("validate")
                                },
                                success:function () {
                                    $.messager.show({
                                        title:"提示",
                                        msg:"添加成功"
                                    })
                                    $('#guruFindAll').edatagrid("reload")
                                    $("#addArticleView").dialog("close")
                                }
                            })
                        }
                    })
                }
            })
            /*保存按钮初始化*/
            $("#saveGuruBut").linkbutton({
                onClick:function () {
                    $("#guruFindAll").edatagrid("saveRow")
                },
                plain:true
            })
        })
    </script>
    <table id="guruFindAll"></table>
    <%--工具栏--%>
    <div id="gurubut">
        <a style="width: 19%" id="addGuruBut">添加上师</a>
        <a style="width: 19%" id="findOneGuruBut">上师详细信息</a>
        <a style="width: 19%" id="updateGuruBut">修改上师状态</a>
        <a style="width: 19%" id="uploadGuruBut">上传文章</a>
        <a style="width: 19%" id="saveGuruBut">保存修改</a>
    </div>
    <%--添加上师的对话框--%>
    <div id="addGuruDialog" style="text-align: center">
        <h1>添加上师</h1>
        <form id="addGuruForm" method="post" enctype="multipart/form-data">
            上师姓名：<input style="width: 250px" id="guruName" name="name"/><br/>
            上师法名：<input style="width: 250px" id="gurualiasname" name="aliasname"/><br/>
            上师头像：<input style="width: 250px" id="guruImgPath" name="file"/><br/>
            上师状态：<select data-options="required:true" class="easyui-combobox" name="level" style="width:250px;">
                <option value="0">正常</option>
                <option value="1">异常</option>
            </select><br/><br/>
            <a style="width: 150px" id="guruAddFormSubmit">提交</a>
        </form>
    </div>
    <%--上师详细信息面板--%>
    <div id="findOneGuruView">
        <h1 style="text-align: center">上师详情</h1>
        <div style="margin:30px 30px 0px 150px">
            <strong style="font-size: 20px">
                图片:<img style="width:25%;height: 25%" id="GuruImgView"/><br/>
                大师姓名:<span style="font-family: 华文行楷;color: #00bbee" id="GuruNameView"></span><br/>
                大师法名:<span style="font-family: 华文行楷;color: #00bbee" id="GurualiasnameView"></span><br/>
                大师状态:<span style="font-family: 华文行楷;color: #00bbee" id="GuruLeveView"></span><br/>
            </strong>
        </div>
    </div>
    <%--上传文章面板--%>
    <div style="text-align: center" id="addArticleView">
        <h1>上传文章</h1>
        <form id="addArticleForm" method="post" enctype="multipart/form-data">
            <input type="hidden" id="ArticleFormID" name="guru.id"/>
            文章标题：<input name="name" style="width: 250px" id="ArticleFormName"/><br/>
            上传文章：<input name="file" style="width: 250px" id="Articleupload"/><br/>
            文章详情：<input name="detalis" style="width: 250px" id="Articledetalis"/><br/>
            <a id="addArticleFormSubmit">上传文章</a>
        </form>
    </div>
