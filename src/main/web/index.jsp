<%--
  Created by IntelliJ IDEA.
  User: liohamitec
  Date: 4/6/18
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login page</title>
  </head>
  <body>
  <table border="0" width="350" height="200" cellpadding="0" cellspacing="0" style="float:left;  margin:0 10px 0 0;">
      <tr><td>
          <table border="0">
              <tr>
                  <p style="color:#FF0000";>${message}</p>
              </tr>
              <tr>
                  <label><b>Please log in:</b></label>
              </tr>

              <form action="signin" method="POST">
                  <input type="hidden" name="action" value="login">

                  <tr>
                      <td><label>Username:</label></td>
                      <td><input type="text" name="user" required></td>
                  </tr>

                  <tr>
                      <td><label>Password:</label></td>
                      <td><input type="password" name="pass" required></td>
                  </tr>

                  <tr>
                      <td><input type="submit" value="Login" style="height:25px; width:80px"></td>
                      <td><input type="checkbox" id="checkbox1" name="staySigned" checked>
                          <label for="checkbox1">Stay signed in</label></td>
                  </tr>
              </form>

              <tr>
                  <td><h4><a href="/register.jsp">Register here!</a></h4></td>
              </tr>

          </table>
      </td></tr>
  </table>
  </body>
</html>
