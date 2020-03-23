package com.train.modals;

import java.sql.Date;
import java.sql.Time;

public class Ticket {
    String PNR ;
    int TRAIN_NUMBER;
    String JOURNEY_SOURCE;
    String JOURNEY_DESTINATION;
    Date DATE_OF_JOURNEY;
    Time SOURCE_DEPARTURE_TIME ;
    Time DESTINATION_ARRIVAL_TIME;
    String PRIMARY_PASSENGER_NAME ;
    int NO_OF_PASSENGERS ;
    long PHONE_NUMBER ;
    Date DATE_OF_BOOKING;
    Date BOOKING_MODIFICATION_DATE;
    String BOARDING_POINT;
    String COACH_CLASS;
    String USER_ID;

    public String getPNR() {
        return PNR;
    }

    public void setPNR(String PNR) {
        this.PNR = PNR;
    }

    public int getTRAIN_NUMBER() {
        return TRAIN_NUMBER;
    }

    public void setTRAIN_NUMBER(int TRAIN_NUMBER) {
        this.TRAIN_NUMBER = TRAIN_NUMBER;
    }

    public String getJOURNEY_SOURCE() {
        return JOURNEY_SOURCE;
    }

    public void setJOURNEY_SOURCE(String JOURNEY_SOURCE) {
        this.JOURNEY_SOURCE = JOURNEY_SOURCE;
    }

    public String getJOURNEY_DESTINATION() {
        return JOURNEY_DESTINATION;
    }

    public void setJOURNEY_DESTINATION(String JOURNEY_DESTINATION) {
        this.JOURNEY_DESTINATION = JOURNEY_DESTINATION;
    }

    public Date getDATE_OF_JOURNEY() {
        return DATE_OF_JOURNEY;
    }

    public void setDATE_OF_JOURNEY(Date DATE_OF_JOURNEY) {
        this.DATE_OF_JOURNEY = DATE_OF_JOURNEY;
    }

    public Time getSOURCE_DEPARTURE_TIME() {
        return SOURCE_DEPARTURE_TIME;
    }

    public void setSOURCE_DEPARTURE_TIME(Time SOURCE_DEPARTURE_TIME) {
        this.SOURCE_DEPARTURE_TIME = SOURCE_DEPARTURE_TIME;
    }

    public Time getDESTINATION_ARRIVAL_TIME() {
        return DESTINATION_ARRIVAL_TIME;
    }

    public void setDESTINATION_ARRIVAL_TIME(Time DESTINATION_ARRIVAL_TIME) {
        this.DESTINATION_ARRIVAL_TIME = DESTINATION_ARRIVAL_TIME;
    }

    public String getPRIMARY_PASSENGER_NAME() {
        return PRIMARY_PASSENGER_NAME;
    }

    public void setPRIMARY_PASSENGER_NAME(String PRIMARY_PASSENGER_NAME) {
        this.PRIMARY_PASSENGER_NAME = PRIMARY_PASSENGER_NAME;
    }

    public int getNO_OF_PASSENGERS() {
        return NO_OF_PASSENGERS;
    }

    public void setNO_OF_PASSENGERS(int NO_OF_PASSENGERS) {
        this.NO_OF_PASSENGERS = NO_OF_PASSENGERS;
    }

    public long getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(long PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public Date getDATE_OF_BOOKING() {
        return DATE_OF_BOOKING;
    }

    public void setDATE_OF_BOOKING(Date DATE_OF_BOOKING) {
        this.DATE_OF_BOOKING = DATE_OF_BOOKING;
    }

    public Date getBOOKING_MODIFICATION_DATE() {
        return BOOKING_MODIFICATION_DATE;
    }

    public void setBOOKING_MODIFICATION_DATE(Date BOOKING_MODIFICATION_DATE) {
        this.BOOKING_MODIFICATION_DATE = BOOKING_MODIFICATION_DATE;
    }

    public String getBOARDING_POINT() {
        return BOARDING_POINT;
    }

    public void setBOARDING_POINT(String BOARDING_POINT) {
        this.BOARDING_POINT = BOARDING_POINT;
    }

    public String getCOACH_CLASS() {
        return COACH_CLASS;
    }

    public void setCOACH_CLASS(String COACH_CLASS) {
        this.COACH_CLASS = COACH_CLASS;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }
}
