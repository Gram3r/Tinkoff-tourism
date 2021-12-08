package tinkoff.tourism.service;


import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.BarRepository;
import tinkoff.tourism.dao.MuseumRepository;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Museum;

import java.util.List;

@Service
public class MuseumService {
    private final MuseumRepository repository;

    public MuseumService(MuseumRepository repository) {
        this.repository = repository;
    }

    public void addMuseum(Museum museum) {
        repository.addMuseum(museum);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void updateMuseum(Museum museum) {
        repository.updateMuseum(museum);
    }

    public Museum findById(Long id) {
        return repository.findById(id);
    }

    public List<Museum> findAll() {
        return repository.findAll();
    }
}
