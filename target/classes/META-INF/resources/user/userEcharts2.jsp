<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="utf-8">
    <script src="${pageContext.request.contextPath}/easyui/echarts/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/easyui/echarts/china.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 1000px;height:580px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data:['最近注册人数']
            },
            xAxis: {
                data: ["近一周","近两周","近三周"]
            },
            yAxis: {},
            series: [{
                name: '最近注册人数',
                type: 'bar',
                data: [5, 20, 36]
            },{
                name: '最近注册人数',
                type: 'line',
                data: [5, 20, 36]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
