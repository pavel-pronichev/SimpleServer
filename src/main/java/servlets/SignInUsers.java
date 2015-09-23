package servlets;

import main.AccauntService;
import templator.PageGenerator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by skyrex on 20.09.15.
 */
public class SignInUsers extends HttpServlet {

    private AccauntService accauntService;

    public SignInUsers(AccauntService accauntService){
        this.accauntService = accauntService;
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String sessionId =  req.getSession().toString();

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(PageGenerator.getPage("regform.html", new HashMap<String, Object>()));



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
