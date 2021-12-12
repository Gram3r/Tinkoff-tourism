package tinkoff.tourism.service.sights;

import tinkoff.tourism.model.sights.Sight;
import java.util.List;

public interface GenericSightService<T extends Sight>{

    void addSight(T sight);

    void delete(Long id);

    void deleteAll();

    void updateSight(T sight);

    T findById(Long id);

    List<T> findAll();
}
