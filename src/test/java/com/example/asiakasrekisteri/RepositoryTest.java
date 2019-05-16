package com.example.asiakasrekisteri;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.asiakasrekisteri.domain.CustomerRepository;
import com.example.asiakasrekisteri.model.Customer;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

	@Autowired
	private CustomerRepository customerrepository;

	@Test
	public void addNewCustomer() {

		Customer customer = new Customer("TestPubi", "Pola Oy", "13245-7", "010123456", "info@pihvi.fi",
				"www.pihvimylläri.fi", "katukuja 1", "Pola", "01800", "Klaukkala");
		customerrepository.save(customer);

		assertThat(customer.getCustomerId()).isNotNull();
		assertThat(customer.getRestaurant()).isEqualTo("TestPubi");

	}

}
