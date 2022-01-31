package metroanarchyserver.anarchy.handler;

import java.sql.*;

public class DatabaseHandler extends Config{
    Connection dbConn;
    public Connection getDbConn() throws ClassNotFoundException, SQLException {
        String connString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConn = DriverManager.getConnection(connString, dbUser, dbPass);
        return dbConn;
    }
    public ResultSet checkLoginUser (String nick) {
        ResultSet resSet = null;
        String select = "SELECT * FROM players WHERE nick=\""+nick+'\"';


        try {
            PreparedStatement prSt = getDbConn().prepareStatement(select);
            resSet = prSt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public void сode (String nick) {
        int a = 10000;
        int b = 99999;

        int code = a + (int) (Math.random() * b);
        String update = "UPDATE players SET ds_code=" + code + ", tg_code=" + code + ", vk_code=" + code + ", temp=" + code + " WHERE nick=\""+nick+'\"';


        try {
            PreparedStatement prSt = getDbConn().prepareStatement(update);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean checkCode (String nick, int code) {
        ResultSet resCode = null;

        String select = "SELECT temp FROM players WHERE nick=\""+nick+'\"';


        try {
            PreparedStatement prSt = getDbConn().prepareStatement(select);
            resCode = prSt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            resCode.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            int check_code = resCode.getInt("temp");
            if(check_code == code) {
                String update = "UPDATE players SET ds_code=" + null + ", tg_code=" + null + ", vk_code=" + null + ", temp=" + null + " WHERE nick=\""+nick+'\"';

                try {
                    PreparedStatement prSt = getDbConn().prepareStatement(update);
                    prSt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
