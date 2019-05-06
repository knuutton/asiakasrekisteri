/*package com.example.asiakasrekisteri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cityId", nullable = false, updatable = false)
	private long cityId;
	private String city;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public City() {
		super();

	}

	public City(String city) {
		super();
		this.city = city;
	}

	public City(String city, Customer customer) {
		super();
		this.city = city;
		this.customer = customer;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", city=" + city + ", customer=" + customer + "]";
	}

	

}*/
