package doremi;

import doremi.domain.Album;
import doremi.domain.Band;
import doremi.domain.Genre;
import doremi.services.BandAlbumService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final BandAlbumService bandAlbumService;

    public DataLoader(BandAlbumService bandAlbumService) {
        this.bandAlbumService = bandAlbumService;
    }

    private Band theStrokes;
    private Band joyDivision;
    private Band lanaDelRey;
    private Band pixies;
    private Band publicEnemy;

    private Album album1, album2, album3, album4, album5, album6, album7, album8, album9, album10, album11, album12;

    @PostConstruct
    public void loadData() {
        theStrokes = new Band("The Strokes", true);
        joyDivision = new Band("Joy Division", false);
        lanaDelRey = new Band("Lana Del Rey", true);
        pixies = new Band("Pixies", true);
        publicEnemy = new Band("Public Enemy", true);

        theStrokes = bandAlbumService.save(theStrokes);
        joyDivision = bandAlbumService.save(joyDivision);
        lanaDelRey = bandAlbumService.save(lanaDelRey);
        pixies = bandAlbumService.save(pixies);
        publicEnemy = bandAlbumService.save(publicEnemy);

        album1 = new Album("Is This It", Genre.INDIE, 2001);
        album2 = new Album("Room on Fire", Genre.INDIE, 2003);
        album3 = new Album("Unknown Pleasures", Genre.ROCK, 1979);
        album4 = new Album("Closer", Genre.ROCK, 1980);
        album5 = new Album("Born to Die", Genre.POP, 2012);
        album6 = new Album("Chemtrails over the Country Club", Genre.FOLK, 2021);
        album7 = new Album("Norman Fucking Rockwell", Genre.INDIE, 2019);
        album8 = new Album("Surfer Rosa", Genre.INDIE, 1988);
        album9 = new Album("Doolittle", Genre.INDIE, 1989);
        album10 = new Album("Beneath the Eyrie", Genre.INDIE, 2019);
        album11 = new Album("Bossanova", Genre.INDIE, 1990);
        album12 = new Album("It Takes a Nation of Millions to Hold Us Back", Genre.RAP, 1988);

        album1.setBand(theStrokes);
        album2.setBand(theStrokes);
        album3.setBand(joyDivision);
        album4.setBand(joyDivision);
        album5.setBand(lanaDelRey);
        album6.setBand(lanaDelRey);
        album7.setBand(lanaDelRey);
        album8.setBand(pixies);
        album9.setBand(pixies);
        album10.setBand(pixies);
        album11.setBand(pixies);
        album12.setBand(publicEnemy);

        album1 = bandAlbumService.save(album1);
        album2 = bandAlbumService.save(album2);
        album3 = bandAlbumService.save(album3);
        album4 = bandAlbumService.save(album4);
        album5 = bandAlbumService.save(album5);
        album6 = bandAlbumService.save(album6);
        album7 = bandAlbumService.save(album7);
        album8 = bandAlbumService.save(album8);
        album9 = bandAlbumService.save(album9);
        album10 = bandAlbumService.save(album10);
        album11 = bandAlbumService.save(album11);
        album12 = bandAlbumService.save(album12);

        System.out.println("Base de données initialisée avec des groupes et albums !");
    }

    public Band getTheStrokes() {
        return bandAlbumService.findBandById(theStrokes.getId());
    }

    public Band getJoyDivision() {
        return bandAlbumService.findBandById(joyDivision.getId());
    }

    public Band getLanaDelRey() {
        return bandAlbumService.findBandById(lanaDelRey.getId());
    }

    public Band getPixies() {
        return bandAlbumService.findBandById(pixies.getId());
    }

    public Band getPublicEnemy() {
        return bandAlbumService.findBandById(publicEnemy.getId());
    }

    public Album getAlbum1() {
        return bandAlbumService.findAlbumById(album1.getId());
    }

    public Album getAlbum2() {
        return bandAlbumService.findAlbumById(album2.getId());
    }

    public Album getAlbum3() {
        return bandAlbumService.findAlbumById(album3.getId());
    }

    public Album getAlbum4() {
        return bandAlbumService.findAlbumById(album4.getId());
    }

    public Album getAlbum5() {
        return bandAlbumService.findAlbumById(album5.getId());
    }

    public Album getAlbum6() {
        return bandAlbumService.findAlbumById(album6.getId());
    }

    public Album getAlbum7() {
        return bandAlbumService.findAlbumById(album7.getId());
    }

    public Album getAlbum8() {
        return bandAlbumService.findAlbumById(album8.getId());
    }

    public Album getAlbum9() {
        return bandAlbumService.findAlbumById(album9.getId());
    }

    public Album getAlbum10() {
        return bandAlbumService.findAlbumById(album10.getId());
    }

    public Album getAlbum11() {
        return bandAlbumService.findAlbumById(album11.getId());
    }

    public Album getAlbum12() {
        return bandAlbumService.findAlbumById(album12.getId());
    }
}
