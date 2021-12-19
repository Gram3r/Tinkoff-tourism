package tinkoff.tourism.dao.sights;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Bar;
import tinkoff.tourism.model.sights.Cafe;

import java.util.List;

@Mapper
public interface CafeRepository extends GenericRepository<Cafe> {
    List<Cafe> findByTypeOfFood(String foodType);
}
