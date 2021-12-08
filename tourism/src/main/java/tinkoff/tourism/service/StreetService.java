package tinkoff.tourism.service;


import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.BarRepository;
import tinkoff.tourism.dao.GenericRepository;
import tinkoff.tourism.dao.StreetRepository;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Cafe;
import tinkoff.tourism.model.Street;

import java.util.List;

@Service
public class StreetService extends GenericService<Street, StreetRepository>  {

    public StreetService(StreetRepository repository) {
        super(repository);
    }
}
