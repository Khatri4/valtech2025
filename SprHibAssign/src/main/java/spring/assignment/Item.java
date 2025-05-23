package spring.assignment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemseq")
	@SequenceGenerator(name = "itemseq", sequenceName = "item_seq", allocationSize = 1)
	private int itemId;
	private String name;
	private String description;
	private int quantity;
	private int reorderQuantity;
	private int maxQuantity;
	
	
	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
	private Set<LineItem> getLineItems;
	
	
	public Item() {}
	public Item(String name, String description, int quantity, int reorderQuantity, int maxQuantity) {
//		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.reorderQuantity = reorderQuantity;
		this.maxQuantity = maxQuantity;
	}
	
	
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", reorderQuantity=" + reorderQuantity + ", maxQuantity=" + maxQuantity + "]";
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getReorderQuantity() {
		return reorderQuantity;
	}
	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	
	
	

}
