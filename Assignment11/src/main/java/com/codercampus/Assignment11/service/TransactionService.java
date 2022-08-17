package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository txnRepo;
	
	public List<Transaction> findAll(){
		List<Transaction> txns = txnRepo.findAll();
		Collections.sort(txns, (txn1,txn2) -> txn1.getDate().compareTo(txn2.getDate()));
		return txns;
	}

	public Transaction findById(Long txnId) {
		Optional<Transaction> txnOpt =txnRepo.findAll()
				                             .stream()
			                                 .filter(txn -> txn.getId().equals(txnId))
			                                 .findAny();
		return txnOpt.orElse(null);
	}

}
