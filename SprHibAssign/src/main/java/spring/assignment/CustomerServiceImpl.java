package spring.assignment;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO customerDAO;
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public void save(Customer c) {
		customerDAO.save(c);
		
	}

	@Override
	public void update(Customer c) {
		customerDAO.update(c);
	}

	@Override
	public void delete(int id) {
		customerDAO.delete(id);
	}

	@Override
	public Customer get(int id) {
		return customerDAO.get(id);
	}

	@Override
	public List<Customer> getAll() {
		return customerDAO.getAll();
	}
	
	

}
