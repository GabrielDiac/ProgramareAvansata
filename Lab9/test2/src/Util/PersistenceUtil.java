package Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class PersistenceUtil {

    public static EntityManagerFactory emf=null;
    public static PersistenceUtil instance=null;

    PersistenceUtil()
    {
        getEntityManagerFactory();
    }
    public static PersistenceUtil getInstance() throws SQLException {
        if (instance == null){
            instance = new PersistenceUtil();
        }

        return instance;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(
                    "MusicAlbumsPU");
        }
        return emf;
    }






}
