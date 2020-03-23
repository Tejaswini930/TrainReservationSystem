package com.train.servletutil;

import com.train.servlets.JourneyDetails;
import com.train.servlets.LogInServlet;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class PassengerInputUtil {

    public String generateInputTable(String tablePrint, int passengerCount)
    {

        String source = (String) LogInServlet.session.getAttribute("source");
        String destination = (String) LogInServlet.session.getAttribute("destination");
        String dateOfJourney = (String) LogInServlet.session.getAttribute("dateOfJourney");
        int trainNumber = (int) LogInServlet.session.getAttribute("trainNumber");
        String coachClass = (String)LogInServlet.session.getAttribute("coachClass");
        int serialno = 1;
        tablePrint = "<form action='InsertDetails' method='post' ><table cellpadding='5' align='center' border='1'>";
        tablePrint = tablePrint +
                "<tr>" +
                "          <th>" +
                "            Source" +
                "          </th>"+
                "          <td colspan='3'>" +source+"</td>"+
                "        </tr>"+
                "<tr>" +
                "          <th>" +
                "            Destination" +
                "          </th>"+
                "          <td colspan='3'>" +destination+"</td>"+
                "        </tr>"+

                "<tr>" +
                "          <th>" +
                "            Date Of Journey" +
                "          </th>"+
                "          <td colspan='3'>" +dateOfJourney+"</td>"+
                "        </tr>"+
                "<tr>" +
                "          <th>" +
                "            Train Number" +
                "          </th>"+
                "          <td colspan='3'>" +trainNumber+"</td>"+
                "        </tr>"+
                "<tr>" +
                "          <th>" +
                "            Coach Class" +
                "          </th>"+
                "          <td colspan='3'>" +coachClass+"</td>"+
                "        </tr>";


        tablePrint = tablePrint + "<tr> " +
                "<th> Passenger S.NO </th> " +
                "<th>Passenger Name</th> " +
                "<th>Age</th> " +
                "<th>Gender</th> " +
                "</tr>";
        while (serialno <= passengerCount) {
            tablePrint = tablePrint + "<tr> " +
                    "<td>"+serialno+"</td>"+
                    "<td><input type='text' required name='pname"+serialno+"'></td>"+
                    "<td><input type='number' required name='page"+serialno+"'></td>"+
                    "<td><input type='radio'  name='pgender"+serialno+"' value='male'>Male<input type='radio' value='female'name='pgender"+serialno+"'>Female </td>"+
                    "</tr>";
            serialno++;
        }
        tablePrint = tablePrint + "<tr> <td>Phone Number : </td><td colspan ='2'><input type='tel' required name='phoneNumber'></td> </tr>";
        tablePrint = tablePrint + "</table><br><input type='submit' value='BOOK'></form>";


        return  tablePrint;
    }

    public boolean validatePassenger(int trainNumber, int passengerCount, String coachClass){
        HashMap<Integer, JourneyDetails> hm = (HashMap) LogInServlet.session.getAttribute("trainNumbers");

        for(Map.Entry m : hm.entrySet()){
            if(trainNumber == (int)m.getKey()){
                JourneyDetails valObj= (JourneyDetails)m.getValue();
                LogInServlet.session.setAttribute("sourceTime",valObj.sourceDepartureTime);
                LogInServlet.session.setAttribute("departureTime",valObj.departureArrivalTime);
                switch (coachClass){
                    case "sleeper":
                        if(passengerCount<=valObj.sleeperAvailability)
                            return true;
                        break;
                    case "seater":
                        if(passengerCount<=valObj.seaterAvailability)
                            return true;
                        break;
                    case "2ac":
                        if(passengerCount<=valObj.ac2Availability)
                            return true;
                        break;
                    case "3ac":
                        if(passengerCount<=valObj.ac3Availability)
                            return true;
                        break;
                }
                return false;
            }
        }
        return false;
    }

}
