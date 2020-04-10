import java.sql.SQLException;

public class Album {
    private Database database;
    private String nameAlbum;
    private int yearAlbum;
    private int idArtist;


    public Album(Database database) {
        this.database = database;
    }

    public void create(String nameAlbum, int idArtist,int yearAlbum)
    {
        database.insertAlbum(nameAlbum,idArtist,yearAlbum);
    }
    public void findByArtist(int idArtist) throws SQLException {
        database.findArtist(idArtist);
    }
}
