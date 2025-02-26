package spring.assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer_info")
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cusseq")
	@SequenceGenerator(name = "cusseq", sequenceName = "cus_req", allocationSize = 1, initialValue = 1)
//	@Column(name="id")
	private int cusId;
	private String name;
	private int age;
	private String address;
	private String per_address;
	
	
	
	
	public Customer() {}
	public Customer(String name, int age, String address, String per_address) {
		super();
//		this.cusId = cusId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.per_address = per_address;
	}
	
	
	
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", per_address=" + per_address + "]";
	}
	
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPer_address() {
		return per_address;
	}
	public void setPer_address(String per_address) {
		this.per_address = per_address;
	}
	
	
}
