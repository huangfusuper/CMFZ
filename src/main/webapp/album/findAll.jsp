
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>



    <script>
        $(function () {
            $("#album").treegrid({
                url:"${pageContext.request.contextPath}/album/findAllPage",
                idField:"id",
                treeField:"name",
                columns:[[
                    {field:'name',title:'章节名称',width:1,align:'left'},
                    {field:'size',title:'大小',width:1,align:'center'},
                    {field:'length',title:'时间',width:1,align:'center'},
                    {field:'url',title:'路径',width:1,align:'center'},
                ]],
                animate:true,
                fitColumns:true,
                lines:true,
                toolbar:"#albumBut"
            })
            //初始化查看专辑详情
            $("#findOneAlbumBut").linkbutton({
                plain:true,
                onClick:function () {
                    //获取选中行
                    var row = $("#album").treegrid("getSelected");
                    if(row==null){
                        alert("请选中一行")
                    }else{
                       if(row.size==null){
                           //向面板填充数据
                           $("#albumImg").attr("src","${pageContext.request.contextPath}/main/img/upload/"+row.imgPath)
                           $("#albumName").text(row.name)
                           $("#pubName").text(row.pubName)
                           $("#brodcastname").text(row.brodcastname)
                           $("#totalCount").text(row.count)
                           $("#albumBries").text(row.bries)
                           $("#albumCreateTime").text(row.createTime)
                           //显示面板
                           $("#findOneAlbumView").dialog("open")
                       }else{
                           alert("请选中专辑面板")
                       }
                    }


                }
            })
            //初始化添加专辑
            $("#addAlbumBut").linkbutton({
                plain:true,
                onClick:function () {
                    $("#addAlbumDialog").dialog("open")
                }
            })
            //初始化添加章节
            $("#addChildrenBut").linkbutton({
                plain:true,
                onClick:function () {
                    var row = $("#album").treegrid("getSelected");
                    if(row==null){
                        alert("至少选中一行")
                    }else{
                        if(row.size==null){
                            $("#ChildrenIDText").attr("value",row.id)
                            $("#ChildrenAddView").dialog("open")
                        }else{
                            alert("请选中专辑列表")
                        }
                    }
                }
            })
            /*//初始化下载音频
            $("#downMp3But").linkbutton({
                plain:true,
                onClick:function () {
                    var row = $("#album").treegrid("getSelected");
                    if(row==null){
                        alert("至少选中一行")
                    }else{
                        if(row.size!=null){
                            $.get(
                                ${pageContext.request.contextPath}/children/downloadFile,
                                "url="+row.url+"&name="+row.name,
                                function () {
                                    $.messager.show({
                                        title:"提示",
                                        msg:"下载成功"
                                    })
                                }
                            )
                        }else{
                            alert("请选中章节列表")
                        }
                    }
                }
            })*/
            //初始化面板
            $("#findOneAlbumView").dialog({
                title:"专辑详情",
                width:500,
                height:400,
                cache:false,
                closed:true
            })
            //初始化添加面板
            $("#addAlbumDialog").dialog({
                title:"添加专辑",
                width:600,
                height:500,
                cache:false,
                closed:true
            })
            $("#ChildrenAddView").dialog({
                title:"添加文章",
                width:600,
                height:500,
                cache:false,
                closed:true
            })
            $("#addAlbumButSubmit").linkbutton({
                onClick:function () {
                    $("#addAlbumForm").form("submit",{
                        url:"${pageContext.request.contextPath}/album/addAlbumAndUpload",
                        onSubmit:function () {
                            return $("#addAlbumForm").form("validate");
                        },
                        success:function () {
                            $.messager.show({
                                title:"提示",
                                msg:"上传成功"
                            })
                            $("#addAlbumDialog").dialog("close")
                            $("#album").treegrid("reload")
                        }
                    })
                }
            })
            //上传文章初始化
            $("#ChildrenUpload").filebox({
                required:true,
                buttonText:"浏览",
                buttonIcon:"icon-search",
                width:250
            })

            //上传文件的提交按钮
            $("#ChildrenAddFormSubmit").linkbutton({
                onClick:function () {
                    $.messager.progress();
                    $("#ChildrenAddForm").form("submit",{
                        url:"${pageContext.request.contextPath}/children/ChildrenUpload",
                        onSubmit:function () {
                            var isValid = $("#ChildrenAddForm").form("validate");
                            if (!isValid){
                                $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                            }
                            return isValid;
                        },
                        success:function () {
                            $.messager.progress('close');	// 如果提交成功则隐藏进度条
                            $.messager.show({
                                title:"提示",
                                msg:"上传成功"
                            })
                            $("#ChildrenAddView").dialog("close")
                            $("#album").treegrid("reload")
                        }
                    })
                }
            })
            $("#bofangyinpin").linkbutton({
                plain:true,
                onClick:function () {
                    var row = $("#album").treegrid("getSelected");
                    if(row==null){
                        alert("至少选中一行")
                    }else{
                        if(row.size!=null){
                            $("#bofangshitu").empty()
                            var embed = $("<embed height='370' width='500'/>");
                            $("#MP3TEXT").text(""+row.name+"")
                            embed.attr("src","../main/mp4/"+row.url)
                            $("#bofangshitu").append(embed)
                            $("#bofangshitu").dialog("open")
                        }else{
                            alert("请选中章节列表")
                        }
                    }
                }
            })





            $("#albumFileUpload").filebox({
                required:true,
                width:250,
                buttonIcon:'icon-search',
                buttonText:'浏览'
            })

            $("#albumAddName").textbox({
                required:true,
                width:250
            })

            $("#albumAddPubName").textbox({
                required:true,
                width:250
            })

            $("#albumBrodcastname").textbox({
                required:true,
                width:250
            })

            $("#albumCount").textbox({
                required:true,
                width:250,validType:'number'
            })

            $("#albumBries1").textbox({
                required:true,
                width:250,
                height:150,
                multiline:true
            })

            $("#bofangshitu").dialog({
                title:"播放",
                width:600,
                height:500,
                cache:false,
                closed:true
            })
        })

    </script>
    <table id="album"></table>
    <%--操作按钮--%>
    <div style="text-align: center" id="albumBut">
        <a style="width: 24%;border: 1px #95A8E7 solid;" id="findOneAlbumBut">查看专辑详情</a>
        <a style="width: 24%;border: 1px #95A8E7 solid;" id="addAlbumBut">添加专辑</a>
        <a style="width: 24%;border: 1px #95A8E7 solid;" id="addChildrenBut">添加章节</a>
<%--
        <a style="width: 19%;border: 1px #95A8E7 solid;" id="downMp3But">下载音频</a>
--%>
        <a style="width: 24%;border: 1px #95A8E7 solid;" id="bofangyinpin">播放音频</a>
    </div>
    <%--显示详情面板--%>、
    <div id="findOneAlbumView">
        <h1 style="text-align: center">专辑详情</h1>
        <div style="margin:30px 30px 0px 150px">
        <strong style="font-size: 20px">
        图片:<img style="width:25%;height: 25%" id="albumImg"/><br/>
        专辑标题:<span style="font-family: 华文行楷;color: #00bbee" id="albumName"></span><br/>
        专辑发布人:<span style="font-family: 华文行楷;color: #00bbee" id="pubName"></span><br/>
        播音人:<span style="font-family: 华文行楷;color: #00bbee" id="brodcastname"></span><br/>
        总共集数:<span style="font-family: 华文行楷;color: #00bbee" id="totalCount"></span><br/>
        详细信息:<span style="font-family: 华文行楷;color: #00bbee" id="albumBries"></span><br/>
        创建时间:<span style="font-family: 华文行楷;color: #00bbee" style="font-family: 华文行楷" id="albumCreateTime"></span>
        </strong>
        </div>
    </div>
    <%--添加专辑面板--%>
    <div id="addAlbumDialog">
        <form id="addAlbumForm" method="post" enctype="multipart/form-data"  style="text-align: center">
            <h1>添加专辑详情</h1>
            选择专辑图片:<input id="albumFileUpload"  name="file"/><br/>
            设置专辑标题:<input id="albumAddName"  name="name" /><br/>
            设置专辑作者:<input id="albumAddPubName"  name="pubName" /><br/>
            设置专辑播音:<input id="albumBrodcastname"  name="brodcastname" /><br/>
            设置专辑集数:<input id="albumCount"  name="count" /><br/><br/>
            专辑详细信息:<input id="albumBries1" name="bries" /><br/><br/>
            <a id="addAlbumButSubmit">添加专辑</a>
        </form>
    </div>
    <%--文章上传--%>
    <div style="text-align: center" id="ChildrenAddView">
        <h1>章节文件上传</h1>
        <form id="ChildrenAddForm" method="post" enctype="multipart/form-data">
            <input type="hidden" id="ChildrenIDText" name="id"/>
            文件上传:<input id="ChildrenUpload" name="file"/><br/><br/>
            <a id="ChildrenAddFormSubmit">上传章节</a>
        </form>

    </div>

<%--播放图--%>
<div style="text-align: center" id="bofangshitu">
    <h1><span id="MP3TEXT"></span></h1>
</div>