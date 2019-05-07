package com.example.asiakasrekisteri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="commentId", nullable = false, updatable = false)
	private long commentId;
	private String comment;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Comment() {
		super();

	}

	public Comment(String comment, Customer customer) {
		super();
		this.comment = comment;
		this.customer = customer;
	}

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

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", customer=" + customer + "]";
	}
	
	
}
