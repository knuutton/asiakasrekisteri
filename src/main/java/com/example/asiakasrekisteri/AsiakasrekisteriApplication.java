package com.example.asiakasrekisteri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.asiakasrekisteri.domain.CommentRepository;
import com.example.asiakasrekisteri.domain.CustomerRepository;
import com.example.asiakasrekisteri.domain.UserRepository;
import com.example.asiakasrekisteri.model.Comment;
import com.example.asiakasrekisteri.model.Customer;
import com.example.asiakasrekisteri.model.User;

@SpringBootApplication
public class AsiakasrekisteriApplication {

	private static final Logger log = LoggerFactory.getLogger(AsiakasrekisteriApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AsiakasrekisteriApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerrepository, CommentRepository commentrepository, UserRepository userrepository) {
		return (args) -> {

			log.info("Save couple customers");
			Customer customer1 = new Customer("Pihvimylläri2", "Pola Oy", "13245-7", "010123456", "info@pihvi.fi",
					"www.pihvimylläri.fi", "katukuja 1", "Pola", "01800", "Klaukkala");

			Customer customer2 = new Customer("Pihvimylläri4", "Pola Oy", "13245-7", "010123456", "info@pihvi.fi",
					"www.pihvimylläri.fi", "katukuja 1", "Pola", "01800", "Kerava");

			customerrepository.save(customer1);
			customerrepository.save(customer2);

			log.info("Save couple comments");
			commentrepository.save(new Comment("Testi", customer2));
			commentrepository.save(new Comment("Kommentti", customer1));

			// Create users: admin/admin & user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
					"user@user.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"admin@admin.com", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);

			log.info("fetch all customers");
			for (Customer customers : customerrepository.findAll()) {
				log.info(customers.toString());
			}

		};

	}
}
