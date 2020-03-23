package com.train.servletutil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckAvailabilityUtil {

    private  String tablePrint;

    public  String initializeTrainTable()
    {
        tablePrint = "<table cellpadding='5' align='center' border='1'>";
        tablePrint= tablePrint+  "<tr>" +
                "<th>S.no</th>"+
                "<th>Train Number</th>"+
                "<th>Train Name</th>"+
                "<th>JounrneySRC</th> " +
                "<th>JourneyDEST</th> " +
                "<th>DepartureTime</th>" +
                "<th>ArrivalTime</th>"+
                "<th>SleeperAvailability</th>" +
                "<th>SeaterAvailabilty</th>" +
                "<th>AC2Availabilty</th>" +
                "<th>AC3Availabilty</th>" +
                "</tr>"
        ;

        return tablePrint;
    }

    public String updateTablePrint(String tablePrint, int count , int trainNumber, String trainName , String source, String destination, Time sourceDeparture,
                                   Time destinationArrival,int sleeperAvailability, int seaterAvailability, int ac2Availability, int ac3Availability ) {

        tablePrint = tablePrint + "<tr>"+
                "<td>"+count +"</td>"+
                "<td>" + trainNumber+ "</td>"+
                "<td>"+trainName+"</td>"+
                "<td>"+source+"</td>"+
                "<td>"+destination+"</td>"+
                "<td>"+sourceDeparture+"</td>"+
                "<td>"+destinationArrival+"</td>"+
                "<td>"+sleeperAvailability+"</td>"+
                "<td>" +seaterAvailability+ "</td>"+
                "<td>"+ac2Availability+"</td>"+
                "<td>"+ac3Availability+"</td>"+
                "</tr>";

        return  tablePrint;
    }


    public String getdayOfWeek(String DOJ) {

        Calendar c = Calendar.getInstance();
        java.util.Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("dd-MM-yyyy").parse(DOJ);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        c.setTime(utilDate);
        int day = c.get(Calendar.DAY_OF_WEEK);
        String weekDay = null;
        switch(day)
        {
            case 1 : weekDay = "SUNDAY";break;
            case 2 : weekDay = "MONDAY";break;
            case 3 : weekDay = "TUESDAY";break;
            case 4 : weekDay = "WEDNESDAY";break;
            case 5 : weekDay = "THURSDAY";break;
            case 6 : weekDay = "FRIDAY";break;
            case 7 : weekDay = "SATURDAY";break;
        }
        return weekDay;

    }

    public Date getDate(String DOJ)
    {
        java.util.Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("dd-MM-yyyy").parse(DOJ);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        return sqlDate;


    }

   }



