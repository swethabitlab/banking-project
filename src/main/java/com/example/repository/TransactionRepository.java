package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	List<Transaction> findBySourceAccount_AccountNumberOrTargetAccount_AccountNumber
	                                               (String sourceAccountNumber,String targetAccountNumber);
}
