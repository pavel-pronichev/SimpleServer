package servlets;

import main.AccauntService;
import main.UserProfile;
import templator.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by skyrex on 20.09.15.
 */
public class SignUpUsers extends HttpServlet{

    private AccauntService accauntService;

    public SignUpUsers(AccauntService accauntService){
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
        HashMap<String,Object> pageValue = new HashMap<String, Object>();

        String sessionId = req.getSession().toString();
        String name = req.getParameter("login");
        String pwd = req.getParameter("password");

        UserProfile userProfile = new UserProfile(name, pwd);

        if(accauntService.addUser(name, userProfile)){
            accauntService.addSession(sessionId, userProfile);
            pageValue.put("status", "Succes");
            //pageValue.put("sessionid", sessionId.toString());

            resp.getWriter().println(PageGenerator.getPage("authstatus.html", pageValue));

        } else{
            accauntService.getSession(sessionId);
            pageValue.put("status", "Denied");
            //pageValue.put("id", sessionId.toString());

            resp.getWriter().println(PageGenerator.getPage("authstatus.html", pageValue));
        }

    }
}
