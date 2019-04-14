var checkpasswordlength = false;
var checkQQlength = false;

// var checkusernameexist = false;
// var checkemailexist = false;
function ajax(){  //验证用户名
    var ajax = new XMLHttpRequest();
    var username = document.getElementById("username").value;
    var url = "checkusername";
    ajax.open("post",url,true);
    ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    ajax.onreadystatechange = function(){
        if(ajax.readyState == 4 && ajax.status == 200){
            var text = ajax.responseText;
            var spanText = document.getElementById("checkusername");
            spanText.innerHTML = text;
            // if(text != null)
            //     checkusernameexist = true;
        }
    }
    ajax.send("username=" + username);
}

function ajax2(){  //验证邮箱
    var ajax = new XMLHttpRequest();
    var email = document.getElementById("email").value;
    var url = "checkemail";
    ajax.open("post",url,true);
    ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    ajax.onreadystatechange = function(){
        if(ajax.readyState == 4 && ajax.status == 200){
            var text = ajax.responseText;
            var spanText = document.getElementById("checkemail");
            spanText.innerHTML = text;
            // if(text != null)
            //     checkemailexist = true;
        }
    }
    ajax.send("email=" + email);
}


function wordStatic(input) {
    // 获取要显示已经输入字数文本框对象
    var content = document.getElementById('num');
    if (content && input) {
        // 获取输入框输入内容长度并更新到界面
        var value = input.value;
        // 将换行符不计算为单词数
        value = value.replace(/\n|\r/gi,"");
        // 更新计数
        content .innerText = value.length;
    }
}

function check(id1,id2) {
    if(document.getElementById(id1).value == null || document.getElementById(id1).value.trim(" ") == "")
        document.getElementById(id2).innerHTML = id1 + '不能为空';
    else
        document.getElementById(id2).innerHTML ='';
}

function checkpasswordLength(){
    if(document.getElementById("password").value.length < 6 || document.getElementById("password").value.length > 16) {
        document.getElementById("checkpassword").innerHTML = '密码长度为6-16位';
        checkpasswordlength =  true;
    }
    return checkpasswordlength;
}

function checkqqnumLength(){
    if(document.getElementById("qqnum").value.length < 5 || document.getElementById("qqnum").value.length > 11) {
        document.getElementById("checkqqnum").innerText = 'QQ长度不对';
        checkQQlength =  true;
    }
    return checkQQlength;
}

function checkpassword() {
    if(document.getElementById("repassword").value != document.getElementById("password").value) {
        document.getElementById("checkrepassword").innerHTML = '两次密码不一致';
    }
    else {
        document.getElementById("checkrepassword").innerHTML = '';
    }
}
