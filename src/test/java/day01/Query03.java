package day01;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        //1- Driver Yukle

        Class.forName("com.mysql.jdbc.Driver");

        //2- Baglanti Olustur

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC","root","55lz203");
        //isciler: baglanti yapacagimiz database'in ismi

        //3-Statement: SQL kodlarimizi yazmak icin bir nesne olusturalim
        Statement st= con.createStatement();


        ResultSet veri4=st.executeQuery("select marka_isim,calisan_sayisi, (select sum(maas) from personel where marka_isim=isyeri)as toplam_maas from markalar");



       /* while(veri4.next()){
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri4.getInt(1),veri4.getString(2));
        }*/




        while(veri4.next()){
            //======= SUTUN INDEXI YADA ISMI KULLANARAK ATAMA YAPABILIRIZ========


            System.out.println(veri4.getString(1) + " " + veri4.getString(2)+" "+veri4.getString(3));
        }

        con.close();
        st.close();
        veri4.close();



    }
}
