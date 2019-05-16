package com.example.asiakasrekisteri.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.asiakasrekisteri.domain.CommentRepository;
import com.example.asiakasrekisteri.domain.CustomerRepository;
import com.example.asiakasrekisteri.model.Comment;
import com.example.asiakasrekisteri.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerrepository;

	@Autowired
	private CommentRepository commentrepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// Home page
	@GetMapping("/customers")
	public String customerlist(Model model) {
		model.addAttribute("customers", customerrepository.findAll());
		return "customers";
	}

	// RESTful service to get all customers
	@GetMapping("/allcustomers")
	public @ResponseBody List<Customer> customerlistRest() {
		return (List<Customer>) customerrepository.findAll();
	}

	// Add customer
	@GetMapping("/add")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "addcustomer";
	}

	// RESTful service to save new customer
	@PostMapping("/savecustomer")
	public @ResponseBody Customer addCustomerRest(@RequestBody Customer customer) {
		return customerrepository.save(customer);
	}

	// Save customer
	@PostMapping("/save")
	public String save(Customer customer) {
		customerrepository.save(customer);
		return "redirect:customers";
	}

	// Edit customer
	@GetMapping("/editcustomer/{customerId}")
	public String editCustomer(@PathVariable("customerId") Long customerId, Model model) {
		model.addAttribute("customer", customerrepository.findById(customerId));
		return "editcustomer";
	}

	// Get customer and comments
	@GetMapping("/customer/{customerId}")
	public String customer(@PathVariable("customerId") Long customerId, Model model) {
		model.addAttribute("customer", customerrepository.findById(customerId).orElse(null));
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		model.addAttribute("comments", commentrepository.findByCustomer(customer));
		return "customer";
	}

	// Add comment to customer
	@GetMapping("/customer/{customerId}/addcomment")
	public String customerAddComment(@PathVariable("customerId") Long customerId, Model model) {
		model.addAttribute("customer", customerrepository.findById(customerId).orElse(null));
		Comment comment = new Comment();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		comment.setCustomer(customer);
		model.addAttribute("comment", comment);
		return "addcomment";
	}

	// Save comment
	@PostMapping("/savecomment")
	public String savecomment(Comment comment) {
		commentrepository.save(comment);
		return "redirect:customers";
	}

}
