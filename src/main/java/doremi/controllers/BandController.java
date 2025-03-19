package doremi.controllers;

import doremi.domain.Band;
import doremi.services.BandAlbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
public class BandController {

    @Autowired
    private BandAlbumService bandAlbumService;

    @GetMapping("/bands")
    public String list(Model model) {
        model.addAttribute("bands", bandAlbumService.findAllBand());
        return "bands";
    }

    @GetMapping("/band/{id}")
    public String show(@PathVariable Long id, Model model) {
        Band band = bandAlbumService.findBandById(id);
        if (band == null) {
            return "error";
        }
        model.addAttribute("band", band);
        return "bandShow";
    }

    @GetMapping("/band/new")
    public String showForm(Band band) {
        return "bandForm";
    }

    @PostMapping("/band")
    public String saveBand(@Valid Band band, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bandForm";
        }
        Band savedBand = bandAlbumService.save(band);
        return "redirect:/band/" + savedBand.getId();
    }

}