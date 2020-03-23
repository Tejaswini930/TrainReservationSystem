package com.train.modals;

import java.sql.Time;

public class Train {

    int TRAIN_NUMBER ;
    String TRAIN_NAME;
    String TRAIN_TYPE;
    String SOURCE;
    String DESTINATION;
    Time SOURCE_DEPARTURE_TIME;
    Time DESTINATION_ARRIVAL_TIME;
    int NO_OF_COACHES;
    int SLEEPER_COACHES;
	int AC3_COACHES;
	int AC2_COACHES;
    int SEATER_COACHES;
    int SLEEPER_SEATS_PER_COACH;
	int AC3_SEATS_PER_COACH;
	int AC2_SEATS_PER_COACH;
    int SEATER_SEATS_PER_COACH;

    public int getTRAIN_NUMBER() {
        return TRAIN_NUMBER;
    }

    public void setTRAIN_NUMBER(int TRAIN_NUMBER) {
        this.TRAIN_NUMBER = TRAIN_NUMBER;
    }

    public String getTRAIN_NAME() {
        return TRAIN_NAME;
    }

    public void setTRAIN_NAME(String TRAIN_NAME) {
        this.TRAIN_NAME = TRAIN_NAME;
    }

    public String getTRAIN_TYPE() {
        return TRAIN_TYPE;
    }

    public void setTRAIN_TYPE(String TRAIN_TYPE) {
        this.TRAIN_TYPE = TRAIN_TYPE;
    }

    public String getSOURCE() {
        return SOURCE;
    }

    public void setSOURCE(String SOURCE) {
        this.SOURCE = SOURCE;
    }

    public String getDESTINATION() {
        return DESTINATION;
    }

    public void setDESTINATION(String DESTINATION) {
        this.DESTINATION = DESTINATION;
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

    public int getNO_OF_COACHES() {
        return NO_OF_COACHES;
    }

    public void setNO_OF_COACHES(int NO_OF_COACHES) {
        this.NO_OF_COACHES = NO_OF_COACHES;
    }

    public int getSLEEPER_COACHES() {
        return SLEEPER_COACHES;
    }

    public void setSLEEPER_COACHES(int SLEEPER_COACHES) {
        this.SLEEPER_COACHES = SLEEPER_COACHES;
    }

    public int getAC3_COACHES() {
        return AC3_COACHES;
    }

    public void setAC3_COACHES(int AC3_COACHES) {
        this.AC3_COACHES = AC3_COACHES;
    }

    public int getAC2_COACHES() {
        return AC2_COACHES;
    }

    public void setAC2_COACHES(int AC2_COACHES) {
        this.AC2_COACHES = AC2_COACHES;
    }

    public int getSEATER_COACHES() {
        return SEATER_COACHES;
    }

    public void setSEATER_COACHES(int SEATER_COACHES) {
        this.SEATER_COACHES = SEATER_COACHES;
    }

    public int getSLEEPER_SEATS_PER_COACH() {
        return SLEEPER_SEATS_PER_COACH;
    }

    public void setSLEEPER_SEATS_PER_COACH(int SLEEPER_SEATS_PER_COACH) {
        this.SLEEPER_SEATS_PER_COACH = SLEEPER_SEATS_PER_COACH;
    }

    public int getAC3_SEATS_PER_COACH() {
        return AC3_SEATS_PER_COACH;
    }

    public void setAC3_SEATS_PER_COACH(int AC3_SEATS_PER_COACH) {
        this.AC3_SEATS_PER_COACH = AC3_SEATS_PER_COACH;
    }

    public int getAC2_SEATS_PER_COACH() {
        return AC2_SEATS_PER_COACH;
    }

    public void setAC2_SEATS_PER_COACH(int AC2_SEATS_PER_COACH) {
        this.AC2_SEATS_PER_COACH = AC2_SEATS_PER_COACH;
    }

    public int getSEATER_SEATS_PER_COACH() {
        return SEATER_SEATS_PER_COACH;
    }

    public void setSEATER_SEATS_PER_COACH(int SEATER_SEATS_PER_COACH) {
        this.SEATER_SEATS_PER_COACH = SEATER_SEATS_PER_COACH;
    }
}
