package spring.assignment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer_info")
public class Customer {
	public enum CustomerStatus{
		ENABLE, DISABLE
	}

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cusseq")
	@SequenceGenerator(name = "cusseq", sequenceName = "cus_req", allocationSize = 1, initialValue = 1)
//	@Column(name="id")
	private int cusId;
	private String name;
	private int age;
	private String address;
	private String permanentAddress;
	
	
	@Enumerated(EnumType.STRING)
	private CustomerStatus cusStatus=CustomerStatus.ENABLE;
	

	
	
	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<Order> orders;
	
	
	public Customer() {}
	public Customer(String name, int age, String address, String per_address) {
		super();
//		this.cusId = cusId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.permanentAddress = per_address;
		this.cusStatus = CustomerStatus.ENABLE;
	}
	

//	public Customer(String name, int age, String address, String per_address, CustomerStatus cusStatus) {
//		this.name = name;
//		this.age = age;
//		this.address = address;
//		this.per_address = per_address;
//		this.cusStatus = cusStatus.ENABLE;
//	}
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", per_address=" + permanentAddress + ", cusStatus=" + cusStatus + ", orders=" + orders + "]";
	}
	public CustomerStatus getCusStatus() {
		return cusStatus;
	}
	
	public void setCusStatus(CustomerStatus cusStatus) {
		this.cusStatus = cusStatus;
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
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String per_address) {
		this.permanentAddress = per_address;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
