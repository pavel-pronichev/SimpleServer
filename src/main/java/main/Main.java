package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInUsers;
import servlets.SignUpUsers;

import javax.servlet.Servlet;
import java.io.IOException;

/**
 * Created by skyrex on 20.09.15.
 */
public class Main {

    public static void main(String[] args) throws Exception{

        AccauntService accauntService = new AccauntService();

        Servlet signIn = new SignInUsers(accauntService);
        Servlet signUp = new SignUpUsers(accauntService);


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(signIn), "/signin");
        context.addServlet(new ServletHolder(signUp), "/signup");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
