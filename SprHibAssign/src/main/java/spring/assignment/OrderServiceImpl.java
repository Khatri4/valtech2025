package spring.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.assignment.Customer.CustomerStatus;
import spring.assignment.Order.Status;

public class OrderServiceImpl implements OrderService {

	
@Autowired	
private OrderHibernateDAO orderDAO;
	
	public void setOrderDAO(OrderHibernateDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	@Autowired
	private ItemDAO itemDAO;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	

	public void resetInventory(Item item) {
		
		item.setQuantity(item.getMaxQuantity());
		item.setReorderQuantity(0);
		itemDAO.update(item);
	}
	
	

	@Override
	public void save(Order o) {
		
		
		System.out.println("============================");
		boolean valid = true;
		 
		System.out.println(o.getLineItems().size() + "======================sdvskdvnxdkdnvdskx");
		for (LineItem lineItem : o.getLineItems()) {
			
			System.out.println(o.getLineItems()+ "========================");
			if(lineItem.getQuantity() > lineItem.getItem().getQuantity() || o.getCustomer().getCusStatus()== CustomerStatus.DISABLE) {
				valid = false;
				o.setStatus(Status.REJECTED);
				orderDAO.save(o);
				break;	
				
			}
		}
		if(valid) {
			System.out.println("=========================");
			o.setStatus(Status.PACKED);
			orderDAO.save(o);
			Item item;
			for (LineItem lineItem : o.getLineItems()) {
 
				item = itemDAO.get(lineItem.getItem().getItemId());
				item.setQuantity(item.getQuantity()-lineItem.getQuantity());
				item.setReorderQuantity(item.getReorderQuantity() + lineItem.getQuantity());
				System.out.println("======>>>>>>>>>>>>>>>"+item.getQuantity());
				itemDAO.update(item);
				if(item.getQuantity() == 0) {
					resetInventory(item);
				}				
 
			}			
		}
	}
		
		
	@Override
	public void update(Order o) {
		orderDAO.update(o);
	}

	@Override
	public void delete(int id) {
		orderDAO.delete(id);
	}

	@Override
	public Order get(int id) {
		return orderDAO.get(id);
	}

	@Override
	public List<Order> getAll() {
		return orderDAO.getAll();
	}
}
