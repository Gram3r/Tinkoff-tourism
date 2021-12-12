package tinkoff.tourism.dao.sights;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Museum;

@Mapper
public interface MuseumRepository extends GenericRepository<Museum>  {
}
