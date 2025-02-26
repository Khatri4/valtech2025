package spring.assignment;

import java.util.List;

public interface ItemService {

	void save(Item i);

	void update(Item i);

	void delete(Item i);
	
	Customer get(Item i);
	
	List<Item> getAll();
	
}
