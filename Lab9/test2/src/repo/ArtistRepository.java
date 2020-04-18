package repo;


import Entity.AlbumEntity;
import Entity.ArtistEntity;
import Util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ArtistRepository {
    PersistenceUtil pu;

    public ArtistRepository(PersistenceUtil pu) {
        this.pu = pu;
    }

    public void create(ArtistEntity artist)
    {
        EntityManager entityManager = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public ArtistEntity findbyId(int IdCautat) {
        EntityManager entityManager = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        ArtistEntity artistDeCautat = entityManager.find(ArtistEntity.class, IdCautat);
        entityManager.detach(artistDeCautat);
        entityManager.close();
        return artistDeCautat;
    }

    public List<ArtistEntity> findByName(String numeCautat) {
        EntityManager entityManager = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        List<ArtistEntity> artistsDeCautat=entityManager.createNamedQuery("Artistnames")
                .setParameter("name", numeCautat)
                .getResultList();
        entityManager.close();
        return artistsDeCautat;
    }

}
