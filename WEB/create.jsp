<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加学生信息</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center">添加学生信息页面</h3>
    <br>
    <form action="${pageContext.request.contextPath}/create" method="post">
        <div class="form-group">
            <label for="studentId">学号：</label>
            <input type="text" class="form-control" id="studentId" name="studentId" placeholder="请输入学号">
        </div>
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="birthday">生日：</label>
            <input type="text" class="form-control" id="birthday" name="birthday" placeholder="请输入生日">
        </div>

        <div class="form-group">
            <label for="address">地址：</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="请输入地址"/>
            <%--<select name="address" class="form-control" id="address">--%>
                <%--<option value="陕西">武汉</option>--%>
                <%--<option value="北京">深圳</option>--%>
                <%--<option value="上海">广州</option>--%>
            <%--</select>--%>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" id="getBack"/>
        </div>
    </form>
</div>
<script>
    //给删除选中按钮添加单击事件
    document.getElementById("getBack").onclick = function(){
         window.history.back(-1);
    };
</script>
</body>
</html>