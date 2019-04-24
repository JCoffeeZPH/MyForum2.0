<%--
  Created by IntelliJ IDEA.
  User: ForMe
  Date: 2019/4/10
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
    <title>发布话题</title>
    <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
    <script src="js/registerutils.js"></script>
</head>
<body>
<form action="/releaseChats" method="post">
    <center>
        <textarea id="contect_text" cols="20" rows="2" class="ckeditor" name="mycomment" style="resize: none" onkeyup="wordStatic(this)" ></textarea>
        <%--<div class="introduction_counter"><span id="num">0</span>/50</div>--%>
        <br>
        <br>
        <input type="submit" name="" id="" value="发布" style="font-size: 22px">
        <br>
        <h3>不要超过300字</h3>
    </center>
</form>

<script type="text/javascript">
    var maxlength = 300;
    // CKEDITOR.replace('contect_text',
    //     { toolbar:'Basic', height:400,width:1000 });
    //示例2：工具栏为自定义类型
    CKEDITOR.replace('contect_text',
        {
            filebrowserImageUploadUrl:'/uploadPic',
            language : 'zh-cn',
            width:1000,
            height:400,
            toolbar :
                [
                    //加粗     斜体
                    ['Source','Undo','Redo'],
                    //超链接  取消超链接
                    ['Link','Unlink'],
                    //图片     表情      特殊字符   查找
                    ['Image','Smiley','SpecialChar','Find '],
                    '/',
                        // 字体    字体大小
                    ['Font','FontSize'],
                    //文本颜色     背景颜色
                    ['TextColor','BGColor','About'],
                ]
        }
    );
</script>
</body>
</html>
