package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Cafe;
import tinkoff.tourism.model.Sight;

import java.util.List;

@Mapper
@Repository
public interface CafeRepository extends GenericRepository<Cafe> {
}
