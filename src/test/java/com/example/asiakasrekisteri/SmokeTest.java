package com.example.asiakasrekisteri;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.asiakasrekisteri.web.CustomerController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

	@Autowired
	private CustomerController customer;

	@Test
	public void contextLoads() throws Exception {
		assertThat(customer).isNotNull();

	}

}
