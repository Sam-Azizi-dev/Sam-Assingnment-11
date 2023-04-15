package com.codercampus.Assignment11.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.services.TransactionServices;

@Controller
public class TransactionController {

	@Autowired
	private TransactionServices transactionService;
	
	@GetMapping("/transactions")
	public String getTransactions(ModelMap model) {
		List<Transaction> transactions = transactionService.findAll();
		model.put("transactions", transactions);
		return "transactions";
	}
	@GetMapping("/transaction/{transactionId}")
	public String getTransactionInfo (@PathVariable("transactionId") Long transactionId, ModelMap model) {
		Transaction transaction = transactionService.findById(transactionId);
		model.put("transaction", transaction);
		return "transaction";
	}
	
	@PostMapping("/transactions/{transactionId}")
	public String showTransaction(@PathVariable Long transactionId) {
		return "redirect:/transaction/{transactionId}";
	}

	
}
