<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ForMe
  Date: 2019/3/27
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <script src="jquery.min.js"></script>

    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/cropper/cropper.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/sitelogo/sitelogo.css" rel="stylesheet">

    <%--<script src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>--%>
    <script src="${pageContext.request.contextPath}/cropper/cropper.min.js"></script>
    <script src="${pageContext.request.contextPath}/sitelogo/sitelogo.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <script src="js/jquery-3.2.1.js."></script>
    <script src="js/registerutils.js"></script>

    <script type="text/javascript">
        //检测表单输入项不能为空
        function myCheck()
        {
            for(var i=0;i<document.registerform.elements.length-2;i++)
            {
                if(document.registerform.elements[i].value=="")
                {
                    alert("除了自我介绍表单不能有空项");
                    document.registerform.elements[i].focus();
                    return false;
                }
            }
            return true;
        }

    </script>

    <style type="text/css">
        input{
            border-radius: 6px;
            opacity:0.5;
        }

        body{
            background: url("/images/register.jpg");
            background-size: 100%;
            margin-top:50px;
        }

        p{
            font-size: 50px;
            text-align: center;
            font-family: 宋体;
        }

        .one3{
            width: 500px;
            height: 450px;
            margin: 0 auto;
        }

    </style>

</head>
<body>
<p>欢迎注册</p>

<%--下面注释掉的是上传头像，上面引入的文件没有注释掉--%>
<%--<div class="ibox-content">--%>
    <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
        <%--<div id="crop-avatar" class="col-md-6">--%>
            <%--<div class="avatar-view" title="Change Head Image" style="margin-left: 98%">--%>
                <%--<img src="default.jpg" alt="Logo" id="avatarShow">--%>
                <%--<input type="hidden" name="avatar" id="avatar">--%>
                <%--&lt;%&ndash;<img src="" alt=""  width="100px" height="100px">&ndash;%&gt;--%>
            <%--</div>--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--</div>--%>
<%--</div>--%>
<%--<br>--%>
<%--<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">--%>
    <%--<div class="modal-dialog modal-lg">--%>
        <%--<div class="modal-content">--%>
            <%--<form class="avatar-form" action="${pageContext.request.contextPath}/uploadHeadImage" enctype="multipart/form-data" method="post">--%>
                <%--<div class="modal-header">--%>
                    <%--<button class="close" data-dismiss="modal" type="button">&times;</button>--%>
                    <%--<h4 class="modal-title" id="avatar-modal-label">Change Logo Picture</h4>--%>
                <%--</div>--%>
                <%--<div class="modal-body">--%>
                    <%--<div class="avatar-body">--%>
                        <%--<div class="avatar-upload">--%>
                            <%--<input class="avatar-src" name="avatar_src" type="hidden">--%>
                            <%--<input class="avatar-data" name="avatar_data" type="hidden">--%>
                            <%--<label for="avatarInput">图片上传</label>--%>
                            <%--<input class="avatar-input" id="avatarInput" name="avatar_file" type="file"></div>--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-md-9">--%>
                                <%--<div class="avatar-wrapper"></div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3">--%>
                                <%--<!--<div class="avatar-preview preview-lg"></div>-->--%>
                                <%--<div class="avatar-preview preview-md"></div>--%>
                                <%--<!--<div class="avatar-preview preview-sm"></div>-->--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="row avatar-btns">--%>
                            <%--<div class="col-md-9">--%>
                                <%--<div class="btn-group">--%>
                                    <%--<button class="btn" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"><i class="fa fa-undo"></i> 向左旋转</button>--%>
                                <%--</div>--%>
                                <%--<div class="btn-group">--%>
                                    <%--<button class="btn" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"><i class="fa fa-repeat"></i> 向右旋转</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3">--%>
                                <%--<button class="btn btn-success btn-block avatar-save" type="submit" id="submit"><i class="fa fa-save"></i> 确定上传</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
<div class="one3" align="center">
    <form method="post" action="${pageContext.request.contextPath}/register" name="registerform" onsubmit="return myCheck()">
        <table style=" border-style:none;border: 1px solid #f0fff0;border-radius: 6px; text-align: center">
            <tr>
                <td>
                    <input name="username" type="text" onblur="ajax();check('username','checkusername')" id="username" placeholder="username" style="width: 200px"/>
                </td>
                <td>
                    <div id="checkusername" style="color: red"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <input name="password" type="password" onblur="check('password','checkpassword');checkpasswordLength()" placeholder="password长度为6-16位" id="password" style="width: 200px"/>
                </td>
                <td>
                    <div id="checkpassword" style="color: red"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <input name="repassword" type="password" id="repassword" onblur="checkpassword()" placeholder="请再次输入密码" style="width: 200px"/>
                </td>
                <td>
                    <div id="checkrepassword" style="color: red"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="radio" name="sex" value="male" checked>male<input type="radio" name="sex" value="female">female
                </td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <input name="qqnum" id="qqnum" type="text" onblur="check('qqnum','checkqqnum');checkqqnumLength()" placeholder="QQ" style="width: 200px"/>
                </td>
                <td>
                    <div id="checkqqnum" style="color: red"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <input name="email" style="width: 200px" type="text" id="email" onblur="ajax2()" placeholder="邮箱"></input>
                </td>
                <td>
                    <div id="checkemail" style="color: red"></div>
                </td>
            </tr>
            <tr>
                <td>
                <textarea type="text" name="selfIntroduction" onkeyup="wordStatic(this);" style="resize:none;border-radius: 6px;
            opacity:0.5;width: 300px; height: 100px" placeholder="自我介绍，不要多于500个字,可以不写" maxlength="50" class="introduction"></textarea>
                    <div class="introduction_counter"><span id="num">0</span>/50</div>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <div style="text-align: center;margin:0 auto; ">
                        <input style="text-align:center;border-radius: 6px;width: 150px;background-color: #00c4ff;border: none; font-size: medium;opacity:1;" value="注册" type="submit"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div style="text-align: center">
                        <a href="login.jsp"><font style="color: red;">登录</font></a>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>

</div>
</body>
</html>
