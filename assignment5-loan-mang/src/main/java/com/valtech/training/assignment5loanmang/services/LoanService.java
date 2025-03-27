package com.valtech.training.assignment5loanmang.services;

import java.util.List;

import com.valtech.training.assignment5loanmang.entities.Loan;
import com.valtech.training.assignment5loanmang.vos.LoanVO;

public interface LoanService {

	LoanVO saveLoan(LoanVO lvo);

	LoanVO getLoan(int id);

	List<LoanVO> getAll();

	Loan processLoan(LoanVO loanVO);

	LoanVO applyLoan(LoanVO lvo);

}