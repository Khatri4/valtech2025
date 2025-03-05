package spring.assignment;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LineItemHibernateDAOImpl implements LineItemHibernateDAO {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println(sessionFactory);
	}

	@Override
	public void save(LineItem li) {
		new HibernateTemplate(sessionFactory).save(li);
	}

	@Override
	public void update(LineItem li) {
		new HibernateTemplate(sessionFactory).update(li);
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
	}

	@Override
	public LineItem get(int id) {
		return new HibernateTemplate(sessionFactory).load(LineItem.class, id);
	}

	@Override
	public List<LineItem> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LineItems li");
	}
}
