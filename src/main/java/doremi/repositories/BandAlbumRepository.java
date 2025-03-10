package doremi.repositories;

import doremi.domain.Album;
import doremi.domain.Band;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.ConstraintViolationException;
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

    public Band save(Band band) throws IllegalArgumentException {
        if (band == null) {
            throw new IllegalArgumentException("Band cannot be null");
        }
        this.entityManager.merge(band);
        return band;
    }

    public Album save(Album album) {
        if (album == null) {
            throw new IllegalArgumentException("Album cannot be null");
        }
        if (album.getBand() == null) {
            throw new IllegalArgumentException("Album must be associated with a band");
        }
        Band managedBand = entityManager.merge(album.getBand());
        if (!managedBand.getAlbums().contains(album)) {
            managedBand.addAlbum(album);
        }
        if (album.getId() == null) {
            entityManager.persist(album);
            return album;
        } else {
            return entityManager.merge(album);
        }
    }
}
