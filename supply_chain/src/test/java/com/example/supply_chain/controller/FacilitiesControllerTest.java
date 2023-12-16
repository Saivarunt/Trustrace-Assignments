package com.example.supply_chain.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.json.JSONString;
import org.json.JSONStringer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.supply_chain.controller.FacilitiesController;
import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.service.FacilitiesServiceInterface;
import com.example.supply_chain.service.impl.FacilitiesService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = FacilitiesController.class)
public class FacilitiesControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    // @SpyBean
    FacilitiesServiceInterface service;

    @Test
    void testWhetherFacilityExists() throws Exception {
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(List.of(new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD")));
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/facilities/select/facilitiesbyId/cd")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________GET________________");
        System.out.println(result);
        System.out.println("_____________________________");

        List<Facilities> op = Arrays.asList(new ObjectMapper().readValue(result, Facilities[].class));
        // .andReturn().getResponse().getContent;
        assertFalse(op.isEmpty());

    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testPOSTExists() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD");
        Mockito.when(service.saveData(f)).thenReturn(f);
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/facilities/save/facilities").content(asJsonString(f))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________POST________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Facilities op = new ObjectMapper().readValue(result, Facilities.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }

    @Test
    void testPUTExists() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD");
        Mockito.when(service.update(f)).thenReturn(f);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/facilities/update/facilities").content(asJsonString(f))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotAcceptable())
        // .andExpect(MockMvcResultMatchers.jsonPath("$.createdBy").value("Sai"))
        // .andExpect(MockMvcResultMatchers.jsonPath("$.facilitiesUid").value("DRRR"))
        // .andExpect(MockMvcResultMatchers.jsonPath("$.location").value("DFSD"))
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________PUT________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Facilities op = new ObjectMapper().readValue(result, Facilities.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }

    @Test
    void testDELExists() throws Exception {
        Mockito.when(service.getById("ab")).thenReturn(List.of(new Facilities("ab", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD")));
        Mockito.when(service.delete("ab")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facilities/delete/facilities/{id}","ab"))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________DELETE________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Boolean op = new ObjectMapper().readValue(result,Boolean.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }
}
