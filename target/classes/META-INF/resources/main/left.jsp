
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
    <script>
        $(function () {
            //发送请求
            $.getJSON(
                "${pageContext.request.contextPath}/category/findAll",
                //拿到集合对象
                function (res) {
                    //遍历集合对象和
                    $.each(res,function (idx,c) {
                        var content="<div style='text-align: center'>";
                        //遍历二级标签
                        $.each(c.categories,function (idc,cc) {
                            var s = JSON.stringify(cc);
                            content+="<div onclick='addAccordionTabs("+s+")' data-options=\"plain:true,iconCls:"+cc.conCls+"\" style='width:96%;margin: 3px 0px 3px 0px;border: 1px #95B8E7 solid;' class='easyui-linkbutton'>"+cc.name+"<br/></div>";
                        })
                        content+="</div>";
                        //调用空间的添加方法
                        $("#accordion").accordion("add",{
                            title:c.name,
                            content:content
                        })
                    })
                }
            )
        })
        function addAccordionTabs(s) {
            //当面板不存在时
            if(!$("#tabs").tabs("exists",s.name)){
                $("#tabs").tabs("add",{
                    title: s.name,
                    iconCls: s.conCls,
                    closable:true,
                    href:"${pageContext.request.contextPath}/"+s.url
                })
            }else{
                $("#tabs").tabs("select",s.name)
            }
        }
    </script>

    <div id="accordion" class="easyui-accordion"></div>

