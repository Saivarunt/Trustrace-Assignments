package com.example.supply_chain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = SupplyChainApplication.class )
@ComponentScan({"com.*"})
class SupplyChainApplicationTests {



	@Test
	void contextLoads() {
	}

}
