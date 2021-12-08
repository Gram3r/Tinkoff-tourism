package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.Museum;

@Mapper
public interface MuseumRepository extends GenericRepository<Museum>  {
}
