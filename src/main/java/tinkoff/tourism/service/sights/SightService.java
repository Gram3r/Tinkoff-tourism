package tinkoff.tourism.service.sights;


import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.sights.SightRepository;
import tinkoff.tourism.model.sights.Sight;

@Service
public class SightService extends AbstractSightService<Sight, SightRepository> {
    public SightService(SightRepository repository) {
        super(repository);
    }
}
