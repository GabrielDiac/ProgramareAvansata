import java.sql.SQLException;

public class Artist {
    private Database database;
    private String nameArtist;
    private String countryArtist;

    public Artist(Database database) {
        this.database = database;
    }
    public void create(String nameArtist,String countryArtist)
    {
        database.insertArtist(nameArtist,countryArtist);
    }
    public void findByName(String nameArtist) throws SQLException {
        database.findName(nameArtist);
    }

}
