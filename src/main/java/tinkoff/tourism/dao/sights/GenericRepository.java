package tinkoff.tourism.dao.sights;

import org.springframework.data.repository.NoRepositoryBean;
import tinkoff.tourism.model.sights.Sight;
import java.util.List;

@NoRepositoryBean
public interface GenericRepository<T extends Sight> {

    void addSight(T sight);

    List<T> findAll();

    T findById(Long id);

    void updateSight(T sight);

    void delete(Long id);

    void deleteAll();
}
