package helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;



/**
 * Created by vr1470 on 21-Jun-16.
 * Copyright Solnet SOlutions 2016
 */
public class Database {


private enum DB_Query {

    codeQuery,

    opted_game,

    opt_out,

    trasaction_ticket;
}




        private static String value;

       private static DB_Query query = DB_Query.valueOf(value);

    public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception {

        String dbUrl = "jdbc:mysql://10.2.71.187:3306/push2play_int3";

        String username = "resultrelay";

        String password = "resultrelay";

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(dbUrl,username,password);

        Statement stmt = con.createStatement();

        switch (query)
        {

            case codeQuery:
            {
                String codeQuery = "select code from push2play_int3.verification_code order by created  desc limit 1;;";
                ResultSet rs= stmt.executeQuery(codeQuery);
                WebDriverWait wait = new WebDriverWait(driver, 10);
                while (rs.next()){
                    String code  = rs.getString(1);
                    WebElement box = wait.until(ExpectedConditions.elementToBeClickable(By.id("Form_codeVerificationForm_Code_")));
                    box.sendKeys(code);
                    System. out.println(code);
                    break;
                }}

            case opted_game:
            {
                String opted_game = "select id,mobile_number, dip_type, favourite_name, status, wager_amount, send_reminder from push2play_int3.opted_game order by created desc limit 1;;";
                ResultSet rs= stmt.executeQuery(opted_game);

                while (rs.next()){
                    String id  = rs.getString(1);
                    String MobileNumber  = rs.getString(2);
                    String DipType  = rs.getString(3);
                    String Fav_name  = rs.getString(4);
                    String Status  = rs.getString(5);
                    String Wager_amount  = rs.getString(6);
                    String Send_reminder  = rs.getString(7);
                    System. out.println("ID: "+id
                            +"Mobile:  "+MobileNumber
                            +"DipType:  "+DipType
                            +"Fav Name: "+Fav_name
                            +"Status: "+Status
                            +"Wager_amount: "+Wager_amount
                            +"Send_reminder: "+Send_reminder);
                    break;
                }}


            case opt_out:
            {
                String opt_out =  "select id, status from push2play_int3.opted_game order by created desc limit 1;;";
                ResultSet rs= stmt.executeQuery(opt_out);

                while (rs.next()){
                    String id  = rs.getString(1);
                    String Status  = rs.getString(5);
                    System. out.println("ID: "+id
                            +"Status: "+Status);

                    break;
                }}




            //String trasaction_ticket = "select * from push2play_int3.transation LEFT JOIN push2play_int3.tickets on transation.id = tickets.transaction_id order by created desc limit 1;;";



        }

        con.close();
    }

}
