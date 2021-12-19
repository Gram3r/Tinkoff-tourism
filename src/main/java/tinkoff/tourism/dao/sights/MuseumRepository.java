package tinkoff.tourism.dao.sights;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Cafe;
import tinkoff.tourism.model.sights.Museum;

import java.util.List;

@Mapper
public interface MuseumRepository extends GenericRepository<Museum>  {
    List<Museum> findByDiscountForChildren(Boolean discountForChildren);
}
