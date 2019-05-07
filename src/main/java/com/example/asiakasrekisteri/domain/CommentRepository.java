package com.example.asiakasrekisteri.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.asiakasrekisteri.model.Comment;
import com.example.asiakasrekisteri.model.Customer;

public interface CommentRepository extends CrudRepository<Comment, Long> {

	List<Comment> findByCommentId(long commentId);
	List<Comment> findByCustomer(Customer customer);
	
}
