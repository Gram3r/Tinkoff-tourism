package tinkoff.tourism.service;

import tinkoff.tourism.dao.GenericRepository;
import tinkoff.tourism.model.Sight;
import java.util.List;

public abstract class GenericService<T extends Sight, R extends GenericRepository<T>> implements IGenericService<T>{
    protected final R repository;

    public GenericService(R repository) {
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
    public List<T> findAll() {
        return repository.findAll();
    }
}
