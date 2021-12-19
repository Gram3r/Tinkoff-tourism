package tinkoff.tourism.service.sights;

import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.sights.MuseumRepository;
import tinkoff.tourism.model.sights.Cafe;
import tinkoff.tourism.model.sights.Museum;

import java.util.List;

@Service
public class MuseumService extends AbstractSightService<Museum, MuseumRepository> {
    public MuseumService(MuseumRepository repository) {
        super(repository);
    }

    public List<Museum> findByDiscountForChildren(Boolean discountForChildren) {
        return repository.findByDiscountForChildren(discountForChildren);
    }
}
