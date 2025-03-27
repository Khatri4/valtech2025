package com.valtech.training.assignment5loanmang.webservices;

import java.util.List;

import javax.jws.WebService;

import com.valtech.training.assignment5loanmang.entities.Loan;
import com.valtech.training.assignment5loanmang.vos.LoanVO;

@WebService
public interface LoanServiceWS {

	Loan saveLoan(Loan loan);

	Loan getLoan(int id);

	Loan applyLoan(Loan loan);

}