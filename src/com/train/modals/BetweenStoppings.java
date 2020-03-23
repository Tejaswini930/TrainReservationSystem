package com.train.modals;

import java.sql.Time;

public class BetweenStoppings {
    int TRAIN_NUMBER;
    String CURRENT_STOP;
    String NEXT_STOP;
    Time CURRENTSTOP_DEPARTURE_TIME;
    Time NEXTSTOP_ARRIVAL_TIME;
    String DISTANCE_FROM_SOURCE;

    public int getTRAIN_NUMBER() {
        return TRAIN_NUMBER;
    }

    public void setTRAIN_NUMBER(int TRAIN_NUMBER) {
        this.TRAIN_NUMBER = TRAIN_NUMBER;
    }

    public String getCURRENT_STOP() {
        return CURRENT_STOP;
    }

    public void setCURRENT_STOP(String CURRENT_STOP) {
        this.CURRENT_STOP = CURRENT_STOP;
    }

    public String getNEXT_STOP() {
        return NEXT_STOP;
    }

    public void setNEXT_STOP(String NEXT_STOP) {
        this.NEXT_STOP = NEXT_STOP;
    }

    public Time getCURRENTSTOP_DEPARTURE_TIME() {
        return CURRENTSTOP_DEPARTURE_TIME;
    }

    public void setCURRENTSTOP_DEPARTURE_TIME(Time CURRENTSTOP_DEPARTURE_TIME) {
        this.CURRENTSTOP_DEPARTURE_TIME = CURRENTSTOP_DEPARTURE_TIME;
    }

    public Time getNEXTSTOP_ARRIVAL_TIME() {
        return NEXTSTOP_ARRIVAL_TIME;
    }

    public void setNEXTSTOP_ARRIVAL_TIME(Time NEXTSTOP_ARRIVAL_TIME) {
        this.NEXTSTOP_ARRIVAL_TIME = NEXTSTOP_ARRIVAL_TIME;
    }

    public String getDISTANCE_FROM_SOURCE() {
        return DISTANCE_FROM_SOURCE;
    }

    public void setDISTANCE_FROM_SOURCE(String DISTANCE_FROM_SOURCE) {
        this.DISTANCE_FROM_SOURCE = DISTANCE_FROM_SOURCE;
    }
}
