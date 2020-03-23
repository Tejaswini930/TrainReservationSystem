package com.train.modals;

public class Passenger {

    String PNR;
    int TRAIN_NUMBER;
    int SEAT_NO;
    boolean STATUS;
    int AGE;
    String GENDER;
    String PASSENGER_NAME;

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

    public int getSEAT_NO() {
        return SEAT_NO;
    }

    public void setSEAT_NO(int SEAT_NO) {
        this.SEAT_NO = SEAT_NO;
    }

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getPASSENGER_NAME() {
        return PASSENGER_NAME;
    }

    public void setPASSENGER_NAME(String PASSENGER_NAME) {
        this.PASSENGER_NAME = PASSENGER_NAME;
    }
}
