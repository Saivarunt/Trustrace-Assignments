package com.example.supply_chain.controller;

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

import com.example.supply_chain.model.Availability;
import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.model.Location;
import com.example.supply_chain.model.Material;
import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.model.style;
import com.example.supply_chain.service.StyleServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = StyleController.class)
public class StyleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    StyleServiceInterface service;

    @Test
    void testWhetherStyleExists() throws Exception {
        Facilities f =new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Availability a = new Availability("High");
        RawMaterial rm = new RawMaterial("ab","rmsup1",a,new ArrayList<Facilities>(){{add(f);}},new ArrayList<String>(){{add("Silk");}},"m101","101","material A","material1",new ArrayList<String>(){{add("NONE");}},new ArrayList<Suppliers>(){{add(s);}},"Summer","2023");
        Material m = new Material(rm,100);
        style stl = new style("st",a,f,new ArrayList<Material>(){{add(m);}},"NONE","Winter","Style A","S1010","style1",s,"Shirt","2023");
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(List.of(stl));
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/style/select/stylebyId/st")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________GET________________");
        System.out.println(result);
        System.out.println("_____________________________");

        List<style> op =Arrays.asList(new ObjectMapper().readValue(result, style[].class));
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
    void testWhetherPOSTExists() throws Exception {
        Facilities f =new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Availability a = new Availability("High");
        RawMaterial rm = new RawMaterial("ab","rmsup1",a,new ArrayList<Facilities>(){{add(f);}},new ArrayList<String>(){{add("Silk");}},"m101","101","material A","material1",new ArrayList<String>(){{add("NONE");}},new ArrayList<Suppliers>(){{add(s);}},"Summer","2023");
        Material m = new Material(rm,100);
        style stl = new style("st",a,f,new ArrayList<Material>(){{add(m);}},"NONE","Winter","Style A","S1010","style1",s,"Shirt","2023");
        Mockito.when(service.addData(stl)).thenReturn(stl);
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/style/add/style").content(asJsonString(stl))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________POST________________");
        System.out.println(result);
        System.out.println("_____________________________");

        style op =new ObjectMapper().readValue(result, style.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }

    @Test
    void testWhetherPUTExists() throws Exception {
        Facilities f =new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Availability a = new Availability("High");
        RawMaterial rm = new RawMaterial("ab","rmsup1",a,new ArrayList<Facilities>(){{add(f);}},new ArrayList<String>(){{add("Silk");}},"m101","101","material A","material1",new ArrayList<String>(){{add("NONE");}},new ArrayList<Suppliers>(){{add(s);}},"Summer","2023");
        Material m = new Material(rm,100);
        style stl = new style("st",a,f,new ArrayList<Material>(){{add(m);}},"NONE","Winter","Style A","S1010","style1",s,"Shirt","2023");
        style stl1 = new style("st",a,f,new ArrayList<Material>(){{add(m);}},"NONE","Winter","Style A","S1001","style1",s,"Shirt","2023");
        Mockito.when(service.getByUid("style1")).thenReturn(List.of(stl));
        Mockito.when(service.updateData(stl1)).thenReturn(stl1);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/style/update/style").content(asJsonString(stl1))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________PUT________________");
        System.out.println(result);
        System.out.println("_____________________________");

        style op =new ObjectMapper().readValue(result, style.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }



    @Test
    void testWhetherDELExists() throws Exception {
        Facilities f =new Facilities("fuid", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Suppliers s = new Suppliers("cd","testemail@gmail.com",new ArrayList<Facilities>(){{add(f);}},new Location("add","con","pin","reg","state"),"mtype","cotton","style","supplier A","supplier1","tier1");
        Availability a = new Availability("High");
        RawMaterial rm = new RawMaterial("ab","rmsup1",a,new ArrayList<Facilities>(){{add(f);}},new ArrayList<String>(){{add("Silk");}},"m101","101","material A","material1",new ArrayList<String>(){{add("NONE");}},new ArrayList<Suppliers>(){{add(s);}},"Summer","2023");
        Material m = new Material(rm,100);
        style stl = new style("st",a,f,new ArrayList<Material>(){{add(m);}},"NONE","Winter","Style A","S1010","style1",s,"Shirt","2023");
        Mockito.when(service.deleteData("st")).thenReturn(false);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/style/delete/style/{id}","st"))
        .andExpect(status().isNotAcceptable()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________DELETE________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Boolean op =new ObjectMapper().readValue(result, Boolean.class);
        // .andReturn().getResponse().getContent;
        assertNotEquals(null,op);

    }
}
