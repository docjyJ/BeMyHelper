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

@WebServlet(name = "registerServlet", value = "/register")
public class Register extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Session.getSession(request.getSession()) != null)
            response.sendRedirect("welcome");
        else
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = 0;
        User userObj = null;

        String user = request.getParameter("user");
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String type = request.getParameter("type");
        if (Factory.getInstance().getUsers().exist(user))
            code = 1;
        else try {
                userObj = new User(first, last, user, type);
                String pass = request.getParameter("pass");
                if (Factory.getInstance().getUsers().addNew(userObj, pass) != 1) {
                    userObj = null;
                    code = 2;
                }
            } catch (IllegalArgumentException e) {
                code = 3;
            }

        if (userObj == null) {
            request.setAttribute("userFill", user);
            request.setAttribute("firstFill", first);
            request.setAttribute("lastFill", last);
            request.setAttribute("typeFill", type);
            request.setAttribute("errorCode", code);
        }
        else
            Session.setSession(request.getSession(), userObj);
        doGet(request, response);

    }
}