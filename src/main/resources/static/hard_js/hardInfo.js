layui.use(['element', 'tree', 'table', 'layer', 'form'],function () {
    var sysDataCharts = echarts.init(document.getElementById('sysDataCharts'));
    var vmDataCharts=echarts.init(document.getElementById('vmDataCharts'));
    var cpuDataCharts=echarts.init(document.getElementById('cpuDataCharts'));
    var option = {
        grid: {
            x: 70,
            y: 40,
            x2: 40,
            y2: 80,
            borderWidth: 1
        },
        animationDurationUpdate: 100,
        legend: {
            data: ['已使用内存','未使用内存','总物理内存']
        },
        tooltip: {},
        toolbox: {
            feature: {
                dataView: {},
                saveAsImage: {
                    pixelRatio: 2
                },
                mark: {show: true},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {}
            }
        },
        xAxis: {
            axisTick: {
                interval: 0,
                show: true,
                alignWithLabel: true
            },
            axisLabel: {
                rotate: 30,
                interval: 0
            },
            axisLine: {
                lineStyle: {
                    color: 'gray'
                }
            },
            splitLine: {
                show: true
            },
            boundaryGap: true,
            name: '时间',
            type: 'category',
            triggerEvent: true,
            data: []
        },
        yAxis: {
            name: '内存/(GB)',
            type: 'value'
        },
        series: [{
            itemStyle : {
                normal : {
                    color:'#06C89A',
                }
            },
            smooth: false,
            type: 'line',
            name: '已使用内存',
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            },
            data: [],
        },{
            color: '#74BFF1',
            type: 'line',
            smooth: false,
            name: '未使用内存',
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            },
            data: [],
        },{
            color: '#105FE9',
            type: 'line',
            smooth: false,
            name: '总物理内存',
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            },
            data: [],
        }]
    };
    var vmOption = {
        grid: {
            x: 70,
            y: 40,
            x2: 40,
            y2: 80,
            borderWidth: 1
        },
        animationDurationUpdate: 100,
        legend: {
            data: ['已使用内存','未使用内存','总内存']
        },
        tooltip: {},
        toolbox: {
            feature: {
                dataView: {},
                saveAsImage: {
                    pixelRatio: 2
                },
                mark: {show: true},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {}
            }
        },
        xAxis: {
            axisTick: {
                interval: 0,
                show: true,
                alignWithLabel: true
            },
            axisLabel: {
                rotate: 30,
                interval: 0
            },
            axisLine: {
                lineStyle: {
                    color: 'gray'
                }
            },
            splitLine: {
                show: true
            },
            boundaryGap: true,
            name: '时间',
            type: 'category',
            triggerEvent: true,
            data: []
        },
        yAxis: {
            name: '内存/(MB)',
            type: 'value'
        },
        series: [{
            itemStyle : {
                normal : {
                    color:'#06C89A',
                }
            },
            smooth: false,
            type: 'line',
            name: '已使用内存',
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            },
            data: [],
        },{
            color: '#74BFF1',
            type: 'line',
            smooth: false,
            name: '未使用内存',
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            },
            data: [],
        },{
            color: '#105FE9',
            type: 'line',
            smooth: false,
            name: '总内存',
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            },
            data: [],
        }]
    };
    var cpuOption = {
        grid: {
            x: 70,
            y: 40,
            x2: 40,
            y2: 80,
            borderWidth: 1
        },
        animationDurationUpdate: 100,
        legend: {
            data: ['系统使用率','总使用率','当前空闲率']
        },
        tooltip: {},
        toolbox: {
            feature: {
                dataView: {},
                saveAsImage: {
                    pixelRatio: 2
                },
                mark: {show: true},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {}
            }
        },
        xAxis: {
            axisTick: {
                interval: 0,
                show: true,
                alignWithLabel: true
            },
            axisLabel: {
                rotate: 30,
                interval: 0
            },
            axisLine: {
                lineStyle: {
                    color: 'gray'
                }
            },
            splitLine: {
                show: true
            },
            boundaryGap: true,
            name: '时间',
            type: 'category',
            triggerEvent: true,
            data: []
        },
        yAxis: {
            name: 'cpu/(%)-平均值',
            type: 'value'
        },
        series: [{
            itemStyle : {
                normal : {
                    color:'#06C89A',
                }
            },
            smooth: false,
            type: 'line',
            name: '系统使用率',
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            },
            data: [],
        },{
            color: '#74BFF1',
            type: 'line',
            smooth: false,
            name: '总使用率',
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            },
            data: [],
        },{
            color: '#105FE9',
            type: 'line',
            smooth: false,
            name: '当前空闲率',
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            },
            data: [],
        }]
    };
    window.refreshVmCharts=function(dateTime,vmDatavalue,vmDatavalue1,vmDatavalue2){
        vmOption.xAxis.data = dateTime;
        vmOption.series[0].data = vmDatavalue;
        vmOption.series[1].data = vmDatavalue1;
        vmOption.series[2].data = vmDatavalue2;
        vmDataCharts.setOption(vmOption, true);
        vmDataCharts.hideLoading();
    }
    window.refreshCharts = function (dateTime,datavalue,datavalue1,datavalue2) {
        option.xAxis.data = dateTime;
        option.series[0].data = datavalue;
        option.series[1].data = datavalue1;
        option.series[2].data = datavalue2;
        sysDataCharts.setOption(option, true);
        sysDataCharts.hideLoading();
    }
    window.refreshCpuCharts=function(dateTime,datavalue,datavalue1,datavalue2){
        cpuOption.xAxis.data = dateTime;
        cpuOption.series[0].data = datavalue;
        cpuOption.series[1].data = datavalue1;
        cpuOption.series[2].data = datavalue2;
        cpuDataCharts.setOption(cpuOption, true);
        cpuDataCharts.hideLoading();
    }
    window.initCharts=function(){
        var dateTime = [];
        var datavalue = [];
        var datavalue1 = [];
        var datavalue2 = [];

        var vmDatavalue = [];
        var vmDatavalue1 = [];
        var vmDatavalue2 = [];

        var cpuDateTime=[];
        var cpuDatavalue = [];
        var cpuDatavalue1 = [];
        var cpuDatavalue2 = [];
        var dataId = [];
        var pageinit = 0
        $.ajax({
            type: "get",
            url: "/hard-reader/hardReal/memData",
            dataType: "json",
            data: {
                page: pageinit,
                size: 20
            },
            success: function (result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                dateTime = [];
                datavalue = [];
                datavalue1=[];
                datavalue2=[];
                vmDatavalue = [];
                vmDatavalue1 = [];
                vmDatavalue2 = [];
                dataId = [];
                var data = result.result;
                var item;
                for (let i = 0; i <data.length; i++) {
                    item = data[i];
                    datavalue.push(item.usedMemory)
                    datavalue1.push(item.freePhysicalMemorySize)
                    datavalue2.push(item.totalMemorySize)
                    vmDatavalue.push(item.totalMemory-item.freeMemory)
                    vmDatavalue1.push(item.freeMemory)
                    vmDatavalue2.push(item.totalMemory)
                    dateTime.push(item.collectTime)
                    dataId.push(item.dataId)
                }
                refreshCharts(dateTime,datavalue,datavalue1,datavalue2);
                refreshVmCharts(dateTime,vmDatavalue,vmDatavalue1,vmDatavalue2);
            }
        })

        $.ajax({
            type: "get",
            url: "/hard-reader/hardReal/cpuData",
            dataType: "json",
            data: {
                page: pageinit,
                size: 20
            },
            success: function (result) {
                cpuDateTime=[]
                cpuDatavalue = [];
                cpuDatavalue1 = [];
                cpuDatavalue2 = [];
                var data = result.result;
                var item;
                for (let i = 0; i <data.length; i++) {
                    item = data[i];
                    cpuDateTime.push(item.collectTime)
                    cpuDatavalue.push(item.sysValue)
                    cpuDatavalue1.push(item.currentFreeValue)
                    cpuDatavalue2.push(item.totalValue)
                }
                refreshCpuCharts(cpuDateTime,cpuDatavalue,cpuDatavalue1,cpuDatavalue2);
            }
        })
    }
    window.initBaseInfo=function(){
        loadCpuInfo();
        loadMem();
        loadSys();
        loadUser();
        loadNet();
        loadYiTaiNet();
    }
    window.loadCpuInfo=function(){
        $.ajax({
            type: "get",
            url: "/hard-reader/hardBase/cpuInfo",
            dataType: "json",
            data: {},
            success:function (res) {
                var data=res.result;
                $("#cpuVendor").text(data.vendor)
                $("#cpuCoreNum").text(data.cpuCoreNum)
                $("#cpuMhz").text(data.mhz)
                $("#cpuModel").text(data.model)
                $("#cpuCacheSize").text(data.cacheSize)
            }
        })
    }

    window.loadMem=function(){
        $.ajax({
            type: "get",
            url: "/hard-reader/hardBase/memInfo",
            dataType: "json",
            data: {},
            success:function (res) {
                var data=res.result;
                $("#total").text(data.total)
                $("#used").text(data.used)
                $("#free").text(data.free)
                $("#swapTotal").text(data.swapTotal)
                $("#swapFree").text(data.swapFree)
                $("#swapUsed").text(data.swapUsed)
            }
        })
    }

    window.loadSys=function(){
        $.ajax({
            type: "get",
            url: "/hard-reader/hardBase/sysInfo",
            dataType: "json",
            data: {},
            success:function (res) {
                var data=res.result;
                $("#arch").text(data.arch)
                $("#cpuEndian").text(data.cpuEndian)
                $("#dataModel").text(data.dataModel)
                $("#desc").text(data.desc)
                $("#name").text(data.name)
                $("#vendor").text(data.vendor)
                /*$("#vendorCodeName").text(data.vendorCodeName)
                $("#vendorName").text(data.vendorName)
                $("#vendorVersion").text(data.vendorVersion)*/
                $("#version").text(data.version)
            }
        })
    }
    window.loadUser=function(){
        $.ajax({
            type: "get",
            url: "/hard-reader/hardBase/userInfo",
            dataType: "json",
            data: {},
            success:function (res) {
                var data=res.result;
                $("#device").text(data.device)
                $("#host").text(data.host)
                $("#user").text(data.user)
            }
        })
    }
    window.loadNet=function(){
        $.ajax({
            type: "get",
            url: "/hard-reader/hardBase/netInfo",
            dataType: "json",
            data: {},
            success:function (res) {
                var data=res.result;
                $("#deviceName").text(data.name)
                $("#mask").text(data.mask)
                $("#address").text(data.address)
            }
        })
    }

    window.loadYiTaiNet=function(){
        $.ajax({
            type: "get",
            url: "/hard-reader/hardBase/yiTaiNetInfo",
            dataType: "json",
            data: {},
            success:function (res) {
                var data=res.result;
                $("#ip").text(data.address)
                $("#broadcast").text(data.broadCast)
                $("#mac").text(data.hwAddress)
                $("#maskYiTai").text(data.mask)
                $("#descYiTai").text(data.desc)
                $("#type").text(data.type)
            }
        })
    }

    sysDataCharts.showLoading({
        text:'正在加载数据...',
        effectOption: {backgroundColor: 'rgba(0, 0, 0, 0.2)'}
    })
    vmDataCharts.showLoading({
        text:'正在加载数据...',
        effectOption: {backgroundColor: 'rgba(0, 0, 0, 0.2)'}
    })
    cpuDataCharts.showLoading({
        text:'正在加载数据...',
        effectOption: {backgroundColor: 'rgba(0, 0, 0, 0.2)'}
    })
    window.setInterval(function () {
        initCharts();
    },2000)
    initCharts();
    initBaseInfo();
})
