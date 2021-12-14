package tinkoff.tourism;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tinkoff.tourism.dao.sights.CafeRepository;
import tinkoff.tourism.dao.sights.SightRepository;
import tinkoff.tourism.model.sights.Cafe;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorizationTest extends AbstractTest {
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
    public void addCafeNotAuthorizedNotSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                                .with(httpBasic("user2", "user2"))
                )
                .andExpect(status().isUnauthorized());
        assertNull(cafeRepository.findById(cafe.getId()));
    }

    @Test
    public void getCafeNotAuthorizedNotSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        mockMvc.perform(
                        get("/cafe")
                                .param("id", cafe.getId().toString())
                                .with(httpBasic("user2", "user2"))
                )
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void addCafeUserNotSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                                .with(httpBasic("user", "user"))
                )
                .andExpect(status().isForbidden());
    }

    @Test
    public void getCafeUserSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).getId());

        mockMvc.perform(
                        get("/cafe")
                                .param("id", cafe.getId().toString())
                                .with(httpBasic("user", "user"))
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(objectMapper.writeValueAsString(cafe)));
    }

    @Test
    public void addCafeAdminSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");

        mockMvc.perform(
                        post("/cafe")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(cafe))
                                .with(httpBasic("admin", "admin"))
                )
                .andExpect(status().is2xxSuccessful());

        cafe.setId(cafeRepository.findByName(cafe.getName()).getId());
        assertEquals(cafe, cafeRepository.findById(cafe.getId()));
    }

    @Test
    public void getCafeAdminSuccess() throws Exception {
        Cafe cafe = createCafe("Stolovaya 1");
        cafeRepository.addSight(cafe);
        cafe.setId(cafeRepository.findByName(cafe.getName()).getId());

        mockMvc.perform(
                        get("/cafe")
                                .param("id", cafe.getId().toString())
                                .with(httpBasic("admin", "admin"))
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(objectMapper.writeValueAsString(cafe)));
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