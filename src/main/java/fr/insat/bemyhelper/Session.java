package fr.insat.bemyhelper;

import fr.insat.bemyhelper.Model.User;
import jakarta.servlet.http.HttpSession;

public class Session {
    public static User getSession(HttpSession session) {
        return (User) session.getAttribute("userLogged");
    }

    public static void setSession(HttpSession session, User user) {
        session.setAttribute("userLogged", user);
    }

    public static void removeSession(HttpSession session) {
        session.removeAttribute("userLogged");
    }

}
