package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Museum;
import tinkoff.tourism.service.BarService;
import tinkoff.tourism.service.MuseumService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/museum")
public class MuseumController {

    private final MuseumService service;

    public MuseumController(MuseumService service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addMuseum(@RequestBody @Valid Museum museum) {
        service.addMuseum(museum);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Museum getMuseum(@RequestParam("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<Museum> getMuseums() {
        return service.findAll();
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateMuseum(@RequestBody @Valid Museum museum) {
        service.updateMuseum(museum);
    }

    @DeleteMapping()
    public void deleteMuseum(@RequestParam("id") Long id) {
        service.delete(id);
    }

    @DeleteMapping(value = "all")
    public void deleteMuseums() {
        service.deleteAll();
    }

}
