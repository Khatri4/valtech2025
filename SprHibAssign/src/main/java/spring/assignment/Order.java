package spring.assignment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "order_info")
public class Order {

	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq", allocationSize = 1)
	private int orderId;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	public enum Status{
		PACKED, DELIVERED, IN_WAREHOUSE, REJECTED
	}
	
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId", referencedColumnName = "cusId")
	private Customer customer;
	
	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	private Set<LineItem> lineItems;

	
	public Order() {}
	public Order(Status status) {
		this.status = status;
	}
	
	
	
	public void addLineItem(LineItem li) {
		if(lineItems == null) lineItems = new HashSet<LineItem>();
		lineItems.add(li);
		li.setOrder(this);
		
	}
	public void removeLineItem(LineItem li) {
		lineItems.remove(li);
		li.setOrder(null);
	}
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Set<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(Set<LineItem> getLineItems) {
		this.lineItems = getLineItems;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	
	
}
