package day01;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1- Driver Yukle

        Class.forName("com.mysql.jdbc.Driver");

        //2- Baglanti Olustur

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC","root","55lz203");
        //isciler: baglanti yapacagimiz database'in ismi

        //3-Statement: SQL kodlarimizi yazmak icin bir nesne olusturalim
        Statement st= con.createStatement();

        //4-ResultSet: SQL sorgularimizi yazacagiz
        ResultSet veri=st.executeQuery("select * from ogrenciler");

        //5-Sonuclari al
        while(veri.next()){
            //======= SUTUN INDEXI YADA ISMI KULLANARAK ATAMA YAPABILIRIZ========


         //   System.out.println(veri.getInt(1)+veri.getString(2)+veri.getString(3)+veri.getString(4));

            System.out.println(veri.getInt("okul_no")+veri.getString("ogrenci_ismi")+veri.getString("sinif")+veri.getString("cinsiyet"));

        }

        //6-Kapatma
        con.close();
        st.close();
        veri.close();







    }
}
