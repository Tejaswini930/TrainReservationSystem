package com.train.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInAuthentication {

    private  static Connection connection=DataBaseHandler.getConnection();
    public static boolean validate (String user_name, String password)
    {

        PreparedStatement pst = null;
        try {

            pst = connection.prepareStatement("Select * from Users where user_id=? and password=?");
            pst.setString(1,user_name);
            pst.setString(2,password);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
}
