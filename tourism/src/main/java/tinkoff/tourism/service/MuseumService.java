package tinkoff.tourism.service;

import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.MuseumRepository;
import tinkoff.tourism.model.Museum;

@Service
public class MuseumService extends GenericService<Museum, MuseumRepository> {
    public MuseumService(MuseumRepository repository) {
        super(repository);
    }
}
