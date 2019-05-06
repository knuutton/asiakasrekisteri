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
			customerrepository.save(new Customer("Pihvimylläri", "Pola Oy", "13245-6", "010123456", "info@pihvi.fi", "www.pihvimylläri.fi", "katukuja 1", "Pola", "01800"));
			customerrepository.save(new Customer("Pihvimylläri2", "Pola Oy", "13245-7", "010123456", "info@pihvi.fi", "www.pihvimylläri.fi", "katukuja 1", "Pola", "01800"));
			customerrepository.save(new Customer("Pihvimylläri3", "Pola Oy", "13245-8", "010123456", "info@pihvi.fi", "www.pihvimylläri.fi", "katukuja 1", "Pola", "01800"));
			
			/*log.info("Save couple comments");
			commentrepository.save(new Comment());
			commentrepository.save(new Comment("Kommentti",));
			*/

		
			
			log.info("fetch all customers");
			for(Customer customers : customerrepository.findAll()) {
			log.info(customers.toString());
			}

		};
		
			
	}
}
