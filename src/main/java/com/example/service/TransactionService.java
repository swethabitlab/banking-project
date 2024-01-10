package com.example.service;

import java.util.List;

import com.example.dto.TransactionDTO;

public interface TransactionService {

	List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber);
}
