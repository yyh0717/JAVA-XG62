package cn.edu.sdjzu.xg.bysj.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCookies")
public class CookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            response.getWriter().println("no cookies available");
        } else {
            for (Cookie cookie : cookies) {
                response.getWriter().println(cookie.getName() + " = " + cookie.getValue());
            }
        }
    }
}
