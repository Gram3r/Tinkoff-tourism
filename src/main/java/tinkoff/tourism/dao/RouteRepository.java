package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.model.sights.Sight;
import java.util.List;

@Mapper
public interface RouteRepository {

    List<Sight> getRoute(RouteRequest request);
}
