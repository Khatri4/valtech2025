package com.valtech.training.assignment5loanmang.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.assignment5loanmang.entities.Loan;
import com.valtech.training.assignment5loanmang.entities.Loan.LoanStatus;
import com.valtech.training.assignment5loanmang.entities.Loan.LoanType;

public record LoanVO(int id,String userName, int aadhar, int cibilScore, String loanType, String asset, int assetValue, int value,
			int income, String loanStatus) {
	

	
	public static LoanVO from(Loan l) {
		return new LoanVO(l.getId(), l.getUserName(), l.getAadhar(), l.getCibilScore(), l.getLoanType().name(), l.getAsset(), l.getAssetValue(), l.getValue(), l.getIncome(), l.getLoanStatus().name());
	}
	
	public static List<LoanVO> from(List<Loan> loan){
		return loan.stream().map(l -> LoanVO.from(l)).collect(Collectors.toList());
	}
	
	public Loan to() {
		return new Loan(userName, aadhar, cibilScore, LoanType.valueOf(loanType), asset, assetValue, assetValue, income, LoanStatus.valueOf(loanStatus));
	}

}
