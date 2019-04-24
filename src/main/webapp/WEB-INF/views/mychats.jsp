<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ForMe
  Date: 2019/4/1
  Time: 13:33
  To change this template use File | Settings | File Templates.
  查看我发表的话题,和listAllChats.jsp界面基本一致
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8"/>
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <title>My Chats</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">

    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <%--<link href="assets/css/demo.css" rel="stylesheet" />--%>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

    <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
    <script src="/js/registerutils.js"></script>
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

    <style type="text/css">
        a:link {color: black} /*未访问的链接 */
        a:visited {color: blue} /*已访问的链接 */
        a:hover {color: red} /*鼠标移动到链接上 */
        a:active {color: orangered} /*选定的链接 */
    </style>
</head>
<body>
<div class="wrapper">
    <div class="sidebar" data-color="blue" data-image="assets/img/sidebar-5.jpg">
        <%--<h1>欢迎来到主页！${username}</h1>--%>
        <div class="sidebar-wrapper">
            <div class="logo">
                <label class="simple-text" >
                    我的发布
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
                                    <c:forEach items="${listAllMyChats}" var="list">
                                    <tr>
                                        <td>
                                            <a href="/listAllComments?chatid=${list.chatid}" style="font-size: 18px;">${list.content}</a><br>
                                            发布时间：${list.releasetime} <a href="/deleteThisChat?chatid=${list.chatid}"> 删除</a>
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
</html>
