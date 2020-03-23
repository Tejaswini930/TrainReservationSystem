package com.train.servlets;

import com.train.handlers.DataBaseHandler;
import com.train.servletutil.CheckAvailabilityUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class InsertDetailsServlet extends HttpServlet {

    private Connection connection = DataBaseHandler.getConnection();
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    public ResultSet resultSet;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String temp="";
        String tablePrint="";
        PrintWriter out= response.getWriter();
        try {
            preparedStatement = connection.prepareStatement("select pnr from ticket");
            int pnr = Integer.MIN_VALUE;

            resultSet= preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String pnrNumber = resultSet.getString(1);
                if(Integer.parseInt(pnrNumber.substring(3)) > pnr)
                {
                    pnr = Integer.parseInt(pnrNumber.substring(3));
                }
            }
            out.println("hello");
                     out.println("hello");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.now();
            int trainNumber= (int)LogInServlet.session.getAttribute("trainNumber");
            int passengerCount=(int)LogInServlet.session.getAttribute("passengerCount");
            String coachClass = (String)LogInServlet.session.getAttribute("coachClass");
            LogInServlet.session.setAttribute("bookingDate",dtf.format(localDate));
            Date date = new CheckAvailabilityUtil().getDate((String) LogInServlet.session.getAttribute("dateOfJourney"));
            LogInServlet.session.setAttribute("primaryPassenger", request.getParameter("pname1"));
            preparedStatement = connection.prepareStatement("insert into ticket values('PNR"+ ++pnr +"',"+
                    +trainNumber+
                    ",'"+LogInServlet.session.getAttribute("source")+
                    "','"+LogInServlet.session.getAttribute("destination")+
                    "','"+date+
                    "','"+LogInServlet.session.getAttribute("sourceTime")+
                    "','"+LogInServlet.session.getAttribute("departureTime")+
                    "','"+request.getParameter("pname1")+
                    "',"+passengerCount+
                    ",'"+request.getParameter("phoneNumber")+
                    "','"+dtf.format(localDate)+
                    "','"+dtf.format(localDate)+
                    "','"+LogInServlet.session.getAttribute("source")+
                    "','"+coachClass+
                    "','"+LogInServlet.session.getAttribute("user")+
                    "')");
            out.println("hello");
            int flag= preparedStatement.executeUpdate();
            out.println("hello");
            preparedStatement = connection.prepareStatement("select "+coachClass+"_coaches, "+coachClass+"_seats_per_coach from train where train_number = ?");
            preparedStatement.setInt(1,trainNumber);
            out.println("hello");
            resultSet= preparedStatement.executeQuery();
            out.println("hello");
            HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
            resultSet.next();
            String coachClassShrt=coachClass.equals("sleeper")?"S":coachClass.equals("seater")?"SE":coachClass.equals("2ac")?"B":"C";
            int i = 1;  out.println("hello");
            while(i<=resultSet.getInt(1)){
                out.println("hello");
                ArrayList<Integer> bookedSeatNumbers = new ArrayList<>();
                ArrayList<Integer> availableSeatNumbers = new ArrayList<>();
                preparedStatement = connection.prepareStatement("select seat_no from passenger A inner join ticket B on A.pnr=B.pnr " +
                        " where B.date_of_journey=?"+
                        " AND B.train_number=? " +
                        " AND A.status='confirmed' " +
                        " AND A.coach=?");

                date = new CheckAvailabilityUtil().getDate((String) LogInServlet.session.getAttribute("dateOfJourney"));
                preparedStatement.setDate(1,date);
                preparedStatement.setInt(2,trainNumber);
                preparedStatement.setString(3,coachClassShrt+i);
                ResultSet resultSet2= preparedStatement.executeQuery();
                out.println("hello");
                while(resultSet2.next()){
                    bookedSeatNumbers.add(Integer.parseInt(resultSet2.getString(1)));
                }
                for(int j=1;j<=resultSet.getInt(2);j++){
                    if(!bookedSeatNumbers.contains(j)){
                        availableSeatNumbers.add(j);
                    }
                }
                hm.put(coachClassShrt+i,availableSeatNumbers);
                i++;
            }  out.println("hello");
            int bookedSeat = 1;
             tablePrint="<tr><th colspan='2'>PNR Number </th><th colspan='2'>PNR"+pnr+"</th></tr></table>"+
                    "<table align='center' border='1' cellspacing='2'><tr><th colspan='7'>Booked Passenger Details</th></tr>"+
                    "<tr><th>S.No</th><th>Passenger Name</th><th>Passenger Age</th><th>Passenger Gender</th><th>Coach</th<th>Seat Number</th>><th>Status</th></tr>";
            for(Map.Entry m : hm.entrySet()){
                ArrayList<Integer> availbleSeat = (ArrayList<Integer>) m.getValue();
                for(int j=0;j<availbleSeat.size() && bookedSeat<=passengerCount;j++,bookedSeat++){
                    preparedStatement = connection.prepareStatement("insert into passenger values('PNR"+ pnr +"',"+
                            trainNumber+
                            ",'"+"status"+
                            "',"+request.getParameter("page"+bookedSeat)+
                            ",'"+request.getParameter("pgender"+bookedSeat)+
                            "','"+request.getParameter("pname"+bookedSeat)+
                            "','"+availbleSeat.get(j)+
                            "','"+m.getKey()+
                            "')");
                        tablePrint=tablePrint+"<tr>"+
                                "<td>"+bookedSeat+"</td>"+
                                "<td>"+request.getParameter("pname"+bookedSeat)+"</td>"+
                                "<td>"+request.getParameter("page"+bookedSeat)+"</td>"+
                                "<td>"+request.getParameter("pgender"+bookedSeat)+"</td>"+
                                "<td>"+m.getKey()+"</td>"+
                                "<td>"+availbleSeat.get(j)+"</td>"+
                                "<td>Confirmed</td></tr>";
                    flag= preparedStatement.executeUpdate();
                }
                if( bookedSeat>passengerCount)
                    break;
            }
            tablePrint=tablePrint+"</table>";
            request.setAttribute("bookPrint", tablePrint);
            RequestDispatcher rd = request.getRequestDispatcher("/Booked.jsp");
            rd.forward(request, response);
        }catch (SQLException e) {
            temp=e.getMessage().toString();
            e.printStackTrace();
        }

    }
}