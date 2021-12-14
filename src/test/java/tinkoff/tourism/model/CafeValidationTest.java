package tinkoff.tourism.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import tinkoff.tourism.AbstractTest;
import tinkoff.tourism.dao.sights.CafeRepository;
import tinkoff.tourism.dao.sights.SightRepository;
import tinkoff.tourism.model.sights.Cafe;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
public class CafeValidationTest extends AbstractTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SightRepository sightRepository;
    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    private MockMvc mockMvc;


    @AfterEach
    public void resetDb() {
        sightRepository.deleteAll();
    }

    @Test
    public void addCafeSuccess() throws Exception {
        Cafe cafe = createCafe("cafe", "https://www.baeldung.com", "10:30", 100);
        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                )
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void addCafeBadTypeSuccess() throws Exception {
        Cafe cafe = createCafe("cafe2", "https://www.baeldung.com", "10:30", 100);
        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                )
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void addCafeBadTimeNotSuccess() throws Exception {
        Cafe cafe = createCafe("cafe", "https://www.baeldung.com", "130:30", 100);
        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                )
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void addCafeBadLinkNotSuccess() throws Exception {
        Cafe cafe = createCafe("cafe", "Hello world", "10:30", 100);
        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                )
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void addCafeBadPriceNotSuccess() throws Exception {
        Cafe cafe = createCafe("cafe", "https://www.baeldung.com", "10:30", -100);
        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                )
                .andExpect(status().is4xxClientError());
    }

    private Cafe createCafe(String type, String siteLink, String openTime, Integer price) {
        return Cafe.builder()
                .id(1L)
                .name("Stolovaya №1")
                .type(type)
                .xCoordinate(5.6)
                .yCoordinate(10.8)
                .description("Nice cafe")
                .siteLink(siteLink)
                .openTime(openTime)
                .closeTime("12:30")
                .price(price)
                .foodType("asian")
                .build();
    }
}