package day01;

import java.sql.*;

public class TestBase2 {
    public static ResultSet sqlMethod(String query) throws ClassNotFoundException, SQLException {
        //1- Driver Yukle
        Class.forName("com.mysql.jdbc.Driver");

        //2- Baglanti Olustur
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC","root","55lz203");
        //isciler: baglanti yapacagimiz database'in ismi

        //3-Statement: SQL kodlarimizi yazmak icin bir nesne olusturalim
        Statement st= con.createStatement();

        ResultSet veri = st.executeQuery(query);


        return veri;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            String query = "select * from ogrenciler";
            ResultSet veri = sqlMethod(query);
            // use the ResultSet here
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void printMethod(ResultSet veri) throws SQLException {
        while(veri.next()){
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1),veri.getString(2),veri.getString(3),veri.getString(4));
        }
    }



}
