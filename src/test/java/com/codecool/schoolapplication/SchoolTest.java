package com.codecool.schoolapplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SchoolTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testListSchools() throws Exception {
        mvc.perform(get("/school"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":3,\"name\":\"Arany Janos Gimnazium\",\"address\":\"Nagykoros, Hosok tere 6.\",\"divisions\":[]}")));
    }

    @Test
    public void testGetSchool() throws Exception {
        mvc.perform(get("/school/3"))
                .andExpect(status().isOk())
                .andExpect(content().string(is("{\"id\":3,\"name\":\"Arany Janos Gimnazium\",\"address\":\"Nagykoros, Hosok tere 6.\",\"divisions\":[]}")));
    }

    @Test
    public void testAddSchool() throws Exception {
        mvc.perform(get("/school"))
                .andExpect(status().isOk())
                .andExpect(content().string(not(containsString("\"name\":\"Petofi Sandor Gimnazium\",\"address\":\"Budapest I, Attila ut 43.\""))));
        mvc.perform(post("/school")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Petofi Sandor Gimnazium\",\"address\":\"Budapest I, Attila ut 43.\"}"))
                .andExpect(status().isOk());
        mvc.perform(get("/school"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Petofi Sandor Gimnazium\",\"address\":\"Budapest I, Attila ut 43.\"")));
    }

    @Test
    public void testUpdateSchool() throws Exception {
        mvc.perform(get("/school/3"))
                .andExpect(status().isOk())
                .andExpect(content().string(is("{\"id\":3,\"name\":\"Arany Janos Gimnazium\",\"address\":\"Nagykoros, Hosok tere 6.\",\"divisions\":[]}")));
        mvc.perform(put("/school/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Arany Janos Gimnazium, Technikum es Kollegium\"}"))
                .andExpect(status().isOk());
        mvc.perform(get("/school/3"))
                .andExpect(status().isOk())
                .andExpect(content().string(is("{\"id\":3,\"name\":\"Arany Janos Gimnazium, Technikum es Kollegium\",\"address\":\"Nagykoros, Hosok tere 6.\",\"divisions\":[]}")));
    }

    @Test
    public void testDeleteSchool() throws Exception {
        mvc.perform(get("/school"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Arany Janos Gimnazium\"")));
        mvc.perform(delete("/school/3"))
                .andExpect(status().isOk());
        mvc.perform(get("/school"))
                .andExpect(status().isOk())
                .andExpect(content().string(not(containsString("\"name\":\"Arany Janos Gimnazium\""))));
    }

    @Test
    public void testCountStudentsNumber() throws Exception {
        mvc.perform(get("/school/2/students"))
                .andExpect(status().isOk())
                .andExpect(content().string(is("70")));
    }

    @Test
    public void testCalculateGeneralSupport() throws Exception {
        mvc.perform(get("/school/2/support"))
                .andExpect(status().isOk())
                .andExpect(content().string(is("84000")));
    }
}
