package servlet;

import cdi.ApplicationBean;
import cdi.RequestBean;
import cdi.SessionBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cavera/")
public class CaveraServlet extends HttpServlet {

    @Inject
    private ApplicationBean applicationBean;

    @Inject
    private SessionBean sessionBean;

    @Inject
    private RequestBean requestBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Funfou.");

        resp.getWriter().append("ok cavera");

        System.out.println("ApplicationBean: " + applicationBean.getContador());
        System.out.println("SessionBean: " + sessionBean.getContador());
        System.out.println("RequestBean: " + requestBean.getContador());
    }
}
