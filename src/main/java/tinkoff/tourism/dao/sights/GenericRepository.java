package tinkoff.tourism.dao.sights;

import org.springframework.data.repository.NoRepositoryBean;
import tinkoff.tourism.model.sights.Sight;
import java.util.List;

@NoRepositoryBean
public interface GenericRepository<T extends Sight> {

    void addSight(T sight);

    List<T> findAll();

    T findById(Long id);

    List<T> findByName(String name);

    List<T> findByDistance(Double x, Double y, Double distance);

    void updateSight(T sight);

    void delete(Long id);

    void deleteAll();
}
