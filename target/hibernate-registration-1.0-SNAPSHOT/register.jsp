<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<table border="0" width="350" height="200" cellpadding="0" cellspacing="0" style="float:left;  margin:0 10px 0 0;">
    <tr><td>
        <table border="0">
            <tr>
                <p style="color:#FF0000";>${message}</p>
            </tr>
            <tr>
                <label><b>Please enter your details:</b></label>
            </tr>

            <form action="signup" method="POST">
                <tr>
                    <td><label>Username:</label></td>
                    <td><input type="text" name="user" required></td>
                </tr>

                <tr>
                    <td><label>Password:</label></td>
                    <td><input type="password" name="pass1" required></td>
                </tr>
                <tr>
                    <td><label>Confirm password:</label></td>
                    <td><input type="password" name="pass2" required></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><input type="email" name="email" required></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Register" style="height:25px; width:80px"></td>
                </tr>
            </form>

            <tr>
                <td><h4><a href="/index.jsp">Back to login page</a></h4></td>
            </tr>

        </table>
    </td></tr>
</table>
</body>
</html>
