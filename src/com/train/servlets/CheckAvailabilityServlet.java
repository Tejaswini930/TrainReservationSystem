package com.train.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.*;
import com.train.handlers.TrainAvailabilityHandler;
import com.train.servletutil.CheckAvailabilityUtil;


public class CheckAvailabilityServlet extends HttpServlet {

    private String tablePrint;
    TrainAvailabilityHandler trainAvailabilityHandler = new TrainAvailabilityHandler();
    HashMap <Integer, JourneyDetails>  trains = new HashMap<>();


   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            PrintWriter out = response.getWriter();
            String source = request.getParameter("source");
            String destination = request.getParameter("destination");
            String DOJ = request.getParameter("date");
            LogInServlet.session.setAttribute("source",source);
            LogInServlet.session.setAttribute("destination",destination);
            LogInServlet.session.setAttribute("dateOfJourney",DOJ);
            String dayOfWeek = new CheckAvailabilityUtil().getdayOfWeek(DOJ);
            ResultSet trainDetails = trainAvailabilityHandler.getTrainNumbers(source, destination, dayOfWeek);
            String tablePrint = new CheckAvailabilityUtil().initializeTrainTable();
            int count=1;
            trains = new HashMap<>();
            while (trainDetails.next()) {
                out.println(DOJ);
                ResultSet filledSeats = trainAvailabilityHandler.getTotalSeats(trainDetails.getInt(2),DOJ);
                out.println("hi");
                out.println("hi12");
                filledSeats.next();
                JourneyDetails s = new JourneyDetails(trainDetails.getInt(2),trainDetails.getString(1), source,
                        destination , trainDetails.getTime(7), trainDetails.getTime(8) ,
                        (trainDetails.getInt(3)-(filledSeats.getRow() == 0?0:filledSeats.getInt(2))) ,
                        (trainDetails.getInt(4)-(filledSeats.getRow() == 0?0:filledSeats.getInt(3))),
                        (trainDetails.getInt(5)-(filledSeats.getRow() == 0?0:filledSeats.getInt(4))),
                        (trainDetails.getInt(6)-(filledSeats.getRow() == 0?0:filledSeats.getInt(5))));
                trains.put(trainDetails.getInt(2),s);
                out.println("hi12");
                tablePrint = new CheckAvailabilityUtil().updateTablePrint(tablePrint,count++,trainDetails.getInt(2),trainDetails.getString(1),
                        source,destination,trainDetails.getTime(7),trainDetails.getTime(8),trainDetails.getInt(3)-(filledSeats.getRow() == 0?0:filledSeats.getInt(2)),
                        (trainDetails.getInt(4)-(filledSeats.getRow() == 0?0:filledSeats.getInt(3))),
                        (trainDetails.getInt(5)-(filledSeats.getRow() == 0?0:filledSeats.getInt(4))),
                        (trainDetails.getInt(6)-(filledSeats.getRow() == 0?0:filledSeats.getInt(5))));
                out.println("hi12");

            }

            LogInServlet.session.setAttribute("trainsDetails",tablePrint+"</table>");
            if(count==1)
            {
                tablePrint=tablePrint+"<tr></td><span style='color : Red; font-weight : bold;'><b><h2>NO Trains Available</h2></b></span></td></tr></table>";
            }
            else{
                tablePrint = tablePrint + "<tr><td><a href='BookingPage.jsp'>Book</a></td></tr> </table>";
            }
            out.println("hi12");
            request.setAttribute("tablePrint", tablePrint);
            LogInServlet.session.setAttribute("trainNumbers",trains);
            out.println("hi12");
            RequestDispatcher rd = request.getRequestDispatcher("/AvailabilityPage.jsp");
            rd.forward(request, response);
            out.println("hi12");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }












}