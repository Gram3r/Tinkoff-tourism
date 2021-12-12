package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.model.sights.Sight;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RouteRepository {

    List<Sight> getRouteByCategories(RouteRequest categories);

    List<Sight> getRouteByBudget(RouteRequest budget);

    List<Sight> getRouteByTime(RouteRequest time);

    List<Sight> getRoute(RouteRequest request);
}
