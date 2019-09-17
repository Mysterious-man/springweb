<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/14
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="${pageContext.request.contextPath}/resources/system/css/shop.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/system/css/Sellerber.css" type="text/css"  rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/system/css/bkg_ui.css" type="text/css"  rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/system/font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/system/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/Sellerber.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/jquery.dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/layer/layer.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/laydate/laydate.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/hsCheckData.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/resources/system/js/html5shiv.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/respond.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/system/js/css3-mediaqueries.js"  type="text/javascript"></script>
    <![endif]-->
    <title>添加产品</title>
</head>

<body>
<div class="margin inside_pages clearfix">
    <div class="add_style clearfix relative">
        <!--品牌展示 当通过品牌管理添加产品是显示该-->

        <ul>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>商品编码：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input id="product_core"  type="text"  class="col-xs-6"/></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>商品名称：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input id="product_name" type="text" class="col-xs-4"/></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>国条码：</label><div class="Add_content col-xs-11"><input id="bar_code" type="text" class="col-xs-4"/><em class="Prompt"> 请用","分隔关键字</em></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>价格：</label><div class="Add_content col-xs-11"><input id="price" type="text" class="col-xs-4"/><em class="Prompt"> 请用","分隔关键字</em></div></li>

            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>一级分类ID：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input id="one_category_id" type="text" class="col-xs-4"/></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>状态：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input id="status" type="text" class="col-xs-4"/></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>生产日期：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input id="production_date" value="2018-08-11" type="text" class="col-xs-4" disabled/></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>商品保质期：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input id="shelf_life" value="66" type="text" class="col-xs-4" disabled/></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>商品描述：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input id="descript" type="text" class="col-xs-4"/></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>商品录入时间：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input value="2018-08-11" id="indate" type="text" class="col-xs-4" disabled/></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>最后修改时间：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input value="2018-08-11" id="modified_time" type="text" class="col-xs-4" disabled/></div></li>
            <li class="clearfix"><label class="label_name col-xs-1"><i>*</i>属性：&nbsp;&nbsp;</label><div class="Add_content col-xs-11"><input id="product_attribute" type="text" class="col-xs-4"/></div></li>

                        <li class="clearfix" style="display:none"><label class="label_name col-xs-1" hi>设置时间：&nbsp;&nbsp;</label>
                            <div class="Add_content col-xs-11">
                                <div class="Date_selection" style="display:none">
                                    <span class="label_name">开始日：</span><p class="laydate-icon" id="start" style="width:200px; margin-right:10px; height:30px; line-height:30px; float:left"></p>
                                    <span class="label_name">结束日：</span><p class="laydate-icon" id="end" style="width:200px;height:30px; line-height:30px; float:left"></p>
                                </div>
                            </div>
                        </li>
            <li class="clearfix"><label class="label_name col-xs-1">SKU配置：&nbsp;&nbsp;</label>
                <div class="Add_content col-xs-11">
                    <button  type="button" onclick="openDiv1()" id="openList" class="btn bg-deep-blue operation_btn margin-left">展开</button>
                </div>
            </li>
            <div  id="div1">
                <div id="div2" style="width: 70%;margin-left: 10%;">
                    <div class="panel panel-default">
                        <div class="panel-body" >
                            <div class="form-group col-xs-4">
                                <label>销售属性1</label>
                                <input type="text" class="form-control"  placeholder="请输入">
                                <label>销售属性2</label>
                                <input type="text" class="form-control"  placeholder="请输入">
                                <label>销售属性3</label>
                                <input type="text" class="form-control"  placeholder="请输入">
                            </div>
                            <div class="form-group col-xs-4">
                                <label>价格</label>
                                <input type="text" class="form-control"  placeholder="请输入">
                                <label>sku编码</label>
                                <input type="text" class="form-control"  placeholder="请输入">
                                <label>预警库存</label>
                                <input type="text" class="form-control"  placeholder="请输入">
                            </div>
                            <div class="form-group col-xs-4">
                                <label>锁定库存</label>
                                <input type="text" class="form-control"  placeholder="请输入">
                                <label>属性</label>
                                <input type="text" class="form-control"  placeholder="请输入">
                                <label>图片</label>
                                <input type="file" class="form-control"  placeholder="Jane Doe">
                                <button style="margin-top: 20px"  type="button" onclick="del_sku(this)"  class="btn bg-deep-blue operation_btn margin-left">删除SKU</button>
                            </div>
                        </div>
                    </div>
                </div>
                <button style="margin-left: 46%;"  type="button" onclick="add_sku()" >十</button>


            </div>

            <li class="clearfix">
                <div class="col-xs-4">
                    <label class="label_name col-xs-3">是否上架：&nbsp;&nbsp;</label>
                    <div class="Add_content col-xs-9">
                        <label><input type="radio" name="checkbox" class="ace" checked="checked"><span class="lbl">是</span></label>
                        <label><input type="radio" name="checkbox" class="ace"><span class="lbl">否</span></label>
                    </div>
                </div>
                <div class="col-xs-4">
                    <label class="label_name col-xs-3">允许评论：&nbsp;&nbsp;</label>
                    <div class="Add_content col-xs-9">

                        <label class="l_f checkbox_time"><input type="checkbox" name="checkbox" class="ace" checked="checked"><span class="lbl"></span></label>
                    </div>
                </div>
            </li>
        </ul>
        <li class="clearfix">
            <label class="label_name col-xs-1"><i>*</i>产品图片：&nbsp;&nbsp;</label>
            <div class="Add_content col-xs-11" id="Upload">
                <div class="images_Upload clearfix margin-bottom" id="images_Upload">
                    <span class="Upload_img"><input name="file" type="file" /></span>
                    <a href="javascript:ovid()" class="operating delete_Upload" onclick="delete_Upload(this.id)"><i class="fa fa-remove"></i></a>
                    <a href="javascript:ovid()" class="operating" title="预览" onclick="preview_img(this.id)"><i class="fa  fa-image"></i></a>
                </div>
                <button type="button" class="add_Upload bg-deep-blue" id="add_Upload" onclick="add_Upload()"><i class="fa  fa-plus"></i></button>
            </div>
        </li>

        <div class="Button_operation btn_width">
            <button class="btn button_btn bg-deep-blue" type="button" id="submit">保存并提交</button>
            <%--  <button class="btn button_btn bg-orange" type="button">保存草稿</button>
              <button class="btn button_btn bg-gray" type="button">取消添加</button>--%>
        </div>
    </div>
</div>
</body>
</html>
<!--复文本编辑框-->
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/system/js/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/system/js/utf8-jsp/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/system/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script>
    var ProductAddDTO;
    var product;
    var product_attribute;
    var product_pic_info;
    var product_pic_infos=  new Array();
    var sku;
    var skus = new Array();
    var sku_attribute;
    var fileFrom;
    //保存产品
    function setProduct(){
        product={
            productId : null,
            productCore : $("#product_core").val(),
            productName : $("#product_name").val(),
            barCode : $("#bar_code").val(),
            brandName : $("#brand_name").val(),
            oneCategoryId : $("#one_category_id").val(),
            twoCategoryId : $("#two_category_id").val(),
            threeCategoryId : $("#three_category_id").val(),
            BigDecimal : $("#product_core").val(),
            price :$("#price").val(),
            originalPrice : $("#original_price").val(),
            status : $("#status").val(),
            productionDate : $("#production_date").val(),
            shelfLife : $("#shelf_life").val(),
            indate : null,
            modifiedTime :$("#modified_time").val(),
            descript : $("#descript").val()
        };
        product_attribute = {
            value : $("#product_attribute").val()
        };
    }

    //保存图片 status =0 产品图片 status = 1 sku图片
    function setProductInfo(picDesc,picUrl,status) {
        product_pic_info = {
            picDesc : picDesc,
            picUrl : picUrl,
            isMaster :1,
            picOrder : 1,
            picStatus : 1,
        };
        if(status==0){
            product_pic_infos.push(product_pic_info);
        }
    }

    //保存sku
    function setSku(sku_pic_info,a,b,c,d,e,f,g,h) {
        sku_attribute = {
            value: h
        };
        sku={
            skuCode :g,
            price : d,
            lowStock : f,
            sp1 : a,
            sp2 : b,
            sp3 : c,
            lockStock : null,
            sku_pic_info: sku_pic_info,
            sku_attribute :sku_attribute,
        };
        skus.push(sku);

    }
    //保存为Dto
    function setDto(product,product_attribute,product_pic_infos,skus){
        ProductAddDTO={
            product : product,
            product_attribute : product_attribute,
            product_pic_infos :product_pic_infos,
            skus : skus
        }

    }
    //清空数据对象
    function reloadDto(){
         ProductAddDTO=null;
         product=null;
         product_attribute=null;
         product_pic_info=null;
         product_pic_infos=  new Array();
         sku=null;
         skus = new Array();
         sku_attribute=null;
         fileFrom=null;
    }
    //添加sku表单
    function add_sku() {
        $("#div2").append("                    <div class=\"panel panel-default\">\n" +
            "                        <div class=\"panel-body\" >\n" +
            "                            <div class=\"form-group col-xs-4\">\n" +
            "                                <label>销售属性1</label>\n" +
            "                                <input type=\"text\" class=\"form-control\"  placeholder=\"请输入\">\n" +
            "                                <label>销售属性2</label>\n" +
            "                                <input type=\"text\" class=\"form-control\"  placeholder=\"请输入\">\n" +
            "                                <label>销售属性3</label>\n" +
            "                                <input type=\"text\" class=\"form-control\"  placeholder=\"请输入\">\n" +
            "                            </div>\n" +
            "                            <div class=\"form-group col-xs-4\">\n" +
            "                                <label>价格</label>\n" +
            "                                <input type=\"text\" class=\"form-control\"  placeholder=\"请输入\">\n" +
            "                                <label>sku编码</label>\n" +
            "                                <input type=\"text\" class=\"form-control\"  placeholder=\"请输入\">\n" +
            "                                <label>预警库存</label>\n" +
            "                                <input type=\"text\" class=\"form-control\"  placeholder=\"请输入\">\n" +
            "                            </div>\n" +
            "                            <div class=\"form-group col-xs-4\">\n" +
            "                                <label>锁定库存</label>\n" +
            "                                <input type=\"text\" class=\"form-control\"  placeholder=\"请输入\">\n" +
            "                                <label>属性</label>\n" +
            "                                <input type=\"text\" class=\"form-control\"  placeholder=\"请输入\">\n" +
            "                                <label>图片</label>\n" +
            "                                <input type=\"file\" class=\"form-control\"  placeholder=\"Jane Doe\">\n" +
            "                                <button style=\"margin-top: 20px\"  type=\"button\" onclick=\"del_sku(this)\"  class=\"btn bg-deep-blue operation_btn margin-left\">删除SKU</button>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n");

    }
    //删除sku表单
    function del_sku(obj) {
        $(obj).parent().parent().parent().remove();

    }

    $(function () {
        $("#div1").hide();
        //提交
        $("#submit").on('click',function () {
            $("#Upload input[type$='file']").each(function () {
                fileFrom = new FormData();
                fileFrom.append('file', $(this)[0].files[0]);
                $.ajax({
                    url: "/picture/upload",
                    type: "POST",
                    data: fileFrom,
                    async: false,
                    contentType: false,
                    processData: false,
                    success:function(data){
                        if(data.success){
                            setProductInfo("没有描述",data.data.IMG_PATH,0);
                        }else{
                            layer.alert(data.message,{
                                title: '提示框',
                                icon:1,
                            });

                        }
                    },
                });

            });

            var skuData = new Array();
            $("#div1 input").each(function () {
                if($(this).attr("type")=="file"){
                    fileFrom = new FormData();
                    if(typeof($(this)[0].files[0])== "undefined"){
                        setSku(null,skuData[0],skuData[1],skuData[2],skuData[3],skuData[4],skuData[5],skuData[6],skuData[7]);
                    }else {
                        fileFrom.append('file',$(this)[0].files[0]) ;
                        $.ajax({
                            url: "/picture/upload",
                            type: "POST",
                            data: fileFrom,
                            async: false,
                            contentType: false,
                            processData: false,
                            success:function(data){
                                if(data.success){
                                    setProductInfo("没有描述",data.data.IMG_PATH,1);
                                    setSku(product_pic_info,skuData[0],skuData[1],skuData[2],skuData[3],skuData[4],skuData[5],skuData[6],skuData[7]);
                                    skuData = new Array();
                                }else{
                                    layer.alert(data.message,{
                                        title: '提示框',
                                        icon:1,
                                    });

                                }
                            },
                        });
                    }

                }else {
                    skuData.push((this).value);
                }


            });
            setProduct();
            setDto(product,product_attribute,product_pic_infos,skus);
            $.ajax({
                type:"post",
                url:"/product/add",
                dataType:"json",
                // data: ProductAddDTO,
                contentType : 'application/json;charset=utf-8',
                data : JSON.stringify(ProductAddDTO),
                success:function(data){
                    debugger;
                    if(data.success){
                        location.href="/system/shops_index";
                        layer.close(index);
                    }else{
                        reloadDto();
                        layer.alert(data.message,{
                            title: '提示框',
                            icon:1,
                        });

                    }
                },
            });

        });


    });

    $(function(){
        var ue = UE.getEditor('editor');
    });
    $(document).ready(function(){
        var spotMax = 8;
        if($('div.images_Upload').size() >= spotMax) {$(obj).hide();}
        $("#add_Upload").on('click',function(){
            var cid =$('.images_Upload').each(function(i){ $(this).attr('id',"Uimages_Upload_"+i)});
            addSpot(this, spotMax, cid);
        });
    });
    function addSpot(obj, sm ,sid) {
        $("#Upload").append("<div class='images_Upload clearfix margin-bottom' id='"+sid+"'>"+
            "<span class='Upload_img'><input name='' type='file' /></span>"+
            "<a href='javascript:ovid()' class='operating delete_Upload'><i class='fa fa-remove'></i></a>"+
            "<a href='javascript:ovid()' class='operating' onclick='preview_img(this.id)'><i class='fa  fa-image'></i></a>"+
            "</div>&nbsp;")
            .find(".delete_Upload").click(function(){
            if($('div.images_Upload').size()==1){
                layer.msg('请至少保留一张图片!',{icon:0,time:1000});
            }
            else{
                $(this).parent().remove();
                $('#add_Upload').show();
            }

        });
        if($('.delete_Upload').size() >= sm) {$(obj).hide();layer.msg('当前为最大图片添加量!',{icon:0,time:1000});}}
    /*checkbox激发事件*/
    $('#checkbox').on('click',function(){
        if($('input[name="checkbox"]').prop("checked")){
            $('.Date_selection ').css('display','block');
        }
        else{

            $('.Date_selection').css('display','none');
        }
    });
    function add_category(){
        $(".add_category_style").toggle();

    }
    function openDiv1() {
        if($("#openList").html()=="关闭"){
            $("#div1").hide();
            $("#openList").html("展开");
        }else{
            $("#div1").show();
            $("#openList").html("关闭");
        }


    }
    /******时间设置*******/
    var start = {
        elem: '#start',
        format: 'YYYY/MM/DD hh:mm:ss',
        min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16 23:59:59', //最大日期
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY/MM/DD hh:mm:ss',
        min: laydate.now(),
        max: '2099-06-16 23:59:59',
        istime: true,
        istoday: false,
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);
    /*********滚动事件*********/
    $("body").niceScroll({
        cursorcolor:"#888888",
        cursoropacitymax:1,
        touchbehavior:false,
        cursorwidth:"5px",
        cursorborder:"0",
        cursorborderradius:"5px"
    });
</script>
