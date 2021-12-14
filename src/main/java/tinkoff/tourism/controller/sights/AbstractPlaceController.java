package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.sights.Sight;
import tinkoff.tourism.service.sights.GenericSightService;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class AbstractPlaceController<T extends Sight, S extends GenericSightService<T>> implements GenericPlaceController<T> {
    protected final S service;

    public AbstractPlaceController(S service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addSight(@RequestBody @Valid T sight) {
        service.addSight(sight);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public T getSight(@RequestParam("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<T> getSights() {
        return service.findAll();
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateSight(@RequestBody @Valid T sight) {
        service.updateSight(sight);
    }

    @DeleteMapping()
    public void deleteSight(@RequestParam("id") Long id) {
        service.delete(id);
    }

    @DeleteMapping(value = "all")
    public void deleteSights() {
        service.deleteAll();
    }
}
