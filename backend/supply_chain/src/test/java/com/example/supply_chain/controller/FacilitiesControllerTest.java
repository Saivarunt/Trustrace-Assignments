package com.example.supply_chain.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.nio.file.Files;
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
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

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

    // GET
    @Test
    void testWhetherFacilityExists() throws Exception {
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(List.of(new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","")));
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/facilities/select/facilitiesbyId/cd")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________GET________________");
        System.out.println(result);
        System.out.println("_____________________________");

        List<Facilities> op = Arrays.asList(new ObjectMapper().readValue(result, Facilities[].class));
        assertFalse(op.isEmpty());
    }

    @Test
    void testWhetherFacilityExistsBR() throws Exception {
        Mockito.when(service.getById(Mockito.anyString())).thenThrow(RuntimeException.class);
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/facilities/select/facilitiesbyId/cd")).andExpect(status().isBadRequest()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________GETBR________________");
        System.out.println(result);
        System.out.println("_____________________________");

        List<Facilities> op = Arrays.asList(new ObjectMapper().readValue(result, Facilities[].class));
        assertFalse(op.isEmpty());
    }


    // POST
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testPOSTExists() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
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
        assertNotEquals(null,op);
    }

    @Test
    void testPOSTExistsNA() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(f));
        Mockito.when(service.saveData(f)).thenReturn(f);
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/facilities/save/facilities").content(asJsonString(f))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotAcceptable()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________POSTNA________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Facilities op = new ObjectMapper().readValue(result, Facilities.class);
        assertNotEquals(null,op);
    }

    @Test
    void testPOSTExistsBR() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(service.getByUid("DRRR")).thenThrow(RuntimeException.class);
        Mockito.when(service.saveData(f)).thenReturn(f);
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/facilities/save/facilities").content(asJsonString(f))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________POSTBR________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Facilities op = new ObjectMapper().readValue(result, Facilities.class);
        assertNotEquals(null,op);
    }

    // PUT
    @Test
    void testPUTExistsNA() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(service.update(f)).thenReturn(f);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/facilities/update/facilities").content(asJsonString(f))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotAcceptable())
        // .andExpect(MockMvcResultMatchers.jsonPath("$.createdBy").value("Sai"))
        // .andExpect(MockMvcResultMatchers.jsonPath("$.facilitiesUid").value("DRRR"))
        // .andExpect(MockMvcResultMatchers.jsonPath("$.location").value("DFSD"))
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________PUTNA________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Facilities op = new ObjectMapper().readValue(result, Facilities.class);
        assertNotEquals(null,op);
    }

    @Test
    void testPUTExists() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(f));
        Mockito.when(service.update(f)).thenReturn(f);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/facilities/update/facilities").content(asJsonString(f))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________PUT________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Facilities op = new ObjectMapper().readValue(result, Facilities.class);
        assertNotEquals(null,op);
    }

    @Test
    void testPUTExistsBR() throws Exception {
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(service.getByUid("DRRR")).thenThrow(RuntimeException.class);
        Mockito.when(service.update(f)).thenReturn(f);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/facilities/update/facilities").content(asJsonString(f))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________PUTBR________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Facilities op = new ObjectMapper().readValue(result, Facilities.class);
        assertNotEquals(null,op);
    }
    
    // DELETE
    @Test
    void testDELExists() throws Exception {
        Mockito.when(service.getById("ab")).thenReturn(List.of(new Facilities("ab", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","")));
        Mockito.when(service.delete("ab")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facilities/delete/facilities/{id}","ab"))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________DELETE________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Boolean op = new ObjectMapper().readValue(result,Boolean.class);
        assertNotEquals(null,op);
    }

    @Test
    void testDELExistsNA() throws Exception {
        Mockito.when(service.delete("ab")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facilities/delete/facilities/{id}","ab"))
        .andExpect(status().isNotAcceptable())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________DELETENA________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Boolean op = new ObjectMapper().readValue(result,Boolean.class);
        assertNotEquals(null,op);
    }

    @Test
    void testDELExistsBR() throws Exception {
        Mockito.when(service.getById("ab")).thenThrow(RuntimeException.class);
        Mockito.when(service.delete("ab")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facilities/delete/facilities/{id}","ab"))
        .andExpect(status().isBadRequest())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________DELETEBR________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Boolean op = new ObjectMapper().readValue(result,Boolean.class);
        assertNotEquals(null,op);
    }



    // GET
    @Test
    void testWhetherFacilityImageExists() throws Exception {
        Mockito.when(service.getByUid(Mockito.anyString())).thenReturn(List.of(new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","D:/varun/college/trustrace/code/java/supply_chain/image_files/img.jpg")));
        Mockito.when(service.getByFileName(Mockito.anyString())).thenReturn(new byte[]{});
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/facilities/withImage/DRRR/img.jpg")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________GET________________");
        System.out.println(result);
        System.out.println("_____________________________");

        // byte[] op =new ObjectMapper().readValue(result, byte[].class);
        // assertFalse(op);
    }

    @Test
    void testWhetherFacilityImageExistsNF() throws Exception {
        Mockito.when(service.getByUid(Mockito.anyString())).thenReturn(List.of(new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","")));
        Mockito.when(service.getByFileName(Mockito.anyString())).thenReturn(new byte[]{});
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/facilities/withImage/DRRR/img.jpg")).andExpect(status().isNotFound()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________GETNF________________");
        System.out.println(result);
        System.out.println("_____________________________");
    }

    @Test
    void testWhetherFacilityImageExistsBR() throws Exception {
        Mockito.when(service.getByUid(Mockito.anyString())).thenThrow(RuntimeException.class);
        Mockito.when(service.getByFileName(Mockito.anyString())).thenReturn(new byte[]{});
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/facilities/withImage/DRRR/img.jpg")).andExpect(status().isBadRequest()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("_____________GETBR________________");
        System.out.println(result);
        System.out.println("_____________________________");
    }

    // PUT
    @Test
    void testPUTImageExists() throws Exception {
        File file = new File("1.jpg");
        // String name = "1.jpg";
        String originalFileName = "1.jpg";
        String contentType = "image/jpg";
        byte[] content = null;
        MultipartFile mFile = new MockMultipartFile("image",originalFileName,contentType,content);
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(f));
        Mockito.when(service.uploadFacilitywithFile(Mockito.any(),Mockito.any(MultipartFile.class))).thenReturn("success");
        String result = mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT,"/facilities/update/image/DRRR").file(new MockMultipartFile("image",originalFileName,contentType,content)))
        // .contentType(MediaType.MULTIPART_FORM_DATA)
        // .accept(MediaType.MULTIPART_FORM_DATA))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________PUT________________");
        System.out.println(result);
        System.out.println("_____________________________");

        // Facilities op = new ObjectMapper().readValue(result, Facilities.class);
        // assertNotEquals(null,op);
    }

    @Test
    void testPUTImageExistsNA() throws Exception {
        String originalFileName = "1.jpg";
        String contentType = "image/jpg";
        byte[] content = null;
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(f));
        Mockito.when(service.uploadFacilitywithFile(Mockito.any(),Mockito.any(MultipartFile.class))).thenReturn("Unsuccessful");
        String result = mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT,"/facilities/update/image/DRRR").file(new MockMultipartFile("image",originalFileName,contentType,content)))
        .andExpect(status().isNotAcceptable())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________PUTNA________________");
        System.out.println(result);
        System.out.println("_____________________________");
    }

    @Test
    void testPUTImageExistsBR1() throws Exception {
        String originalFileName = "1.jpg";
        String contentType = "image/jpg";
        byte[] content = null;
        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(f));
        Mockito.when(service.uploadFacilitywithFile(Mockito.any(),Mockito.any(MultipartFile.class))).thenThrow(RuntimeException.class);
        String result = mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT,"/facilities/update/image/DRRR").file(new MockMultipartFile("image",originalFileName,contentType,content)))
        .andExpect(status().isBadRequest())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________PUTBR1________________");
        System.out.println(result);
        System.out.println("_____________________________");
    }

    @Test
    void testPUTImageExistsNF() throws Exception {
        String originalFileName = "1.jpg";
        String contentType = "image/jpg";
        byte[] content = null;
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(new Facilities()));
        Mockito.when(service.uploadFacilitywithFile(Mockito.any(),Mockito.any(MultipartFile.class))).thenReturn("success");
        String result = mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT,"/facilities/update/image/DRRR").file(new MockMultipartFile("image",originalFileName,contentType,content)))
        .andExpect(status().isNotFound())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________PUTNF________________");
        System.out.println(result);
        System.out.println("_____________________________");
    }


    // DELETE
    @Test
    void testDELImageExists() throws Exception {

        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","D:/varun/college/trustrace/code/java/supply_chain/image_files/1.jpg");
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(f));
        Mockito.when(service.deleteImage(f,"1.jpg")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facilities/delete/DRRR/1.jpg"))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________DEL________________");
        System.out.println(result);
        System.out.println("_____________________________");

        // Facilities op = new ObjectMapper().readValue(result, Facilities.class);
        // assertNotEquals(null,op);
    }

    // DELETE
    @Test
    void testDELImageExistsBR() throws Exception {

        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","D:/varun/college/trustrace/code/java/supply_chain/image_files/1.jpg");
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(f));
        Mockito.when(service.deleteImage(f,"1.jpg")).thenThrow(RuntimeException.class);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facilities/delete/DRRR/1.jpg"))
        .andExpect(status().isBadRequest())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________DELBR________________");
        System.out.println(result);
        System.out.println("_____________________________");
    }

    @Test
    void testDELImageExistsNA() throws Exception {

        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","D:/varun/college/trustrace/code/java/supply_chain/image_files/1.jpg");
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(f));
        Mockito.when(service.deleteImage(f,"2.jpg")).thenReturn(false);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facilities/delete/DRRR/1.jpg"))
        .andExpect(status().isNotAcceptable())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________DELNA________________");
        System.out.println(result);
        System.out.println("_____________________________");
    }

    @Test
    void testDELImageExistsNF1() throws Exception {

        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(new Facilities()));
        Mockito.when(service.deleteImage(new Facilities(),"1.jpg")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facilities/delete/DRRR/1.jpg"))
        .andExpect(status().isNotFound())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________DELNF1________________");
        System.out.println(result);
        System.out.println("_____________________________");
    }

    @Test
    void testDELImageExistsNF2() throws Exception {

        Facilities f = new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(service.getByUid("DRRR")).thenReturn(List.of(f));
        Mockito.when(service.deleteImage(f,"1.jpg")).thenReturn(false);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facilities/delete/DRRR/1.jpg"))
        .andExpect(status().isNotFound())
        .andReturn().getResponse().getContentAsString();
        
        System.out.println("_____________DELNF2________________");
        System.out.println(result);
        System.out.println("_____________________________");
    }
}
