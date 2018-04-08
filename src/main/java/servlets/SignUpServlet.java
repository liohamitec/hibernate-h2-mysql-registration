package servlets;

import dbService.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/signup")
public class SignUpServlet extends javax.servlet.http.HttpServlet {
    private DBService dbService;

    @Override
    public void init() {
        dbService = (DBService) getServletContext().getAttribute("dbService");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("user");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        String email = request.getParameter("email");

        response.setContentType("text/html;charset=utf-8");
        String message;
        String dispatcher = "/register.jsp";

        if (login == null) {
            message = "username field shouldn't be empty!";
        } else if (pass1 == null) {
            message = "password field shouldn't be empty!";
        } else if (!pass1.equals(pass2)) {
            message = "passwords aren't equal!";
        } else if (email == null) {
            message = "email field shouldn't be empty!";
        } else if (dbService.getUser(login) != null) {
            message = "user already exists!";
        } else if (dbService.checkEmail(email)) {
            message = "user with this email already registered!";
        } else {
                dbService.addUser(login,pass1,email);
                message = "User successfully added! Please log in.";
                dispatcher = "/index.jsp";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher(dispatcher).forward(request,response);
    }

}