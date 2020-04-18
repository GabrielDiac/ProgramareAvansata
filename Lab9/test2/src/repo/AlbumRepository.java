package repo;

import Entity.AlbumEntity;
import Util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AlbumRepository {
    PersistenceUtil pu;

    public AlbumRepository(PersistenceUtil pu) {
        this.pu = pu;
    }
    public void create(AlbumEntity album) {
        EntityManager entityManager = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public AlbumEntity findbyId(int IdCautat) {
        EntityManager entityManager = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        AlbumEntity albumDeCautat = entityManager.find(AlbumEntity.class, IdCautat);
        entityManager.detach(albumDeCautat);
        entityManager.close();
        return albumDeCautat;
    }

    public List<AlbumEntity> findByName(String numeCautat) {
        EntityManager entityManager = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        List<AlbumEntity> albumeDeCautat=entityManager.createNamedQuery("Albumnames")
                .setParameter("name", numeCautat)
                .getResultList();
        entityManager.close();
        return albumeDeCautat;
    }

    public List<AlbumEntity> findByArtist(int idArt) {
        EntityManager entityManager = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        List<AlbumEntity> albumeDeCautat=entityManager.createNamedQuery("AlbumnamesArtist")
                .setParameter("idart", idArt)
                .getResultList();
        entityManager.close();
        return albumeDeCautat;
    }

}

