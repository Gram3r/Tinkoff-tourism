package tinkoff.tourism.service.sights;

import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.sights.BarRepository;
import tinkoff.tourism.model.sights.Bar;

@Service
public class BarService extends AbstractSightService<Bar, BarRepository> {
    public BarService(BarRepository repository) {
        super(repository);
    }
}
