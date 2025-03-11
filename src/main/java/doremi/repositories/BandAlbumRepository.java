package doremi.repositories;

import doremi.domain.Album;
import doremi.domain.Band;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Transactional
    public Band save(Band band) throws IllegalArgumentException {
        if (band == null) {
            throw new IllegalArgumentException("Band cannot be null");
        }
        return this.entityManager.merge(band);
    }

    @Transactional
    public Album save(Album album) {
        if (album == null) {
            throw new IllegalArgumentException("Album cannot be null");
        }
        if (album.getBand() == null) {
            throw new IllegalArgumentException("Album must be associated with a band");
        }
        Band managedBand = save(album.getBand());
        album.setBand(managedBand);
        Album savedAlbum = this.entityManager.merge(album);
        if (!managedBand.getAlbums().contains(savedAlbum)) {
            managedBand.addAlbum(savedAlbum);
        }
        return savedAlbum;
    }

    public List<Band> findAllBand() {
        return this.entityManager.createQuery("select b from Band b ORDER BY b.name").getResultList();
    }
}
