package spring.assignment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Order {

	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq", allocationSize = 1)
	private int orderId;
	
	private Status status;
	public enum Status{
		PACKED, DELIVERED, IN_WAREHOUSE
	}
	
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", referencedColumnName = "cusId")
	private Customer customer;
	
	@OneToMany(targetEntity = LineItems.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "get_line_items", referencedColumnName = "order")
	private Set<LineItems> getLineItems;

	
	public Order() {}
	public Order(Status status) {
		super();
		this.status = status;
	}
	
	
	
}
