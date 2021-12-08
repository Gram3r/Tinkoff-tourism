package tinkoff.tourism.service;


import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.BarRepository;
import tinkoff.tourism.dao.CafeRepository;
import tinkoff.tourism.dao.GenericRepository;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Cafe;

import java.util.List;

@Service
public class CafeService extends GenericService<Cafe, CafeRepository> {
    public CafeService(CafeRepository repository) {
        super(repository);
    }
}
