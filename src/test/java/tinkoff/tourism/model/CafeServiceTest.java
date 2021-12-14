package tinkoff.tourism.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import tinkoff.tourism.AbstractTest;
import tinkoff.tourism.dao.sights.CafeRepository;
import tinkoff.tourism.dao.sights.SightRepository;
import tinkoff.tourism.model.sights.Cafe;
import tinkoff.tourism.service.sights.CafeService;
import tinkoff.tourism.service.sights.SightService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CafeServiceTest extends AbstractTest {

    @Autowired
    private SightService sightService;
    @Autowired
    private CafeService cafeService;

    @AfterEach
    public void resetDb() {
        sightService.deleteAll();
    }

    @Test
    public void addCafeSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeService.addSight(cafe);
        cafe.setId(cafeService.findByName(cafe.getName()).getId());

        assertEquals(cafe, cafeService.findByName(cafe.getName()));
    }

    @Test
    public void getCafeSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeService.addSight(cafe);
        cafe.setId(cafeService.findByName(cafe.getName()).getId());

        assertEquals(cafe, cafeService.findById(cafe.getId()));
        assertEquals(cafe, cafeService.findByName(cafe.getName()));
    }

    @Test
    public void getCafeNotSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");

        assertNull(cafeService.findById(cafe.getId()));
        assertNull(cafeService.findByName(cafe.getName()));
    }

    @Test
    public void updateCafeSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeService.addSight(cafe);
        cafe.setId(cafeService.findByName(cafe.getName()).getId());
        Cafe cafe2 = createCafe("Stolovaya 1");
        cafe2.setId(cafe.getId());

        cafe2.setName("Stolovaya 2");

        cafeService.updateSight(cafe2);

        assertNotEquals(cafe, cafeService.findById(cafe2.getId()));
        assertEquals(cafe2, cafeService.findById(cafe2.getId()));
    }

    @Test
    public void DeleteCafeSuccess() {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeService.addSight(cafe);
        cafe.setId(cafeService.findByName(cafe.getName()).getId());

        assertEquals(cafe, cafeService.findById(cafe.getId()));

        cafeService.delete(cafe.getId());
        assertNull(cafeService.findById(cafe.getId()));
    }

    private Cafe createCafe(String name) {
        return Cafe.builder()
                .id(1L)
                .name(name)
                .type("cafe")
                .xCoordinate(5.6)
                .yCoordinate(10.8)
                .description("Nice cafe")
                .siteLink("https://www.baeldung.com")
                .openTime("10:30")
                .closeTime("12:30")
                .price(100)
                .foodType("asian")
                .build();
    }
}