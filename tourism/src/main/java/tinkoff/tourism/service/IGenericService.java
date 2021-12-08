package tinkoff.tourism.service;

import tinkoff.tourism.model.Sight;
import java.util.List;

public interface IGenericService<T extends Sight>{

    public void addSight(T sight);

    public void delete(Long id);

    public void deleteAll();

    public void updateSight(T sight);

    public T findById(Long id);

    public List<T> findAll();
}
