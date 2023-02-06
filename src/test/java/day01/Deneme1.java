package day01;

import java.sql.SQLException;

public class Deneme1 extends TestBase2{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

     //   TestBase2.printMethod(sqlMethod("select * from ogrenciler where cinsiyet='E';"));
        TestBase2.printMethod(sqlMethod("select urun_isim,musteri_isim from nisan where exists(select urun_isim from mart where mart.urun_isim=nisan.urun_isim)"));

    }
}
