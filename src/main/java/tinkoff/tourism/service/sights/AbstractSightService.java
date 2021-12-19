package tinkoff.tourism.service.sights;

import tinkoff.tourism.dao.sights.GenericRepository;
import tinkoff.tourism.model.sights.Sight;
import java.util.List;

public abstract class AbstractSightService<T extends Sight, R extends GenericRepository<T>> implements GenericSightService<T> {
    protected final R repository;

    public AbstractSightService(R repository) {
        this.repository = repository;
    }

    @Override
    public void addSight(T sight) {
        repository.addSight(sight);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void updateSight(T sight) {
        repository.updateSight(sight);
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<T> findByDistance(Double x, Double y, Double distance) {
        return repository.findByDistance(x, y, distance);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
