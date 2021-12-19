package tinkoff.tourism;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.dao.sights.CafeRepository;
import tinkoff.tourism.dao.sights.MuseumRepository;
import tinkoff.tourism.dao.sights.SightRepository;
import tinkoff.tourism.model.sights.Cafe;
import tinkoff.tourism.model.sights.Museum;
import tinkoff.tourism.model.sights.Sight;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RouteTest extends AbstractTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SightRepository sightRepository;
    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    private MuseumRepository museumRepository;
    @Autowired
    private MockMvc mockMvc;

    private Cafe cafe;
    private Museum museum;


    @BeforeAll
    public void startDb() {
        cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());

        museum = createMuseum("Hermitage");
        museumRepository.addSight(museum);
        museum.setId(museumRepository.findByName(museum.getName()).get(0).getId());
    }

    @AfterAll
    public void resetDb() {
        sightRepository.deleteAll();
    }

    @Test
    public void getRouteCafeSuccess() throws Exception {
        RouteRequest request = createRequest(List.of("cafe"), "09:00", 1000);

        mockMvc.perform(
                        get("/route")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(proxySight(cafe)))));
    }

    @Test
    public void getRouteBothSuccess() throws Exception {
        RouteRequest request = createRequest(List.of("cafe", "museum"), "09:00", 1000);

        mockMvc.perform(
                        get("/route")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(proxySight(cafe), proxySight(museum)))));
    }

    @Test
    public void getRouteBudgetSuccess() throws Exception {
        RouteRequest request = createRequest(List.of("cafe", "museum"), "09:00", 100);

        mockMvc.perform(
                        get("/route")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(proxySight(cafe)))));
    }

    @Test
    public void getRouteTimeSuccess() throws Exception {
        RouteRequest request = createRequest(List.of("cafe", "museum"), "12:00", 1000);

        mockMvc.perform(
                        get("/route")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(proxySight(museum)))));
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
                .openTime("10:00")
                .closeTime("11:00")
                .price(100)
                .foodType("asian")
                .build();
    }

    private Museum createMuseum(String name) {
        return Museum.builder()
                .id(1L)
                .name(name)
                .type("museum")
                .coordinateX(5.6)
                .coordinateY(10.8)
                .description("Nice Museum")
                .siteLink("https://www.baeldung.com")
                .openTime("10:00")
                .closeTime("13:00")
                .price(150)
                .discountForChildren(true)
                .build();
    }

    private Sight proxySight(Sight sight){
        return Sight.builder()
                .id(sight.getId())
                .name(sight.getName())
                .type(sight.getType())
                .coordinateX(sight.getCoordinateX())
                .coordinateY(sight.getCoordinateY())
                .description(sight.getDescription())
                .siteLink(sight.getSiteLink())
                .openTime(sight.getOpenTime())
                .closeTime(sight.getCloseTime())
                .price(sight.getPrice())
                .build();
    }

    private RouteRequest createRequest(List<String> categories, String startTime, Integer budget){
        return RouteRequest.builder()
                .categories(categories)
                .startTime(startTime)
                .endTime("23:00")
                .budget(budget)
                .build();
    }
}