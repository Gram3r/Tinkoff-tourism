package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Sight;

import java.util.List;

@Mapper
public interface BarRepository  extends GenericRepository<Bar> {
}
