package tinkoff.tourism.service.sights;

import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.sights.CafeRepository;
import tinkoff.tourism.model.sights.Cafe;

@Service
public class CafeService extends AbstractSightService<Cafe, CafeRepository> {
    public CafeService(CafeRepository repository) {
        super(repository);
    }
}
