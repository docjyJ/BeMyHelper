package fr.insat.bemyhelper.controller;

import fr.insat.bemyhelper.model.UserEntity;
import jakarta.servlet.http.HttpSession;

public class Session {
    public static UserEntity getSession(HttpSession session) {
        return (UserEntity) session.getAttribute("userLogged");
    }

    public static void setSession(HttpSession session, UserEntity user) {
        session.setAttribute("userLogged", user);
    }

    public static void removeSession(HttpSession session) {
        session.removeAttribute("userLogged");
    }

}
