package tinkoff.tourism.service;


import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.BarRepository;
import tinkoff.tourism.dao.GenericRepository;
import tinkoff.tourism.dao.SightRepository;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Cafe;
import tinkoff.tourism.model.Sight;

import java.util.List;

@Service
public class BarService extends GenericService<Bar, BarRepository>  {
    public BarService(BarRepository repository) {
        super(repository);
    }
}
