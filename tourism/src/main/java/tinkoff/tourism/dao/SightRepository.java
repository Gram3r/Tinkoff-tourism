package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tinkoff.tourism.model.Sight;

import java.util.List;

@Mapper
public interface SightRepository extends GenericRepository<Sight> {
}
