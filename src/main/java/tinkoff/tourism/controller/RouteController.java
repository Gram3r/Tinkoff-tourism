package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.model.sights.Sight;
import tinkoff.tourism.service.RouteService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping(value = "/budget", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<Sight> getRouteByBudget(@RequestBody @Valid RouteRequest request) {
        return service.getRouteByBudget(request);
    }

    @GetMapping(value = "/categories", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<Sight> getRouteByCategories(@RequestBody @Valid RouteRequest request) {
        return service.getRouteByCategories(request);
    }

    @GetMapping(value = "/time", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<Sight> getRouteByTime(@RequestBody @Valid RouteRequest request) {
        return service.getRouteByTime(request);
    }

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<Sight> getRoute(@RequestBody @Valid RouteRequest request) {
        return service.getRoute(request);
    }
}
