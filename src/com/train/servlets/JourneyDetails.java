package com.train.servlets;

import java.sql.Time;

public class JourneyDetails {


    public String trainName;
    public int trainNumber;
    public String source;
    public String destination;
    public Time sourceDepartureTime;
    public Time departureArrivalTime;
    public int sleeperAvailability;
    public int seaterAvailability;
    public int ac3Availability;
    public int ac2Availability;

    JourneyDetails(int trainNumber, String trainName, String source, String destination, Time sourceDepartureTime, Time departureArrivalTime,
                   int sleeperAvailability, int seaterAvailability, int ac3Availability, int ac2Availability)
    {

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.sourceDepartureTime = sourceDepartureTime;
        this.departureArrivalTime = departureArrivalTime;
        this.sleeperAvailability = sleeperAvailability;
        this.seaterAvailability = seaterAvailability;
        this.ac3Availability = ac3Availability;
        this.ac2Availability = ac2Availability;
    }



}
