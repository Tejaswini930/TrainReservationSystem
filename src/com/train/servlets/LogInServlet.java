package com.train.servlets;

import com.train.handlers.DataBaseHandler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import com.train.handlers.LogInAuthentication;
import org.apache.log4j.Logger;
import org.apache.log4j.Logger.*;
import org.apache.log4j.PropertyConfigurator;


public class LogInServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger("LogInServlet");
    public static HttpSession session;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // PropertyConfigurator.configure("log.properties.txt");
       // LOGGER.info("Entered doPost method");
        try {

            String userName=request.getParameter("userid");
            String password= request.getParameter("password");
            session = request.getSession();
            session.setAttribute("session",session);
            session.setAttribute("user", userName);

            if(new LogInAuthentication().validate(userName,password))
            {

              //  LOGGER.info("forwarding to AvailibilityPage.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("/AvailabilityPage.jsp");
                rd.forward(request, response);

            }
            else
            {

                session.invalidate();
                request.setAttribute("errorMessage", "Invalid user or password. Try Again");
                RequestDispatcher rd = request.getRequestDispatcher("/LogInPage.jsp");
                rd.forward(request, response);
            }


        } 
		catch(Exception e)
		{
		   // LOGGER.error(e.getMessage()+" error occurred");
		  e.printStackTrace();
		}
        
        
    }

 


}
