package com.example.asiakasrekisteri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.asiakasrekisteri.domain.CustomerRepository;
import com.example.asiakasrekisteri.model.Customer;

@SpringBootApplication
public class AsiakasrekisteriApplication {

	private static final Logger log = LoggerFactory.getLogger(AsiakasrekisteriApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AsiakasrekisteriApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerrepository) {
		return (args) -> {

			log.info("Save couple customers");
			Customer customer1 = new Customer("Pihvimylläri2", "Pola Oy", "13245-7", "010123456", "info@pihvi.fi",
					"www.pihvimylläri.fi", "katukuja 1", "Pola", "01800");

			Customer customer2 = new Customer("Pihvimylläri4", "Pola Oy", "13245-7", "010123456", "info@pihvi.fi",
					"www.pihvimylläri.fi", "katukuja 1", "Pola", "01800");

			customerrepository.save(customer1);
			customerrepository.save(customer2);

			log.info("fetch all customers");
			for (Customer customers : customerrepository.findAll()) {
				log.info(customers.toString());
			}

		};

	}
}
