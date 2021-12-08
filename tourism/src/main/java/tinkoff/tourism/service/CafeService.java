package tinkoff.tourism.service;

import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.CafeRepository;
import tinkoff.tourism.model.Cafe;

@Service
public class CafeService extends GenericService<Cafe, CafeRepository> {
    public CafeService(CafeRepository repository) {
        super(repository);
    }
}
