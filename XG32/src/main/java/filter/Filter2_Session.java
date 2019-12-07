package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filter 2",urlPatterns = {"/*"})
public class Filter2_Session implements Filter {
    public void destroy() {
    }
//123
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter 2 - LoginSessionFilter begin!");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession(false);
        String path = request.getRequestURI();
        if (path.contains("/Login.ctl") || path.contains("/Logout.ctl")){//let login and logout go
            chain.doFilter(req, resp);
            System.out.println("Filter 2 - LoginSessionFilter ends!");
        }else  if (session != null && session.getAttribute("currentUser") != null){//if login ,then go
            chain.doFilter(req,resp);
            System.out.println("Filter 2 - LoginSessionFilter ends!");
        }else {//u have to login firstly
            response.getWriter().println("您没有登录，请登录");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
