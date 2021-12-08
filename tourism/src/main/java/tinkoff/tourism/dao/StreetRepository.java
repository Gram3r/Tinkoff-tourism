package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Sight;
import tinkoff.tourism.model.Street;

import java.util.List;

@Mapper
public interface StreetRepository extends GenericRepository<Street>  {
}
