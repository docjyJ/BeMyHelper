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

@WebServlet(name = "requestServlet", value = "/request/*")
public class Request extends HttpServlet {
    private static final String jspLink = "/WEB-INF/view/request/id.jsp";

    private Integer getId(HttpServletRequest request){
        String[] url = request.getPathInfo().split("/");
        if(url.length != 2) {
            return null;
        }
        try {
            return Integer.valueOf(url[1]);
        }
        catch (NumberFormatException e) {
            return null;
        }

    }

    private RequestEntity getRequestEntity(HttpServletRequest request, UserEntity user) {
        Integer id = getId(request);
        return id == null ? null : Factory.getInstance().getRequestManager().getId(id, user);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity s = Session.getSession(request.getSession());
        if (s == null) response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        else {
            RequestEntity rent = getRequestEntity(request, s);
            if(rent == null) response.sendError(HttpServletResponse.SC_NOT_FOUND);
            else {
                request.setAttribute("item", rent);
                getServletContext().getRequestDispatcher(jspLink).forward(request, response);
            }
        }
    }
}