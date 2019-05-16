package com.example.asiakasrekisteri.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer {

	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId", nullable = false, updatable = false)
	private long customerId;
	private String restaurant;
	private String company;
	private String vatNumber;
	private String phone;
	private String email;
	private String url;
	private String address;
	private String contactPerson;
	private String postalcode;
	private String city;

	@OneToMany
	@JsonManagedReference
	@JoinColumn(name = "commentId")
	private List<Comment> comments;

	// constructors
	public Customer() {
		super();

	}

	public Customer(String restaurant, String company, String vatNumber, String phone, String email, String url,
			String address, String contactPerson, String postalcode, String city) {
		super();
		this.restaurant = restaurant;
		this.company = company;
		this.vatNumber = vatNumber;
		this.phone = phone;
		this.email = email;
		this.url = url;
		this.address = address;
		this.contactPerson = contactPerson;
		this.postalcode = postalcode;
		this.city = city;
	}

	// getters and setters
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}
	
	//toString
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", restaurant=" + restaurant + ", company=" + company
				+ ", vatNumber=" + vatNumber + ", phone=" + phone + ", email=" + email + ", url=" + url + ", address="
				+ address + ", contactPerson=" + contactPerson + ", postalcode=" + postalcode + ", city=" + city + "]";
	}

	

}
