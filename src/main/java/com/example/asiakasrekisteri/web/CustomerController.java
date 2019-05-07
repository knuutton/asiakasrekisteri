package com.example.asiakasrekisteri.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.asiakasrekisteri.domain.CommentRepository;
import com.example.asiakasrekisteri.domain.CustomerRepository;
import com.example.asiakasrekisteri.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	private CommentRepository commentrepository;

	// kaikki asiakkaat
	@GetMapping("/customers")
	public String customerlist(Model model) {
		model.addAttribute("customers", customerrepository.findAll());
		return "customers";
	}

	// lisää asiakas
	@GetMapping("/add")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "addcustomer";
	}

	// tallenna asiakas
	@PostMapping("/save")
	public String save(Customer customer) {
		customerrepository.save(customer);
		return "redirect:customers";
	}

	// muokkaa asiakasta
	@GetMapping("/editcustomer/{customerId}")
	public String editCustomer(@PathVariable("customerId") Long customerId, Model model) {
		model.addAttribute("customer", customerrepository.findById(customerId));
		return "editcustomer";
	}

	@GetMapping("/customer/{customerId}")
	public String customer(@PathVariable("customerId") Long customerId, Model model) {
		model.addAttribute("customer", customerrepository.findById(customerId).orElse(null));
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		model.addAttribute("comments", commentrepository.findByCustomer(customer));
		return "customer";
	}
	
}
