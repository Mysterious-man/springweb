<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/14
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="${pageContext.request.contextPath}/resources/system/css/shop.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/system/css/Sellerber.css" type="text/css"  rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/system/css/bkg_ui.css" type="text/css"  rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/system/font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstraptable.min.css">
    <script src="${pageContext.request.contextPath}/resources/system/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/system/js/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/shopFrame.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/Sellerber.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/layer/layer.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/laydate/laydate.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/system/js/proTree.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/dist/echarts.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-table-zh-CN.min.js"></script>
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/resources/system/js/html5shiv.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/respond.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/css3-mediaqueries.js"  type="text/javascript"></script>
    <![endif]-->
    <title>商城管理</title>
</head>

<body>
<div class="margin" id="page_style">
    <div class="operation clearfix mb15 same_module">
        <ul class="choice_search">
            <li class="clearfix col-xs-2 col-lg-3 col-ms-3 "><label class="label_name "  style="max-width: 20%">商城名称：</label>
                <input style="width: 70%;" placeholder="输入商品名称" id="productName" type="text" class="form-control col-xs-8 col-lg-8 col-ms-8">
            </li>
<%--
            <li style="max-width: 20%" class="clearfix col-xs-2 col-lg-3 col-ms-3"><label class="label_name ">添加时间：</label>
                <input style="width: 70%;" class="inline laydate-icon form-control Select_Date" id="start">
            </li>
--%>
            <li class="clearfix col-xs-2 col-lg-3 col-ms-3 ">
                <button id="queryList" type="button" class="btn button_btn bg-deep-blue "><i class="icon-search"></i>查询</button></li>
        </ul>
    </div>
    <div class="h_products_list clearfix mb15" id="Sellerber">
        <!--品牌展示-->
        <!--品牌列表-->
        <div class="list_Exhibition list_show padding15">
            <div class="operation clearfix mb15  same_module">
       <span class="l_f">
        <a href="/product/add_product"   class="btn button_btn bg-deep-blue"><i class="fa fa-plus"></i>批量配置专场</a>
         <a href="javascript:ovid()" class="btn  button_btn btn-danger"><i class="fa fa-trash"></i>批量删除</a>
       </span>
            </div>
            <div class=" datalist_show">
                <div class="datatable_height confirm">
                    <table id="tb_content" class="table table_list table_striped table-bordered">
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
    function tbInit() {
        $('#tb_content').bootstrapTable({
            url: '/mall/manage_list',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams:  function (params) {
                var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    limit: params.limit,   //页面大小
                    offset: params.offset, //页码
                    productName:$("#productName").val()
                };
                return temp;
            },
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                title: '序号',
                width:60,
                align: 'center',
                formatter: function (value, row, index) {
                    return index+1;
                }
            },

            {
                field: 'mallId',
                width:200,
                align: 'center',
                title: '商城id'
            },
            {
                field: 'productId',
                width:200,
                align: 'center',
                title: '产品id'
            },{
                field: 'productName',
                width:200,
                align: 'center',
                title: '产品名称'
            }, {
                field: 'brandName',
                width:100,
                align: 'center',
                title: '品牌名称'
            },
            {
                field: 'price',
                width:400,
                align: 'center',
                title: '商品销售价格'
            },{
                field: 'originalPrice',
                width:400,
                align: 'center',
                title: '商品市场原价'
            },
            {
                field: 'publishStatus',
                width:400,
                align: 'center',
                title: '商品上架状态'
            },
            {
                field: 'auditStatus',
                width:400,
                align: 'center',
                title: '商品审核状态'
            }
            ,
                {
                field: 'operate',
                title: '操作',
                align: 'center',
                width : 220,
                // events: operateEvents,
                formatter: operateFormatter
            }]
        });

        function operateFormatter(value, row, index) {
                return [
                    '<button type="button" class="detail btn btn-primary btn-sm"><i class="fa fa-cogs"></i>配置专场</button>&nbsp;&nbsp;',
                    '<button type="button" class="del btn btn-primary  btn-sm" >删除</button>'
                ].join('');

        }


    }

    $(function () {
        tbInit();
        $('#queryList').on('click', function(){
            debugger;
            $("#tb_content").bootstrapTable('destroy');
            tbInit();
        })
    })
</script>