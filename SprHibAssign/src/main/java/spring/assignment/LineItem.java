package spring.assignment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class LineItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idseq")
	@SequenceGenerator(name = "idseq", sequenceName = "id_seq", allocationSize = 1)
	private int id;
	private int quantity;
	
	
	@ManyToOne(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_Id", referencedColumnName = "itemId")
	private Item item;
	
	@ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "orderId")
	private Order order;

	
	public LineItem() {}
	public LineItem(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
	
	
	
	

}
