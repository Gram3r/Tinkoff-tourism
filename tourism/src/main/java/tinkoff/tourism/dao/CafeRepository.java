package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.Cafe;

@Mapper
public interface CafeRepository extends GenericRepository<Cafe> {
}
