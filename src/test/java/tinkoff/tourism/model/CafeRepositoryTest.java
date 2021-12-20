package tinkoff.tourism.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import tinkoff.tourism.AbstractTest;
import tinkoff.tourism.dao.sights.CafeRepository;
import tinkoff.tourism.dao.sights.SightRepository;
import tinkoff.tourism.model.sights.Cafe;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
public class CafeRepositoryTest extends AbstractTest {

    @Autowired
    private SightRepository sightRepository;
    @Autowired
    private CafeRepository cafeRepository;

    @AfterEach
    public void resetDb() {
        sightRepository.deleteAll();
    }

    @Test
    public void addCafeSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());

        assertEquals(cafe, cafeRepository.findById(cafe.getId()));
    }


    @Test
    public void getCafeSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());

        assertEquals(cafe, cafeRepository.findById(cafe.getId()));
        assertEquals(cafe, cafeRepository.findByName(cafe.getName()).get(0));
    }

    @Test
    public void getCafeNotSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");

        assertNull(cafeRepository.findById(cafe.getId()));
        assertEquals(List.of(), cafeRepository.findByName(cafe.getName()));
    }

    @Test
    public void updateCafeSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());
        Cafe cafe2 = createCafe("Stolovaya 2");
        cafe2.setId(cafe.getId());

        cafeRepository.updateSight(cafe2);

        assertNotEquals(cafe, cafeRepository.findById(cafe2.getId()));
        assertEquals(cafe2, cafeRepository.findById(cafe2.getId()));
    }

    @Test
    public void DeleteCafeSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());

        assertEquals(cafe, cafeRepository.findById(cafe.getId()));

        cafeRepository.delete(cafe.getId());
        assertNull(cafeRepository.findById(cafe.getId()));
    }

    private Cafe createCafe(String name) {
        return Cafe.builder()
                .id(1L)
                .name(name)
                .type("cafe")
                .coordinateX(5.6)
                .coordinateY(10.8)
                .description("Nice cafe")
                .siteLink("https://www.baeldung.com")
                .openTime("10:30")
                .closeTime("12:30")
                .price(100)
                .foodType("asian")
                .build();
    }
}