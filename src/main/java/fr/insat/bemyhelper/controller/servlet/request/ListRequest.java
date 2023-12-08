package fr.insat.bemyhelper.controller.servlet.request;

import fr.insat.bemyhelper.controller.Session;
import fr.insat.bemyhelper.controller.implementation.Factory;
import fr.insat.bemyhelper.model.RequestEntity;
import fr.insat.bemyhelper.model.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "listRequestServlet", value = "/request")
public class ListRequest extends HttpServlet {

    private static final String jspLink = "/WEB-INF/view/request/list.jsp";

    private void processView(HttpServletRequest request, UserEntity s) {
        if (s.isANeeder())
            request.setAttribute(
                    "requestsList", Factory.getInstance().getRequestManager().listFromUser(s.getNeeder()));
        else if (s.isAHelper())
            request.setAttribute("requestsList", Factory.getInstance().getRequestManager().listValidated());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity s = Session.getSession(request.getSession());
        if (s == null)
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        else {
            processView(request, s);
            this.getServletContext().getRequestDispatcher(jspLink).forward(request, response);
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity s = Session.getSession(request.getSession());
        if (s == null)
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        else {
            int code = 0;
            try {
                if (s.isANeeder()) {
                    code = 2;
                    String desc = request.getParameter("description");
                    if (!desc.isEmpty() && desc.length() < 256) {
                        RequestEntity req = new RequestEntity(desc, s.getNeeder());
                        req.setState(2);
                        Factory.getInstance().getRequestManager().addNew(req);
                    }
                    else code = 1;
                }
            } catch (Exception e) {
                code = 1;
            }
            request.setAttribute("errorCode", code);
            processView(request, s);
            this.getServletContext().getRequestDispatcher(jspLink).forward(request, response);
        }
    }
}