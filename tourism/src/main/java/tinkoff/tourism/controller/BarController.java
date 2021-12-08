package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Cafe;
import tinkoff.tourism.model.Sight;
import tinkoff.tourism.service.BarService;
import tinkoff.tourism.service.CafeService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/bar")
public class BarController extends AbstractController<Bar, BarService> {
    public BarController(BarService service) {
        super(service);
    }
}
