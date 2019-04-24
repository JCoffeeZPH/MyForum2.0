<%--
  Created by IntelliJ IDEA.
  User: ForMe
  Date: 2019/3/27
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>verifymailbox</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
    <script src="js/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="css/jigsaw.css">

    <%--<script type="text/javascript">--%>
        <%--function toggle(id){--%>
            <%--var tb=document.getElementById(id);--%>
            <%--if(tb.style.display=='none')--%>
                <%--tb.style.display='block';--%>
        <%--}--%>

    <%--</script>--%>

    <style type="text/css">
        .container {
            width: 310px;
            margin: 100px auto;
        }
        #msg {
            width: 100%;
            line-height: 40px;
            font-size: 14px;
            text-align: center;
        }
        a:link,a:visited,a:hover,a:active {
            margin-left: 100px;
            color: #0366D6;
        }
    </style>
</head>
<body>
<h3 style="text-align: center">验证码已发邮箱请注意查收</h3>
<%--<div class="container">--%>
    <%--<div id="captcha" style="position: relative"></div>--%>
    <%--<div id="msg"></div>--%>
<%--</div>--%>

<%--<script type="text/javascript" src="js/jigsaw.js"></script>--%>
<%--<script type="text/javascript">--%>
    <%--jigsaw.init(document.getElementById('captcha'), function () {--%>
        <%--document.getElementById('msg').innerHTML = '验证成功'--%>
        <%--setTimeout(function() {--%>
            <%--document.getElementById("buttonid").click();});--%>
    <%--})--%>
<%--</script>--%>

<%--<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>--%>
<%--<div style="text-align: center">--%>
    <%--<button onclick="toggle('sss')" id="buttonid" style="display: none"></button>--%>
<%--</div>--%>
<form action="homepage" method="post" style="text-align: center;" id="sss">
    请输入验证码：<input type="text" name="verificationcode">&nbsp;<input type="submit" value="确定">
</form>

</body>
</html>
