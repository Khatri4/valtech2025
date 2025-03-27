package com.valtech.training.assignment5loanmangclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.assignment5loanmang.entities.Loan;
import com.valtech.training.assignment5loanmang.entities.Loan.LoanStatus;
import com.valtech.training.assignment5loanmang.entities.Loan.LoanType;
import com.valtech.training.assignment5loanmang.vos.LoanVO;
import com.valtech.training.assignment5loanmang.webservices.LoanServiceWS;

@SpringBootTest
class Assignment5LoanMangClientApplicationTests {
	
	@Autowired
	private LoanServiceWS loanServiceWS;

	@Test
	void contextLoads() {
		
		Loan l = new Loan("Suhas", 787681, 300, LoanType.CAR, "Gold", 2000,
				8000, 3000, LoanStatus.APPLIED);
		Loan l2 = new Loan("Mital", 354387, 599, LoanType.HOME, "Car", 20000,
				7000, 30000, LoanStatus.APPLIED);
		Loan l3 = new Loan("Indrajeet", 989876,910, LoanType.CAR, "Gold", 90000,
				100000, 30000, LoanStatus.APPLIED);
		Loan l4 = new Loan("SRK", 434545, 750, LoanType.HOME, "Car", 180000,
				200000, 51000, LoanStatus.APPLIED);
		
		

		loanServiceWS.applyLoan(l);
		loanServiceWS.applyLoan(l2);
		loanServiceWS.applyLoan(l3);
		loanServiceWS.applyLoan(l4);
//		System.err.println("=========>>>>>>>>>>" + l);
//		loanServiceWS.applyLoan(LoanVO.from(l));
		
		
		


		
			
			
		}
	}


