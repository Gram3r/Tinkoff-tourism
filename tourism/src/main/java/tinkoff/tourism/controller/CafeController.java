package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Cafe;
import tinkoff.tourism.service.BarService;
import tinkoff.tourism.service.CafeService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/cafe")
public class CafeController extends AbstractController<Cafe, CafeService> {
    public CafeController(CafeService service) {
        super(service);
    }
}
