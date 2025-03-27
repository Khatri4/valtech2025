package com.valtech.training.assignment5loanmang.webservices;

import javax.jws.WebService;

import com.valtech.training.assignment5loanmang.entities.Loan;

@WebService
public interface LoanServiceWS {

	Loan saveLoan(Loan loan);

	Loan getLoan(int id);

	Loan applyLoan(Loan loan);

}