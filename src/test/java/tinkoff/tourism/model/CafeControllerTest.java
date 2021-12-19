package tinkoff.tourism.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import tinkoff.tourism.AbstractTest;
import tinkoff.tourism.dao.sights.CafeRepository;
import tinkoff.tourism.dao.sights.SightRepository;
import tinkoff.tourism.model.sights.Cafe;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
public class CafeControllerTest extends AbstractTest {

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
        Cafe cafe = createCafe("Stolovaya 1");
        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                )
                .andExpect(status().is2xxSuccessful());

        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());
        assertEquals(cafe, cafeRepository.findById(cafe.getId()));
    }

    @Test
    public void addCafeNoSiteLinkSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                )
                .andExpect(status().is2xxSuccessful());

        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());
        assertEquals(cafe, cafeRepository.findById(cafe.getId()));
    }

    @Test
    public void getCafeSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());

        mockMvc.perform(
                        get("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("id", cafe.getId().toString())
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(objectMapper.writeValueAsString(cafe)));
    }

    @Test
    public void getCafeNotSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        mockMvc.perform(
                        get("/cafe")
                                .param("id", "1"))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void putCafeSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());

        Cafe cafe2 = createCafe("Stolovaya 2");
        cafe2.setId(cafe.getId());

        cafeRepository.addSight(cafe);

        mockMvc.perform(
                        put("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe2)))
                .andExpect(status().isOk());

        assertNotEquals(cafe, cafeRepository.findById(cafe2.getId()));
        assertEquals(cafe2, cafeRepository.findById(cafe2.getId()));
    }

    @Test
    public void deleteCafeSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).get(0).getId());

        mockMvc.perform(
                        delete("/cafe")
                                .param("id", cafe.getId().toString()))
                .andExpect(status().isOk());

        assertNull(cafeRepository.findById(cafe.getId()));
    }

    private Cafe createCafe(String name) {
        return Cafe.builder()
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