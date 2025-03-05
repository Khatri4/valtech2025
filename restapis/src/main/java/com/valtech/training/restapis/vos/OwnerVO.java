package com.valtech.training.restapis.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.restapis.entities.Owner;
import com.valtech.training.restapis.entities.Watch;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class OwnerVO {
	
	
	private long id;
	private String name;
	private String mobile;
	private String email;
	private List<Long> watches;
	
	public OwnerVO() {}
	public OwnerVO(String name, String mobile, String email) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}
	public OwnerVO(long id, String name, String mobile, String email, List<Long> watches) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.watches = watches;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "OwnerVO [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", watches="
				+ watches + "]";
	}
	public static List<OwnerVO> toOwnerVO(List<Owner> owners){
		return owners.stream().map(o->OwnerVO.from(o)).collect(Collectors.toList());
	}
	
	public static OwnerVO from(Owner o) {
		List<Long> watches = o.getWatches() == null? List.of(): o.getWatches().stream().map(ow->ow.getId()).collect(Collectors.toList());
		return new OwnerVO(o.getId(),o.getName(), o.getEmail(), o.getMobile(), watches);
	}
	
	public void updateOwnerFromVO(Owner o) {
		o.setName(name);
		o.setEmail(email);
		o.setMobile(mobile);
	}
	
	
	public Owner toOwner() {
		Owner o = new Owner(name,email,mobile);
		o.setId(id);
		return o;
	}
	
	
	public List<Long> getWatches() {
		return watches;
	}
	public void setWatches(List<Long> watches) {
		this.watches = watches;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
