package tinkoff.tourism.service;

import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.StreetRepository;
import tinkoff.tourism.model.Street;

@Service
public class StreetService extends GenericService<Street, StreetRepository>  {
    public StreetService(StreetRepository repository) {
        super(repository);
    }
}
