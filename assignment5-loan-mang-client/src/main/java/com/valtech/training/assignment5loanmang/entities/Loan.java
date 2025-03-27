package com.valtech.training.assignment5loanmang.entities;




public class Loan {

	
	public enum LoanType{
		HOME, CAR
	}
	
	public enum LoanStatus{
		APPLIED, APPROVED, REJECTED
	}
	
	
	private int id;
	private String userName;
	private int aadhar;
	private int cibilScore;

	private LoanType loanType;
	
	private String asset;
	private int assetValue;
	private int value;
	private int income;
	
	
	private LoanStatus loanStatus;
	
	public Loan() {}
	public Loan(String userName, int aadhar, int cibilScore, LoanType loanType, String asset, int assetValue, int value,
			int income, LoanStatus loanStatus) {
		this.userName = userName;
		this.aadhar = aadhar;
		this.cibilScore = cibilScore;
		this.loanType = loanType;
		this.asset = asset;
		this.assetValue = assetValue;
		this.value = value;
		this.income = income;
		this.loanStatus = loanStatus;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAadhar() {
		return aadhar;
	}
	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}
	public int getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	public LoanType getLoanType() {
		return loanType;
	}
	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public int getAssetValue() {
		return assetValue;
	}
	public void setAssetValue(int assetValue) {
		this.assetValue = assetValue;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public LoanStatus getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}
	
	
	
	
	
	
}
