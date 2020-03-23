package com.train.handlers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainAvailabilityHandler {


    private List<String> sources = new ArrayList<>();
    private List<String> destinations = new ArrayList<>();
    private Connection connection = DataBaseHandler.getConnection();
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public List getAllSource() {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select CURRENT_STOP  from BETWEEN_STOPPINGS");

            while (true) {
                if (!resultSet.next()) break;


                if (!sources.contains(resultSet.getString(1))) {
                    sources.add(resultSet.getString(1));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sources;
    }

    public List getAllDestination() {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select CURRENT_STOP, NEXT_STOP  from BETWEEN_STOPPINGS");

            while (resultSet.next()) {

                if (!destinations.contains(resultSet.getString(2))) {
                    destinations.add(resultSet.getString(2));
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return destinations;

    }

    public ResultSet  getTotalSeats(int train_numbers,String date_of_journey){
        String temp="";
        try {

            preparedStatement = connection.prepareStatement(
                    " select train_number,"+
                            " (select sum(no_of_passengers) from ticket"+
                            " group by train_number,coach_class"+
                            " having train_number = t.train_number AND coach_class='sleeper') as Sleeper,"+
                            " (select sum(no_of_passengers) from ticket"+
                            " group by train_number,coach_class"+
                            " having train_number = t.train_number AND coach_class='seater') as Seater,"+
                            " (select sum(no_of_passengers) from ticket"+
                            " group by train_number,coach_class"+
                            " having train_number = t.train_number AND coach_class='2ac') as AC2,"+
                            " (select sum(no_of_passengers) from ticket"+
                            " group by train_number,coach_class"+
                            " having train_number = t.train_number AND coach_class='3ac') as AC3"+
                            " from ticket as t where date_of_journey='"+date_of_journey+"' AND train_number="+train_numbers+
                            " group by train_number");
            resultSet= preparedStatement.executeQuery();
        } catch (SQLException e) {
            temp=e.getMessage().toString();
            e.printStackTrace();
        }
        return resultSet;
    }



    public ResultSet  getTrainNumbers(String journeySource,String journeyDestination,String dayOfWeek) {

        String temp = "";

        try {
            preparedStatement = connection.prepareStatement("SELECT C.train_name,C.train_number,"+
                    " (C.sleeper_coaches*C.sleeper_seats_per_coach)as Total_Sleeper,"+
                    " (C.seater_coaches*C.seater_seats_per_coach) as Total_Seater,"+
                    " (C.AC2_coaches*C.AC2_seats_per_coach)as Total_AC2,"+
                    " (C.AC3_coaches*C.AC3_seats_per_coach)as Total_AC3,"+
                    " A.CURRENT_STOP_DEPARTURE_TIME,B.NEXT_STOP_ARRIVAL_TIME FROM BETWEEN_STOPPINGS A"+
                    " INNER JOIN BETWEEN_STOPPINGS B"+
                    " ON (A.TRAIN_NUMBER = B.TRAIN_NUMBER AND A.CURRENT_STOP = ? AND B.NEXT_STOP = ?"+
                    " AND A.CURRENT_STOP_DEPARTURE_TIME < B.NEXT_STOP_ARRIVAL_TIME )"+
                    " AND (SELECT "+dayOfWeek+
                    " FROM TRAIN_FREQUENCY WHERE TRAIN_NUMBER = A.TRAIN_NUMBER)"+
                    " inner join train C on C.train_number = B.train_number  order by A.CURRENT_STOP_DEPARTURE_TIME;"
            );

            preparedStatement.setString(1,journeySource);
            preparedStatement.setString(2,journeyDestination);

            resultSet= preparedStatement.executeQuery();

        } catch (SQLException e) {

            temp = e.getMessage().toString();
            e.printStackTrace();
        }


        return resultSet;


    }




}