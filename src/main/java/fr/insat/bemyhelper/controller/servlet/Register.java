package fr.insat.bemyhelper.controller.servlet;


import fr.insat.bemyhelper.controller.Session;
import fr.insat.bemyhelper.controller.entityManager.UserManager;
import fr.insat.bemyhelper.controller.implementation.Factory;
import fr.insat.bemyhelper.model.HelperEntity;
import fr.insat.bemyhelper.model.NeederEntity;
import fr.insat.bemyhelper.model.UserEntity;
import fr.insat.bemyhelper.model.ValiderEntity;
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
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/welcome"));
        else
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManager um = Factory.getInstance().getUserManager();
        int code = 0;
        UserEntity userObj = null;

        String user = request.getParameter("user");
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String type = request.getParameter("type");
        if (um.exist(user))
            code = 1;
        else try {
            userObj = new UserEntity(first, last, user);
            userObj.setPassword(request.getParameter("pass"));
            System.out.println(type);
            switch (type) {
                case "Needer":
                    userObj.setNeeder(new NeederEntity(userObj));
                    break;
                case "Helper":
                    userObj.setHelper(new HelperEntity(userObj));
                    break;
                case "Valider":
                    userObj.setValider(new ValiderEntity(userObj));
                    break;
            }
            um.addNew(userObj);
        } catch (Exception e) {
            code = 2;
            userObj = null;
        }

        if (userObj == null) {
            request.setAttribute("userFill", user);
            request.setAttribute("firstFill", first);
            request.setAttribute("lastFill", last);
            request.setAttribute("typeFill", type);
            request.setAttribute("errorCode", code);
        } else
            Session.setSession(request.getSession(), userObj);
        doGet(request, response);

    }
}