package com.valtech.training.assignment5loanmang.webservices;

import java.util.List;
import java.util.stream.Collectors;

import javax.jws.WebService;

import com.valtech.training.assignment5loanmang.entities.Loan;
import com.valtech.training.assignment5loanmang.services.LoanService;
import com.valtech.training.assignment5loanmang.vos.LoanVO;

@WebService(endpointInterface = "com.valtech.training.assignment5loanmang.webservices.LoanServiceWS", name ="LoanService", portName = "LoanServicePort")
public class LoanServiceWSImpl implements LoanServiceWS {
	
	private LoanService loanService;

	public LoanServiceWSImpl(LoanService loanService) {
		this.loanService = loanService;
	}
	
	
//	public List<Loan> getALL(){
//		return loanService.getAll().stream().map(l -> LoanVO.to(l.to())).collect(Collectors.toList());
////				loanService.getAll().stream().map(l -> LoanVO.from(l)).collect(Collectors.toList());
//	}
	
	
	@Override
	public Loan saveLoan(Loan loan) {
		return loanService.saveLoan(LoanVO.from(loan)).to();
	}
	
	
	@Override
	public Loan getLoan(int id) {
		return loanService.getLoan(id).to();
	}
	
	
	@Override
	public Loan applyLoan(Loan loan) {
		return loanService.applyLoan(LoanVO.from(loan)).to();
	}
	
	

}
