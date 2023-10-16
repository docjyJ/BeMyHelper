package fr.insat.bemyhelper.Servlet.Request;

import fr.insat.bemyhelper.DataBase.MySql.Factory;
import fr.insat.bemyhelper.Model.User;
import fr.insat.bemyhelper.Model.UserType;
import fr.insat.bemyhelper.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "listRequestServlet", value = "/request")
public class ListRequest extends HttpServlet {

    private static final String jspLink = "/WEB-INF/view/request/list.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User s = Session.getSession(request.getSession());
        if (s == null)
            response.sendRedirect("login");
        else
            this.getServletContext().getRequestDispatcher(jspLink).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User s = Session.getSession(request.getSession());
        if (s == null)
            response.sendRedirect("login");
        else {
            int code = 0;
            if (s.getType() == UserType.Needer){
                code = 1;
                String desc = request.getParameter("description");
                if(!desc.isEmpty() && desc.length() < 256)
                    if (Factory.getInstance().getRequests().addNew(s, desc) == 1)
                        code = 2;
            }
            request.setAttribute("errorCode", code);
            this.getServletContext().getRequestDispatcher(jspLink).forward(request, response);
        }


    }



}