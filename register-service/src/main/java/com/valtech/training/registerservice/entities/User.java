package com.valtech.training.registerservice.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="Users")
public class User {
	
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
	@SequenceGenerator(name = "user_id", sequenceName = "user_id", allocationSize = 1)
	private long id;
	private String name;
	private String mobile;
	private int age;
	private String email;
	
	private boolean isKid;


	@ManyToOne(targetEntity = Subscription.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sub", referencedColumnName = "id")
	private Subscription subscription;
	
	public User() {}
	public User(String name, String mobile, int age, String email) {
		this.name = name;
		this.mobile = mobile;
		this.age = age;
		this.email = email;
	}
	public User(String name, String mobile, int age, String email, boolean isKid) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.age = age;
		this.email = email;
		this.isKid = isKid;
	}
	public User(String name, String mobile, int age, String email, boolean isKid, Subscription subscription) {
		this.name = name;
		this.mobile = mobile;
		this.age = age;
		this.email = email;
		this.isKid = isKid;
		this.subscription = subscription;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isKid() {
		return isKid;
	}
	public void setKid(boolean isKid) {
		this.isKid = isKid;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	
	
	
}
