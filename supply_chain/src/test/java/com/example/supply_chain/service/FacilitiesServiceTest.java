package com.example.supply_chain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.repository.FacilitiesRepository;
import com.example.supply_chain.service.impl.FacilitiesService;

@ExtendWith(MockitoExtension.class)
public class FacilitiesServiceTest {

    @Mock
    FacilitiesRepository repo;

    @InjectMocks
    FacilitiesService service;

    // GET
    @Test
    void testWhetherFacilityExists() throws Exception {
        Facilities f= new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(repo.findBy_id("cd")).thenReturn(List.of(f));
        List<Facilities> result = service.getById("cd");
        System.out.println("_____________GET________________");
        System.out.println(result);
        System.out.println("_____________________________");
        assertEquals(List.of(f),result);
    }

    @Test
    void testWhetherFacilityExistsBR() throws Exception {
        Facilities f= new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(repo.findBy_id("cd")).thenThrow(RuntimeException.class);
        List<Facilities> result = service.getById("cd");
        System.out.println("_____________GETBR________________");
        System.out.println(result);
        System.out.println("_____________________________");
        assertNotEquals(List.of(f),result);

    }

    // POST
    @Test
    void testWhetherPOSTExists() throws Exception {
        Facilities f= new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(repo.save(f)).thenReturn(f);
        Facilities result = service.saveData(f);
        System.out.println("_____________POST________________");
        System.out.println(result);
        System.out.println("_____________________________");
        assertEquals(f,result);
    }

    @Test
    void testWhetherPOSTExistsBR() throws Exception {
        Facilities f= new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(repo.save(f)).thenThrow(RuntimeException.class);
        Facilities result = service.saveData(f);
        System.out.println("_____________POSTBR________________");
        System.out.println(result);
        System.out.println("_____________________________");
        assertNotEquals(List.of(f),result);
    }

    // PUT
    @Test
    void testWhetherPUTExists() throws Exception {
        Facilities f= new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(repo.save(f)).thenReturn(f);
        Facilities result = service.update(f);
        System.out.println("_____________PUT________________");
        System.out.println(result);
        System.out.println("_____________________________");
        assertEquals(f,result);
    }

    @Test
    void testWhetherPUTExistsBR() throws Exception {
        Facilities f= new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(repo.save(f)).thenThrow(RuntimeException.class);
        Facilities result = service.update(f);
        System.out.println("_____________PUTBR________________");
        System.out.println(result);
        System.out.println("_____________________________");
        assertNotEquals(f,result);
    }

    // DELETE
    @Test
    void testWhetherDELExists() throws Exception {
        Facilities f= new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(repo.deleteBy_id("cd")).thenReturn(true);
        Boolean result = service.delete("cd");
        System.out.println("_____________DELETE________________");
        System.out.println(result);
        System.out.println("_____________________________");
        assertEquals(true,result);
    }

    @Test
    void testWhetherDELExistsBR() throws Exception {
        Facilities f= new Facilities("cd", List.of("fsdf"), "Sai", "DRRR", "REUEI", "DFSD", "DFSD","");
        Mockito.when(repo.deleteBy_id("cd")).thenThrow(RuntimeException.class);
        Boolean result = service.delete("cd");
        System.out.println("_____________DELETEBR________________");
        System.out.println(result);
        System.out.println("_____________________________");
        assertEquals(false,result);
    }
}
