package tinkoff.tourism.dao.sights;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Bar;

import java.util.List;

@Mapper
public interface BarRepository  extends GenericRepository<Bar> {
    List<Bar> findByCocktailsForAdults(Boolean forAdults);
}
