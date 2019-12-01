<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改学生信息</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改学生信息</h3>
            <br>
        <form action="${pageContext.request.contextPath}/update" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${requestScope.student.id}">
          <div class="form-group">
            <label for="studentId">学号：</label>
            <input type="text" class="form-control" id="studentId" name="studentId"  value="${requestScope.student.studentId}" readonly="readonly" placeholder="请输入学号" />
          </div>

          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${requestScope.student.name}" readonly="readonly" placeholder="请输入姓名" />
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${requestScope.student.gender == '男'}">
                  <input type="radio" name="gender" value="男" checked />男
                  <input type="radio" name="gender" value="女"  />女
              </c:if>

              <c:if test="${requestScope.student.gender == '女'}">
                  <input type="radio" name="gender" value="男"  />男
                  <input type="radio" name="gender" value="女" checked  />女
              </c:if>
          </div>

          <div class="form-group">
            <label for="birthday">生日：</label>
            <input type="text" class="form-control" value="${requestScope.student.birthday}" id="birthday"  name="birthday" placeholder="请输入生日" />
          </div>

          <div class="form-group">
            <label for="address">地址：</label>
            <input type="text" id="address" class="form-control" value="${requestScope.student.address}" name="address" placeholder="请输入地址"/>
             <%--<select name="address" id="address" class="form-control" >--%>
                 <%--<c:if test="${requestScope.student.address == '陕西'}">--%>
                    <%--<option value="陕西" selected>陕西</option>--%>
                    <%--<option value="北京">北京</option>--%>
                    <%--<option value="上海">上海</option>--%>
                 <%--</c:if>--%>

                 <%--<c:if test="${requestScope.student.address == '北京'}">--%>
                     <%--<option value="陕西" >陕西</option>--%>
                     <%--<option value="北京" selected>北京</option>--%>
                     <%--<option value="上海">上海</option>--%>
                 <%--</c:if>--%>

                 <%--<c:if test="${requestScope.student.address == '上海'}">--%>
                     <%--<option value="陕西" >陕西</option>--%>
                     <%--<option value="北京">北京</option>--%>
                     <%--<option value="上海" selected>上海</option>--%>
                 <%--</c:if>--%>
            <%--</select>--%>
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" value="${requestScope.student.qq}" name="qq" placeholder="请输入QQ号码"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${requestScope.student.email}" name="email" placeholder="请输入邮箱地址"/>
          </div>

         <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
         </div>
        </form>
        </div>
    </body>
</html>