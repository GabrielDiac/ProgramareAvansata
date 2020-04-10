import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;


public class Main {

    public static void main(String[] args){
        try{

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Database database=Database.getInstance();
            Artist artist1=new Artist(database);
            Album album1=new Album(database);
            artist1.create("Weeknd","US");
            album1.create("ALbumNUme",1,1999);
            artist1.findByName("Weeknd");
            album1.findByArtist(1);
        }
        catch(Exception e)
        { System.out.println(e);
        }

    }


    }

