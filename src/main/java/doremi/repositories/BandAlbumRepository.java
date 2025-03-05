package doremi.repositories;

import doremi.domain.Album;
import doremi.domain.Band;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BandAlbumRepository {

    @Autowired
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Album findAlbumById(Long id) {
        return this.entityManager.find(Album.class, id);
    }

    public Band findBandById(Long id) {
        return this.entityManager.find(Band.class, id);
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void save(Band band) throws IllegalArgumentException {
        if (band == null) {
            throw new IllegalArgumentException("Band not found");
        }
        this.entityManager.persist(band);
    }

    public void save(Album album) throws IllegalArgumentException {
        if (album == null) {
            throw new IllegalArgumentException("Album id cannot be null");
        }
        this.entityManager.persist(album);
    }
}
