package com.codercampus.Assignment11.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.services.TransactionServices;

@Controller
public class TransactionController {
	@Autowired
	private TransactionServices transactionService;
	
	@GetMapping("/transactions")
	public String getTransactions(ModelMap model) {
		List<Transaction> transactions = transactionService.findAll();
		model.put("transaction", transactions);
		System.out.println(transactions);
		return "transactions";
	}
	
	
}
