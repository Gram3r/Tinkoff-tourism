package tinkoff.tourism.dao.sights;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Cafe;

@Mapper
public interface CafeRepository extends GenericRepository<Cafe> {
}
