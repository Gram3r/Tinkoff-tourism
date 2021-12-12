package tinkoff.tourism.dao.sights;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Street;

@Mapper
public interface StreetRepository extends GenericRepository<Street>  {
}
