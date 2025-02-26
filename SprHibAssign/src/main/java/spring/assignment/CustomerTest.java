package spring.assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CustomerTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("assignment.xml");
//		CustomerService cs = ctx.getBean(CustomerService.class);
//		System.out.println(cs.getClass().getName());
//		Customer customer=cs.get(1);
//		customer.setAge(25);
//		cs.update(customer);
//		cs.save(new Customer("Indrajeet", 22, "Venus", "Valtech"));
//		cs.update(new Customer("Rushab", 24, "Venus", "Valtech").setCusId(2));
		
//		cs.update(cs.get(1).setAge(26));
//		cs.getAll().forEach(e -> System.out.println(e));
//		cs.get(1);
		
		
		ItemHibernateDAOImpl is = ctx.getBean(ItemHibernateDAOImpl.class);
		System.out.println(is.getClass().getName());
		
//		is.save(new Item("Computer", "PC", 4, 5, 7));
//		is.get(1);
//		is.getAll().forEach(e -> System.out.println(e));
		
		Item i = is.get(1);
		i.setMaxQuantity(10);
		is.update(i);
		
		
		ctx.close();
		
	}

}
