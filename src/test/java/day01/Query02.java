package day01;

import java.sql.*;

public class Query02{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1- Driver Yukle

        Class.forName("com.mysql.jdbc.Driver");

        //2- Baglanti Olustur

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC","root","55lz203");
        //isciler: baglanti yapacagimiz database'in ismi

        //3-Statement: SQL kodlarimizi yazmak icin bir nesne olusturalim
        Statement st= con.createStatement();

        // soru1- ogrenciler tablosundaki erkek ogrencilerin bilgilerini getirin

        ResultSet veri=st.executeQuery("select * from ogrenciler where cinsiyet='E'");

        /*while(veri.next()){
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1),veri.getString(2),veri.getString(3),veri.getString(4));


        }*/

        //soru2- ogrenciler tablosundaki 9.sinif, kiz ogrenci bilgilerini getirin
        veri= st.executeQuery("select * from ogrenciler where sinif=9 and cinsiyet='K'");



        while(veri.next()){
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1),veri.getString(2),veri.getString(3),veri.getString(4));
        }

        //6-Kapatma
        con.close();
        st.close();
        veri.close();



    }
}
