package com.example.supply_chain.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.shortThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.model.Location;
import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.service.FacilitiesServiceInterface;
import com.example.supply_chain.service.SupplierServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = SuppliersController.class)
public class SupplierControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    // @SpyBean
    SupplierServiceInterface service;
    @Test
    void testWhetherSupplierExists() throws Exception {
        Mockito.when(service.getById(Mockito.anyString())).thenThrow(RuntimeException.class);
        // .thenReturn(List.of(new Suppliers("cd","testemail@gmail.com",(ArrayList<Facilities>) List.of(new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD")),new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1")));
        // String result = 
        mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/select/suppliersbyId/cd")).andExpect(status().isBadRequest());
        // .andReturn().getResponse().getContentAsString();
        // .getResponse()
                // .getContentAsString();
        // System.out.println("_____________________________");
        // System.out.println(result);
        // System.out.println("_____________________________");

        // List<Facilities> op = Arrays.asList(new ObjectMapper().readValue(result, Facilities[].class));
        // // .andReturn().getResponse().getContent;
        // assertFalse(op.isEmpty());

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
        Facilities f =new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Mockito.when(service.saveData(s)).thenReturn(s);
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/suppliers/save/suppliers").content(asJsonString(s))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________POST________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Suppliers op = new ObjectMapper().readValue(result, Suppliers.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }

    @Test
    void testPUTExists() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Suppliers s1 = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","Wool","style","supplier A","supplier1","tier1");
        Mockito.when(service.getByUid("supplier1")).thenReturn(List.of(s));
        Mockito.when(service.update(s1)).thenReturn(s1);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/suppliers/update/suppliers").content(asJsonString(s1))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        // .andExpect(MockMvcResultMatchers.jsonPath("$.createdBy").value("Sai"))
        // .andExpect(MockMvcResultMatchers.jsonPath("$.facilitiesUid").value("DRRR"))
        // .andExpect(MockMvcResultMatchers.jsonPath("$.location").value("DFSD"))
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________PUT________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Suppliers op = new ObjectMapper().readValue(result, Suppliers.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }

    @Test
    void testDELExists() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Mockito.when(service.getById("cd")).thenReturn(List.of(s));
        Mockito.when(service.delete("cd")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/suppliers/delete/suppliers/{id}","cd"))
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
