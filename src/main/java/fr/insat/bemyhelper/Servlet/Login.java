package fr.insat.bemyhelper.Servlet;


import fr.insat.bemyhelper.DataBase.MySql.Factory;
import fr.insat.bemyhelper.Model.User;
import fr.insat.bemyhelper.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Session.getSession(request.getSession()) != null)
            response.sendRedirect("welcome");
        else
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        User userObj = null;
        String user = request.getParameter("user");
        if (!Factory.getInstance().getUsers().exist(user))
            code = 1;
        else {
            String pass = request.getParameter("pass");
            userObj = Factory.getInstance().getUsers().correctPassword(user, pass);
            if (userObj == null)
                code = 2;
        }
        if (userObj == null){
            request.setAttribute("userFill", user);
            request.setAttribute("errorCode", code);
        }
        else
            Session.setSession(request.getSession(), userObj);
        doGet(request, response);
    }
}