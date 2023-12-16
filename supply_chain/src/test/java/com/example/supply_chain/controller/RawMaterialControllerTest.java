package com.example.supply_chain.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.model.Location;
import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.model.Availability;
import com.example.supply_chain.service.RawMaterialServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(value = RawMaterialController.class)
public class RawMaterialControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    RawMaterialServiceInterface service;

    @Test
    void testWhetherRawMaterialExists() throws Exception {
        Facilities f =new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Availability a = new Availability("High");
        RawMaterial rm = new RawMaterial("ab","rmsup1",a,new ArrayList<Facilities>(){{add(f);}},new ArrayList<String>(){{add("Silk");}},"m101","101","material A","material1",new ArrayList<String>(){{add("NONE");}},new ArrayList<Suppliers>(){{add(s);}},"Summer","2023");
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(List.of(rm));
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/rawmaterial/select/rawmaterialbyId/ab")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________GET________________");
        System.out.println(result);
        System.out.println("_____________________________");

        List<RawMaterial> op =Arrays.asList(new ObjectMapper().readValue(result, RawMaterial[].class));
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

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
        Facilities f =new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Availability a = new Availability("High");
        RawMaterial rm = new RawMaterial("ab","rmsup1",a,new ArrayList<Facilities>(){{add(f);}},new ArrayList<String>(){{add("Silk");}},"m101","101","material A","material1",new ArrayList<String>(){{add("NONE");}},new ArrayList<Suppliers>(){{add(s);}},"Summer","2023");
        Mockito.when(service.getByUid("101")).thenReturn(List.of(rm));
        Mockito.when(service.saveData(rm)).thenReturn(new RawMaterial());
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/rawmaterial/save/rawmaterial").content(asJsonString(rm))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotAcceptable()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________POST________________");
        System.out.println(result);
        System.out.println("_____________________________");

        RawMaterial op = new ObjectMapper().readValue(result, RawMaterial.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }

    
    @Test
    void testPUTExists() throws Exception {
        Facilities f =new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Availability a = new Availability("High");
        RawMaterial rm = new RawMaterial("ab","rmsup1",a,new ArrayList<Facilities>(){{add(f);}},new ArrayList<String>(){{add("Silk");}},"m101","101","material A","material1",new ArrayList<String>(){{add("NONE");}},new ArrayList<Suppliers>(){{add(s);}},"Summer","2023");
        RawMaterial rm1 = new RawMaterial("ab","rmsup1",a,new ArrayList<Facilities>(){{add(f);}},new ArrayList<String>(){{add("Polyester");}},"m101","101","material A","material1",new ArrayList<String>(){{add("NONE");}},new ArrayList<Suppliers>(){{add(s);}},"Summer","2023");
        Mockito.when(service.getByUid("101")).thenReturn(List.of(rm));
        Mockito.when(service.update(rm1)).thenReturn(rm1);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/rawmaterial/update/rawmaterial").content(asJsonString(rm1))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________PUT________________");
        System.out.println(result);
        System.out.println("_____________________________");

        RawMaterial op = new ObjectMapper().readValue(result, RawMaterial.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }


    @Test
    void testDELExists() throws Exception {
        Facilities f =new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Availability a = new Availability("High");
        RawMaterial rm = new RawMaterial("ab","rmsup1",a,new ArrayList<Facilities>(){{add(f);}},new ArrayList<String>(){{add("Silk");}},"m101","101","material A","material1",new ArrayList<String>(){{add("NONE");}},new ArrayList<Suppliers>(){{add(s);}},"Summer","2023");
        Mockito.when(service.getById("ab")).thenReturn(List.of(rm));
        Mockito.when(service.delete("ab")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/rawmaterial/delete/rawmaterial/{id}","ab"))
        .andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________DELETE________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Boolean op = new ObjectMapper().readValue(result, Boolean.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }
}
