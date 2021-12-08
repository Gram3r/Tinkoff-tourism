package tinkoff.tourism.service;

import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.BarRepository;
import tinkoff.tourism.model.Bar;

@Service
public class BarService extends GenericService<Bar, BarRepository>  {
    public BarService(BarRepository repository) {
        super(repository);
    }
}
