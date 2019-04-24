<%--
  Created by IntelliJ IDEA.
  User: ForMe
  Date: 2019/3/28
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录界面</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
    <link rel="icon" type="image/png" href="/assets/img/favicon.ico">
    <%
        String username = "";
        String password = "";
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if ("username".equals(cookies[i].getName())) {
                username = cookies[i].getValue();
            } else if ("password".equals(cookies[i].getName())) {
                password = cookies[i].getValue();
            }
        }
    %>

    <link rel="stylesheet" href="css/jigsaw.css">
    <style type="text/css">
        input{
            border-radius: 6px;
            opacity:0.5;
        }

        .one3{
            width: 500px;
            height: 50px;
            margin: 0 auto;
        }

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
        body{
            background: url("/images/loginbackgroud.png");
        }
        a:link {color: black} /*未访问的链接 */
        a:visited {color: blue} /*已访问的链接 */
        a:hover {color: red} /*鼠标移动到链接上 */
        a:active {color: orangered} /*选定的链接 */

    </style>

    <script type="text/javascript">

        function toggle(id){
            var tb=document.getElementById(id);
            if(tb.style.display=='none')
                tb.style.display='block';
        }

        function checkusername() {
            if(document.getElementById("username").value == null || document.getElementById("username").value.trim(" ") == "")
                document.getElementById("testusername").innerHTML = '用户名不能为空';
            else
                document.getElementById("testusername").innerHTML ='';
        }

        function checkpassword() {
            if(document.getElementById("password").value == null || document.getElementById("password").value.trim(" ") == "")
                document.getElementById("testpassword").innerHTML = '密码不能为空';
            else
                document.getElementById("testpassword").innerHTML ='';
        }

    </script>
</head>

<body>
    <form action="login" method="post">
        <div class="one3" align="center">
        <table style="border-style:none;border: 1px solid #f0fff0;border-radius: 6px; text-align: center;margin-top: 40%">
            <tr>
                <td>
                    <input name="username" type="text" id="username" placeholder="username" style="width: 200px;height: 30px" onblur="checkusername()" value="<%=username%>">
                </td>
                <td>
                    <div id="testusername" style="color: red"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <input name="password" type="password" id="password" placeholder="password" style="width: 200px;height: 30px" onblur="checkpassword()" value="<%=password%>"/>
                </td>
                <td>
                    <div id="testpassword" style="color: red"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" value="y" name="isLogin">3天内记住我
                </td>
            </tr>
            <tr>
                <td>
                    <input id="subt" style="text-align:center;border-radius: 6px;width: 250px;background-color: #00c4ff;border: none; font-size: medium;opacity:1;" value="登录" type="submit"/>
                </td>
            </tr>
        </table>
        </div>
    </form>
    <div style="margin-left: 40%;margin-top: 6%;font-size: 20px">
        <a href="register.jsp">注 册</a>
    </div>

<%--<div class="container">--%>
    <%--<div id="captcha" style="position: relative;"></div>--%>
    <%--<div id="msg"></div>--%>
<%--</div>--%>

<%--<script type="text/javascript" src="js/jigsaw.js"></script>--%>
<%--<script type="text/javascript">--%>
    <%--jigsaw.init(document.getElementById('captcha'), function () {--%>
        <%--document.getElementById("msg").innerHTML='验证成功';--%>
        <%--setTimeout(function() {--%>
            <%--document.getElementById("buttonid").click();});--%>
    <%--})--%>
<%--</script>--%>

<%--<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">--%>
<%--</div>--%>
<%--<div style="text-align: center">--%>
    <%--<button onclick="toggle('subt')" id="buttonid" style="display: none"></button>--%>
<%--</div>--%>
</body>
</html>
