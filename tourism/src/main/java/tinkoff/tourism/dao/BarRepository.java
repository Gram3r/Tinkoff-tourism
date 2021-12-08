package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.Bar;

@Mapper
public interface BarRepository  extends GenericRepository<Bar> {
}
