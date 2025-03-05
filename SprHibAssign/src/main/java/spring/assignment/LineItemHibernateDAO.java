package spring.assignment;

import java.util.List;

public interface LineItemHibernateDAO {

	void save(LineItem li);

	void update(LineItem li);

	void delete(int id);

	LineItem get(int id);

	List<LineItem> getAll();

}