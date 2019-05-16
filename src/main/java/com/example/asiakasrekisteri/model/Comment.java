package com.example.asiakasrekisteri.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Comment {
	
	//attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="commentId", nullable = false, updatable = false)
	private long commentId;
	private String comment;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	//Constructors
	public Comment() {
		super();
	}
	public Comment(String comment, Customer customer) {
		super();
		this.comment = comment;
		this.customer = customer;
	}
	
	//Getters and setters
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	//toString
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", customer=" + customer + "]";
	}
	
	
}
