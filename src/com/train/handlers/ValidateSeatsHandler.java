package com.train.handlers;

import com.train.servlets.LogInServlet;
import com.train.servlets.JourneyDetails;

import java.util.HashMap;
import java.util.Map;

public class ValidateSeatsHandler {

  public int  getAvailableSeats(int trainNumber,String coachClass)
  {

      HashMap<Integer, JourneyDetails> trains =(HashMap<Integer, JourneyDetails>) LogInServlet.session.getAttribute("trainNumbers");
      int available=0;

      for(Map.Entry hm : trains.entrySet())
      {

         if((int)hm.getKey()==trainNumber)
          {

              JourneyDetails journeyDetails = (JourneyDetails)hm.getValue();
             switch (coachClass)
              {
                  case "sleeper" : available = journeyDetails.sleeperAvailability;break;
                  case "seater"  : available =  journeyDetails.seaterAvailability;break;
                  case "2ac"     : available = journeyDetails.ac2Availability;break;
                  case "3ac"     : available = journeyDetails.ac3Availability;break;

              }
              break;

          }
      }



      return available;

  }


}
