<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

        <script>
            $(function () {
                $('#logFindAllTable').datagrid({
                    url: '${pageContext.request.contextPath}/log/findAdd',
                    columns:[[
                        {field:'adminName',title:'操作人',width:1,align:'center'},
                        {field:'opertionDate',title:'操作时间',width:1,align:'center'},
                        {field:'opertionName',title:'操作内容',width:1,align:'center'},
                        {field:'flag',title:'是否成功',width:1,align:'center'}
                    ]],
                    pagination:true,
                    fitColumns:true,
                })
            })

        </script>
        <table id="logFindAllTable"></table>