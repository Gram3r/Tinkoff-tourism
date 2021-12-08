package tinkoff.tourism.service;


import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.GenericRepository;
import tinkoff.tourism.dao.SightRepository;
import tinkoff.tourism.model.Cafe;
import tinkoff.tourism.model.Sight;

import java.util.List;

@Service
public class SightService extends GenericService<Sight, SightRepository>  {
    public SightService(SightRepository repository) {
        super(repository);
    }
}
