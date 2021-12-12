package tinkoff.tourism.dao.sights;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Sight;

@Mapper
public interface SightRepository extends GenericRepository<Sight> {
}
