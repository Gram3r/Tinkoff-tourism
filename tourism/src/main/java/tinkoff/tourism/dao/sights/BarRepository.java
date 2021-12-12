package tinkoff.tourism.dao.sights;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Bar;

@Mapper
public interface BarRepository  extends GenericRepository<Bar> {
}
