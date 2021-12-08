package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.Street;

@Mapper
public interface StreetRepository extends GenericRepository<Street>  {
}
