package spring.assignment;

import java.util.List;

public interface OrderService {

	void save(Order o);

	void update(Order o);

	void delete(int id);

	Order get(int id);

	List<Order> getAll();

}