package spring.assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.assignment.Customer.CustomerStatus;
import spring.assignment.Order.Status;


public class CustomerTest {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("assignment.xml");
		CustomerService cs = ctx.getBean(CustomerService.class);
		CustomerDAO csh = ctx.getBean(CustomerHibernateDAOImpl.class);
		ItemDAO idao = ctx.getBean(ItemHibernateDAOImpl.class);
		ItemHibernateDAOImpl is = ctx.getBean(ItemHibernateDAOImpl.class);
		OrderHibernateDAO oh = ctx.getBean(OrderHibernateDAOImpl.class);
		OrderServiceImpl os = ctx.getBean(OrderServiceImpl.class);
		
		
		
//		Item i = new  Item("Parle G", "Biscuit", 200, 200, 400);
//		Item i1 = new  Item("Oreo", "Biscuit", 100, 100, 200);
//		Item i2 = new  Item("Burbon", "Biscuit", 20, 20, 40);
//		Item i3 = new  Item("CrackJax", "Biscuit", 50, 50, 100);
//		Item i4 = new  Item("Monnaco", "Biscuit", 30, 30, 60);
//		Item i5 = new  Item("Tiger Crunch", "Biscuit", 10, 10, 20);
//		
//		
//		idao.save(i);
//		idao.save(i2);
//		idao.save(i3);
//		idao.save(i4);
//		idao.save(i5);
//		idao.save(i1);
//		
//		
//		
//		Customer c = new Customer("Indrajeet", 23, "Naroda", "Valtech");
//		Customer c1 = new Customer("Bhavya", 22, "Naroda", "Valtech");
//		Customer c2 = new Customer("Arya", 22, "Maninagr", "Valtech");
//		Customer c3 = new Customer("Mayur", 22, "Bapunagar", "XYZ");
//		Customer c4 = new Customer("Virat", 36, "Delhi", "Dubai");
//		c4.setCusStatus(CustomerStatus.DISABLE);
		
		
//		Customer c5 = new Customer("MSD", 41, "Ranchi", "Chennai");
//		c5.setCusStatus(CustomerStatus.ENABLE);
//		csh.save(c5);
//		
//		
//		csh.save(c);
//		csh.save(c1);
//		csh.save(c2);
//		csh.save(c3);
		
		
		
//		LineItem li = new LineItem();
//		li.setItem(is.get(1));
//		li.setQuantity(100);
//		
//		
//		
//		LineItem li1 = new LineItem();
//		li1.setItem(is.get(6));
//		li1.setQuantity(50);
//		
		
//		LineItem li2 = new LineItem();
//		li2.setItem(is.get(3));
//		li2.setQuantity(25);
//		Customer c9 = cs.get(5);
//		System.out.println(c9.getCusStatus()+";;;;;;;;;;;;;;;;");
		
		
//		Order o = new Order();
//		o.setCustomer(cs.get(5));
//		o.addLineItem(li);
//		o.addLineItem(li1);
////		o.addLineItem(li2);
//		o.setStatus(Status.IN_WAREHOUSE);
		
		
		
		
		
		
//		os.save(o);
//		
		Customer c7 = new Customer("Sheryas", 41, "Mumbai", "Dubai");
		c7.setCusStatus(CustomerStatus.DISABLE);
		csh.save(c7);
		
		
		
		
//		System.out.println(cs.getClass().getName());
//		Customer customer=cs.get(1);
//		customer.setAge(25);
//		cs.update(customer);
//		cs.save(new Customer("Raj", 23, "GIFT", "AD"));
//		cs.update(new Customer("Rushab", 24, "Venus", "Valtech").setCusId(2));
		
//		cs.update(cs.get(1).setAge(26));
//		cs.getAll().forEach(e -> System.out.println(e));
//		cs.get(1);
		
		
//		ItemHibernateDAOImpl is = ctx.getBean(ItemHibernateDAOImpl.class);
//		System.out.println(is.getClass().getName());
		
//		is.save(new Item("Computer", "PC", 4, 5, 7));
//		is.get(1);
//		is.getAll().forEach(e -> System.out.println(e));
		
//		Item i = is.get(1);
//		i.setMaxQuantity(10);
//		is.update(i);
		
//		CustomerDAO csh = ctx.getBean(CustomerHibernateDAOImpl.class);
//		OrderHibernateDAO oh = ctx.getBean(OrderHibernateDAOImpl.class);
//		ItemDAO idao = ctx.getBean(ItemHibernateDAOImpl.class);
//		LineItemHibernateDAO lid = ctx.getBean(LineItemHibernateDAOImpl.class);
//		
//		Customer c = csh.get(1);
//		System.out.println("================"+ c);
//		Order o = new Order();
		
//		o.setCustomer(c);
//		o.setStatus(Status.IN_WAREHOUSE);
//		
//		Item i = new Item();
//		
//		LineItem li = new LineItem();
//		li.setQuantity(5);
//		li.setOrder(o);
//		li.setItem(i);
//		o.addLineItem(li);
//		
//		System.out.println("=============" +o.getOrderId());
//		
//		oh.save(o);
//		
//		
//		i.setDescription("asasasas");
//		i.setMaxQuantity(20);
//		i.setName("sdsd");
//		i.setQuantity(10);
//		i.setReorderQuantity(5);
//		
//		idao.save(i);
//		
//		
//		
//		
//		lid.save(li);
		
		ctx.close();
		
	}

}
