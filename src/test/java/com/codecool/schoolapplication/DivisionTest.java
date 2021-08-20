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
public class DivisionTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testListDivisions() throws Exception {
        mvc.perform(get("/division"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"1.b\",\"classMaster\":\"Kovacs Maria\",\"startupYear\":2020,\"numberOfMembers\":26,\"schoolId\":2}")));
    }

    @Test
    public void testGetDivision() throws Exception {
        mvc.perform(get("/division/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(is("{\"id\":1,\"name\":\"1.b\",\"classMaster\":\"Kovacs Maria\",\"startupYear\":2020,\"numberOfMembers\":26,\"schoolId\":2}")));
    }

    @Test
    public void testAddDivision() throws Exception {
        mvc.perform(get("/division"))
                .andExpect(status().isOk())
                .andExpect(content().string(not(containsString("\"name\":\"3.c\",\"classMaster\":\"Szabo Balazs\",\"startupYear\":2015,\"numberOfMembers\":17,\"schoolId\":2"))));
        mvc.perform(post("/division")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"3.c\",\"classMaster\":\"Szabo Balazs\",\"startupYear\":2015,\"numberOfMembers\":17,\"schoolId\":2}"))
                .andExpect(status().isOk());
        mvc.perform(get("/division"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"3.c\",\"classMaster\":\"Szabo Balazs\",\"startupYear\":2015,\"numberOfMembers\":17,\"schoolId\":2")));
    }

    @Test
    public void testUpdateDivision() throws Exception {
        mvc.perform(get("/division/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(is("{\"id\":1,\"name\":\"1.b\",\"classMaster\":\"Kovacs Maria\",\"startupYear\":2020,\"numberOfMembers\":26,\"schoolId\":2}")));
        mvc.perform(put("/division/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"classMaster\":\"Szabo Balazs\"}"))
                .andExpect(status().isOk());
        mvc.perform(get("/division/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(is("{\"id\":1,\"name\":\"1.b\",\"classMaster\":\"Szabo Balazs\",\"startupYear\":2020,\"numberOfMembers\":26,\"schoolId\":2}")));
    }

    @Test
    public void testDeleteDivision() throws Exception {
        mvc.perform(get("/division"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1")));
        mvc.perform(delete("/division/1"))
                .andExpect(status().isOk());
        mvc.perform(get("/division"))
                .andExpect(status().isOk())
                .andExpect(content().string(not(containsString("\"id\":1"))));
    }
}
