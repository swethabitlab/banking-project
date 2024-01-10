package com.example.mapper;

import org.springframework.stereotype.Component;

import com.example.dto.TransactionDTO;
import com.example.entity.Transaction;

@Component
public class TransactionMapper {

	public TransactionDTO toDto(Transaction transaction) {
		TransactionDTO dto= new TransactionDTO();
		dto.setId(transaction.getId());
		dto.setAmount(transaction.getAmount());
		dto.setTransaction_type(transaction.getTransaction_type());
		dto.setTransaction_date(transaction.getTransaction_date());
		dto.setSourceAccountNumber(transaction.getSourceAccount().getAccountNumber());
		if(transaction.getTargetAccount()!=null) {
			dto.setTargetAccountNumber(transaction.getTargetAccount().getAccountNumber());
		}
		else {
			dto.setTargetAccountNumber("N/A");
		}
		return dto;
		
	}
}
