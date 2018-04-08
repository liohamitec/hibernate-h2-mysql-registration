package servlets;

import dbService.DBService;
import dbService.datasets.UsersDataSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    private DBService dbService;

    @Override
    public void init() {
        dbService = (DBService) getServletContext().getAttribute("dbService");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("user");
        String pass = request.getParameter("pass");

        response.setContentType("text/html;charset=utf-8");
        String message = "";

        if (login == null || pass == null) {
            message = "username or password shouldn't be empty";
        } else {
            UsersDataSet profile = dbService.getUser(login);
            if (profile == null) {
                message = "user doesn't exist!";
            } else if (!profile.getPassword().equals(pass)) {
                message = "wrong password!";
            } else {
                PrintWriter out = response.getWriter();
                out.print("Authorized: " + login);
                response.setStatus(HttpServletResponse.SC_OK);
                out.close();
            }
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

}