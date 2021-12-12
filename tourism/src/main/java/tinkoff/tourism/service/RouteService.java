package tinkoff.tourism.service;

import org.springframework.stereotype.Service;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.dao.RouteRepository;
import tinkoff.tourism.model.sights.Sight;
import java.util.List;

@Service
public class RouteService {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public List<Sight> getRouteByCategories(RouteRequest request) {
        return repository.getRouteByCategories(request);
    }

    public List<Sight> getRouteByBudget(RouteRequest request) {
        return repository.getRouteByBudget(request);
    }

    public List<Sight> getRouteByTime(RouteRequest request) {
        return repository.getRouteByTime(request);
    }

    public List<Sight> getRoute(RouteRequest request) {
        return repository.getRoute(request);
    }
}
