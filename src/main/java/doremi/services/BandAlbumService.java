package doremi.services;

import doremi.domain.Album;
import doremi.domain.Band;
import doremi.repositories.BandAlbumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BandAlbumService {
    private BandAlbumRepository bandAlbumRepository;

    public BandAlbumService(BandAlbumRepository bandAlbumRepository) {
        this.bandAlbumRepository = bandAlbumRepository;
    }

    public BandAlbumRepository getBandAlbumRepository() {
        return this.bandAlbumRepository;
    }

    public Band save(Band band) throws IllegalArgumentException {
        if (band == null) {
            throw new IllegalArgumentException();
        }
        return this.bandAlbumRepository.save(band);
    }

    public Album save(Album album) throws IllegalArgumentException {
        if (album == null) {
            throw new IllegalArgumentException();
        }
        return this.bandAlbumRepository.save(album);
    }

    public Album findAlbumById(Long id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return this.bandAlbumRepository.findAlbumById(id);
    }

    public Band findBandById(Long id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return this.bandAlbumRepository.findBandById(id);
    }

    public List<Band> findAllBand() {
        return this.bandAlbumRepository.findAllBand();
    }
}
