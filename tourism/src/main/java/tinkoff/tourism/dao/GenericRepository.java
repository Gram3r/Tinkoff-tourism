package tinkoff.tourism.dao;

import org.springframework.data.repository.NoRepositoryBean;
import tinkoff.tourism.model.Sight;
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
