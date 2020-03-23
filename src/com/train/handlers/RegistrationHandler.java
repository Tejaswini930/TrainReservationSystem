package com.train.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationHandler {

    private Connection connection=DataBaseHandler.getConnection();
    int status=0;
    public  boolean insert(String email,String name,String user_id,String password,long phone,String gender,String security_question,String security_answer)
    {

        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("insert into Users(EMAIL_ID,FULL_NAME,USER_ID,PASSWORD,PHONE_NUMBER,GENDER,SECURITY_QUESTION,SECURITY_ANSWER,USER_TYPE) values (?,?,?,?,?,?,?,?,?)");
            pst.setString(1,email);
            pst.setString(2,name);
            pst.setString(3,user_id);
            pst.setString(4,password);
            pst.setLong(5,phone);
            pst.setString(6,gender);
            pst.setString(7,security_question);
            pst.setString(8,security_answer);
            pst.setString(9,"OrdinaryUser");
            status = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status==1? true:false;



    }
}
