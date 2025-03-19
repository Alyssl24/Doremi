package doremi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Band {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotEmpty
    private String name;
    private boolean active;

    @OneToMany(mappedBy = "band", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Album> albums = new ArrayList<Album>();

    public Band(String name, boolean active) {
        this.setName(name);
        this.setActive(active);
    }

    public Band() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {return this.id;}

    public List<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        if (!albums.contains(album)) {
            albums.add(album);
        }
        album.setBand(this);
    }

    public void removeAlbum(Album album) {
        this.albums.remove(album);
        album.setBand(null);
    }
}
