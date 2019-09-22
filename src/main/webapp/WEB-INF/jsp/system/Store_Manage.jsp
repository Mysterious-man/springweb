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
    <title>品牌管理</title>
</head>

<body>
<div class="margin" id="page_style">
    <div class="operation clearfix mb15 same_module">
        <ul class="choice_search">
            <li class="clearfix col-xs-2 col-lg-3 col-ms-3 "><label class="label_name "  style="max-width: 20%">专场名称：</label>
                <input style="width: 70%;"  data-content-id="nameSelect" placeholder="输入名称" id="productName" type="text" class="form-control col-xs-8 col-lg-8 col-ms-8">
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
        <a  onclick="showDetail()" title="添加专场" class="btn button_btn bg-deep-blue"><i class="fa fa-plus"></i>添加专场</a>
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
<%--<button class="btn btn-primary btn-lg" >开始演示模态框</button>--%>
<!-- 模态框（Modal） -->
<form id="formData">
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加专场</h4>
            </div>
            <div class="modal-body">
                <div class="panel panel-default">
                        <div class="panel-body" >
                            <input type="hidden" id="storeId" name="storeId">
                            <div class="form-group col-xs-6">
                                <label>专场名称</label>
                                <input id="storeName" type="text" class="form-control" name="storeName"  placeholder="请输入">
                                <label style="margin-top: 5%">专场开始时间</label>
                                <input id="storeStartTime" type="text" class="form-control" name="storeStartTime"  placeholder="请输入">
                            </div>
                            <div class="form-group col-xs-6">
                                <label>专场类型</label>
                                <select id="storeType" name="storeType" style="width: 100%">
                                    <option value ="1">普通</option>
                                    <option value ="2">高级</option>
                                </select>
<%--                                <input id="storeType" type="text" class="form-control" name="storeType"  placeholder="请输入">--%>
                                <label style="margin-top: 5%">专场结束时间</label>
                                <input id="storeEndTime" type="text" class="form-control" name="storeEndTime"  placeholder="请输入">
                            </div>
                        </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="submit" type="button" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>
</html>
<script type="text/javascript">
    var basePath="/store";
    function tbInit() {
        $('#tb_content').bootstrapTable({
            url: basePath+'/getDataList',         //请求后台的URL（*）
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
                    offset: params.offset, //页码
                    storeName:$("#nameSelect").val()
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
            },{
                field: 'storeName',
                width:200,
                align: 'center',
                title: '专场名称'
            }, {
                field: 'storeType',
                width:100,
                align: 'center',
                title: '专场类型'
            },
            {
                field: 'storeStartTime',
                width:400,
                align: 'center',
                title: '开始时间'
            },{
                field: 'storeEndTime',
                width:400,
                align: 'center',
                title: '结束时间'
            },
                {
                field: 'operate',
                title: '操作',
                align: 'center',
                width : 220,
                events: operateEvents,
                formatter: operateFormatter
            }]
        });

    }
    window.operateEvents = {
        'click .detail': function (e, value, row, index) {
            showDetail(row)},
        'click .del': function (e, value, row, index) {
            var isNo=confirm("你确认删除吗？");
            if(isNo){
                goDel(row.id);
            }
        }
    };
    function operateFormatter(value,row,index) {
        return [
            '<button type="button" class="detail btn btn-primary btn-sm">修改</button>&nbsp;&nbsp;',
            '<button type="button" class="del btn btn-primary  btn-sm" >删除</button>'
        ].join('');

    }

    //添加或修改的站是
    function showDetail(row){
        if(row){
            $("#storeId").val(row.storeId);
            $("#storeName").val(row.storeName);
            $("#storeStartTime").val(row.storeStartTime);
            $("#storeEndTime").val(row.storeEndTime);
            $("#storeType").val(row.storeType);
            $("#myModal").modal('show');
        }else {
            $("#myModal input").each(function () {
                $(this).val("");
            });
            $("#myModal").modal('show');
        }

    }

    //删除
    function goDel(id) {
        $.ajax({
            type: "post",
            url: basePath + "/del",
            dataType: "json",
            data: {id: id},
            success: function (data) {
                layer.alert(data.message, {
                    title: '提示框',
                    icon: 1,
                });

            },
        });
    }
    $("#submit").on('click',function () {
        $.ajax({
            type:"post",
            url:basePath+"/saveOrUpdate",
            dataType:"json",
            data:$("#formData").serialize(),
            success:function(data){
                layer.alert(data.message, {
                    title: '提示框',
                    icon: 1,
                });
                  debugger;
                if (data.success){
                    $('#myModal').modal("hide");
                    $("#tb_content").bootstrapTable('destroy');
                    tbInit();
                }

            },
        });

    });
    $(function () {
        tbInit();
        $('#queryList').on('click', function(){
            $("#tb_content").bootstrapTable('destroy');
            tbInit();
        });
    })
</script>