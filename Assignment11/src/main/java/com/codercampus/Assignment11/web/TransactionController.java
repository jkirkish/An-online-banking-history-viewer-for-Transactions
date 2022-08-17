package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService txnService;
	
	@GetMapping("/transactions")
	public String getTransactions (ModelMap model) {
		List<Transaction>txns = txnService.findAll();
		model.put("transactions", txns);
		return "transactions";
	}
	@GetMapping("/transactions/{txnId}")
	public String getTransaction (ModelMap model, @PathVariable Long txnId) {
		Transaction txn = txnService.findById(txnId);
		model.put("transaction", txn);
		return "transaction";
	}

}
