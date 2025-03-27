package com.valtech.training.assignment5loanmang.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment5loanmang.entities.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {

}
