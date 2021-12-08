package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Museum;

import java.util.List;

@Mapper
public interface MuseumRepository {

    void addMuseum(Museum museum);

    List<Museum> findAll();

    Museum findById(Long id);

    void updateMuseum(Museum museum);

    void delete(Long id);

    void deleteAll();
}
