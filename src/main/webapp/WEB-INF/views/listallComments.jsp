<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ForMe
  Date: 2019/4/1
  Time: 16:57
  To change this template use File | Settings | File Templates.
  本jsp用于显示一个话题的所有评论
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <title>评论</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script src="js/registerutils.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#messes").click(function(){

                $.ajax({
                    //提交数据的类型 POST GET
                    type:"POST",
                    //提交的网址
                    url:"aboutme",
                    //提交的数据
                    // data:{username:$("#username").val(),password:$("#password").val()},
                    //返回数据的格式
                    datatype: "json",
                    //成功返回之后调用的函数
                    success:function (data){
                        $("#username").val(data.username);
                        $("#password").val(data.password);
                        $("#sex").val(data.sex);
                        $("#qqnum").val(data.QQ);
                        $("#email").val(data.email);
                        $("#selfIntroduction").val(data.selfIntroduction);
                        toggle("orignmessage");
                        toggle("tablesss");
                        // alert("1320");

                        // document.getElementById("aboutmemessage").innerText = data.data;
                    },
                });
            });
        });
        //
        function toggle(id){
            var tb=document.getElementById(id);
            if(tb.style.display=='none')
                tb.style.display='block';
            else
                tb.style.display='none';
        }

    </script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#messes").click(function() {
                $("html, body").animate({
                    scrollTop: $("#btn3").offset().top }, {duration: 500,easing: "swing"});
                return false;
            });});

        var flag = true;
        function change(commentid,id,nums) {

            var x = document.getElementById(id).getAttribute("src");
            //
            // alert(x);
            if (x == "/images/trumpdown.jpg") {
                document.getElementById(id).src = "/images/trumpup.jpg";
                flag = false;
            }
            else {
                document.getElementById(id).src = "/images/trumpdown.jpg";
                flag = true;
                document.getElementById(id).title = "取消点赞";
            }

            setTimeout(function(){
                var spans = document.getElementById(id + 1000000);
                // alert(spans);
                if(flag == true)
                     spans.innerHTML = parseInt(nums) + 1;
                else
                    spans.innerHTML = nums;
            },1000);

            setTimeout(trump(commentid,flag),3000);
        }
            function trump(commentid,flag){
                ajax = $.ajax({
                    //提交数据的类型 POST GET
                    type: "POST",
                    //提交的网址
                    url: "maketrump",
                    //提交的数据
                    // data:{username:$("#username").val(),password:$("#password").val()},
                    data: {
                        'flag': flag,
                        'commentid':commentid
                    },
                    //返回数据的格式
                    dataType: "text",
                    //成功返回之后调用的函数
                    success: function (data) {
                        // location.reload();
                        // var c = parseInt(data.data);
                        // $("#commentids").html(data.commentid);
                        flag = true;
                    },
                });
            }

    </script>
</head>
<body>
<%--<h3 style="margin-top: 5%;text-align: center">${content}</h3>--%>
<%--<center>${time}</center>--%>
<%--<hr>--%>
<%--<div style="margin-left: 15%;">--%>
    <%--<a href="javascript:void(0)" id="btn" style="font-size: 18px">评论</a>&nbsp;--%>
<%--</div>--%>

<div class="wrapper">
    <div class="sidebar" data-color="blue" data-image="assets/img/sidebar-5.jpg">
        <%--<h1>欢迎来到主页！${username}</h1>--%>
        <div class="sidebar-wrapper">
            <div class="logo">
                <label class="simple-text" >
                    评 论
                </label>
            </div>
            <ul class="nav">
                <li>
                    <a href="/getAllChats">
                        <i class="pe-7s-note2"></i>
                        <p>所有话题</p>
                    </a>
                </li>
                <li>
                    <a href="/getAllMyChats">
                        <i class="pe-7s-news-paper"></i>
                        <p>我的发布</p>
                    </a>
                </li>
                <li>
                    <a href="/listAllMyComments">
                        <i class="pe-7s-science"></i>
                        <p>我的评论</p>
                    </a>
                </li>
                <li>
                    <a id="messes">
                        <i class="pe-7s-user"></i>
                        <p>个人信息</p>
                    </a>
                </li>
                <li>
                    <a href="/makeChats">
                        <i class="pe-7s-chat"></i>
                        <p>发布话题</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <label class="navbar-brand">Profile</label>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown">
                                评论排序
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="/listAllCommentsByTrums">按点赞数排序</a></li>
                                <li><a href="/listAllComments">按发布时间排序</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="/releasecommentss" title="评论">
                                <i class="pe-7s-comment" style="width: 15px;height: auto"></i>
                            </a>
                        </li>
                        <li>
                            <a href="/loginout">
                                注 销
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="content" style="display: none;" id="orignmessage">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8" >
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile</h4>
                            </div>
                            <div class="content" >
                                <form action="/updatemessage" method="post" >
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>username</label>
                                                <input type="text" class="form-control" id="username" name="username" onblur="ajax()">
                                                <span id="checkusername" style="color: red"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>password</label>
                                                <input type="text" class="form-control" id="password" name="password" onblur="check('password','checkpassword');checkpasswordLength()">
                                                <div id="checkpassword" style="color: red"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>sex</label>
                                                <input type="text" class="form-control" id="sex" name="sex" >
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>QQ</label>
                                                <input type="text" class="form-control" id="qqnum" name="qqnum" onblur="check('qqnum','checkqqnum');checkqqnumLength()">
                                                <div id="checkqqnum" style="color: red"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input type="text" class="form-control" disabled id="email" name="email">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>self-Introduction</label>
                                                <textarea type="text" class="form-control" id="selfIntroduction" name="selfIntroduction" onkeyup="wordStatic(this);" style="resize:none;width: 300px;height: 100px" maxlength="50"></textarea><div class="introduction_counter"><span id="num">0</span>/50</div>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-info btn-fill pull-right" name="getorignMessage" id="getorignMessage">Update Profile</button>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <div class="content" id="tablesss">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="content table-responsive table-full-width" >
                            <table class="table table-hover table-striped">
                                <tbody>
                                <tr>
                                    <td>
                                        <span style="font-size: 19px">${content}</span><br>
                                            <span style="size: 15px">${time}</span>
                                    </td>
                                </tr>
                                <tr><td><br></td></tr>
                                    <c:forEach items="${allComments}" var="listComments" varStatus="vs">
                                        <tr>
                                            <td>
                                                    ${vs.index + 1}楼<br><span style="font-size: 18px">${listComments.comment}</span>
                                                        <div style="font-size: 15px">发布者：${listComments.releasername} &nbsp;发布时间：${listComments.commenttime}&nbsp;</div>
                                                        <input type="image" src="/images/trumpup.jpg" style="width: 18px;height: 27px;outline: none" title="点赞" onclick="change('${listComments.commentid}',${vs.index},${listComments.trumps})" id="${vs.index}"/>
                                                        <span id="${vs.index + 1000000}">${listComments.trumps}</span><br>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<!--   Core JS Files   -->
<script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<!---<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>--->

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>
</html>
