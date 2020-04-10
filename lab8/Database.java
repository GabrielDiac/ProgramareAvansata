import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database{
    private Connection con;
    private int idArtistNR=4;
    private int idAlbumNR=3;
    private static Database instance;
    public Database() {
        try
        {
            this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String query = String.format("select MAX(ID) from  Artist");
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if ( res.next() ){
                idArtistNR=res.getInt(1);
            }
            idArtistNR++;
            //System.out.println(idAlbumNR);

        } catch (SQLException e) {
            System.out.println("NU a mers");
        }
        try {
            String query = String.format("select MAX(ID) from  Album");
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if ( res.next() ){
                idAlbumNR=res.getInt(1);
            }
            idAlbumNR++;
            //System.out.println(idAlbumNR);

        } catch (SQLException e) {
            System.out.println("NU a mers");
        }
    }

    public void insertArtist(String nameArtist,String countryArtist)
    {
        try {
            String query = String.format("insert into Artist values('%d','%s', '%s')", idArtistNR,nameArtist, countryArtist);
            Statement stmt = con.createStatement();
            stmt.executeQuery(query);
            idArtistNR++;
        } catch (SQLException e) {
            System.out.println("NU a mers");
        }
    }
    public void insertAlbum(String nameAlbum,int idArtist,int yearAlbum)
    {
        try {
            String query = String.format("insert into Album values('%d','%s','%d','%d')", idAlbumNR,nameAlbum,idArtist, yearAlbum);
            Statement stmt = con.createStatement();
            stmt.executeQuery(query);
            idAlbumNR++;
        } catch (SQLException e) {
            System.out.println("NU a mers");
        }
    }

    public Connection getCon() {
        return con;
    }

    public static Database getInstance() throws SQLException {
            if (instance == null || instance.getCon().isClosed()) {
                instance = new Database();
            }
        return instance;
    }
    void findName(String nameArtist) throws SQLException {
        String query = String.format("select * from  Artist  where NAME LIKE '%s'", nameArtist);
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            System.out.println(res.getInt(1) + ", " + res.getString(2)+ ", " +  res.getString(3));
        }
        }
    void findArtist(int idArtist) throws SQLException {
        String query = String.format("select * from  Album  where Artist_id LIKE '%d'", idArtist);
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            System.out.println(res.getInt(1) + ", " + res.getString(2)+ ", " +  res.getInt(3)+", "+res.getInt(4));
        }
    }
}