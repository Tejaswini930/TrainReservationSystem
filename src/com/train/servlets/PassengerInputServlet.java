package com.train.servlets;

import com.train.servletutil.PassengerInputUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PassengerInputServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
        int passengerCount = Integer.parseInt(request.getParameter("passengerCount"));
        String coachClass = request.getParameter("coachClass");
        LogInServlet.session.setAttribute("passengerCount",passengerCount);
        LogInServlet.session.setAttribute("coachClass",coachClass);
        LogInServlet.session.setAttribute("trainNumber",trainNumber);

        int serialno = 1;
        String tablePrint = "";
        if(new PassengerInputUtil().validatePassenger(trainNumber,passengerCount,coachClass)){

            tablePrint = new PassengerInputUtil().generateInputTable(tablePrint,passengerCount);
            LogInServlet.session.setAttribute("passengerDetails",tablePrint);
          //  LogInServlet.session.setAttribute("trainsDetails", "");
            request.setAttribute("passengerDetails",tablePrint);
            request.setAttribute("trainDetails","");
            tablePrint="";
        }
        else{
            tablePrint="<span style='Color:Red;'>Your required number of tickets is not available, Kindly check the availability once again!!!</span>";
            LogInServlet.session.setAttribute("passengerDetails",tablePrint);
            request.setAttribute("passengerDetails",tablePrint);
            request.setAttribute("trainDetails",LogInServlet.session.getAttribute("trainsDetails"));
        }

        RequestDispatcher rd = request.getRequestDispatcher("/BookingPage.jsp");
        rd.forward(request, response);
    }
}
