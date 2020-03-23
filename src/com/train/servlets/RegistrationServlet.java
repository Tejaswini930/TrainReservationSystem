package com.train.servlets;


import com.train.handlers.RegistrationHandler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


public class RegistrationServlet extends HttpServlet {


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String name=request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String user_id = request.getParameter("userid");
            String password= request.getParameter("password");
            String security_question = request.getParameter("security_question");
            String security_answer = request.getParameter("security_answer");

            RegistrationHandler registrationHandler = new RegistrationHandler();
            if(registrationHandler.insert(email,name,user_id,password,Long.parseLong(phone),gender,security_question,security_answer))
            {

                request.setAttribute("successMessage", "Registered Successfully. Now LogIn with your Credentials");
                RequestDispatcher rd = request.getRequestDispatcher("/LogInPage.jsp");
                rd.forward(request, response);

            }
            else
            {
                request.setAttribute("errorMessage","Error in Registration. Try again");
                RequestDispatcher rd = request.getRequestDispatcher("/RegistrationPage.jsp");
                rd.forward(request, response);
            }



        } 
		catch(Exception e)
		{
		  e.printStackTrace();
		}
        
        
    }


}
