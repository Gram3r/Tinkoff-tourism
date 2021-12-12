package tinkoff.tourism.service.sights;

import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.sights.StreetRepository;
import tinkoff.tourism.model.sights.Street;

@Service
public class StreetService extends AbstractSightService<Street, StreetRepository> {
    public StreetService(StreetRepository repository) {
        super(repository);
    }
}
