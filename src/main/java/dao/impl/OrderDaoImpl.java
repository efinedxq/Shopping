package dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import dao.OrderDao;
import domain.Item;
import domain.Order;
@Repository("orderDao")
public class OrderDaoImpl  implements OrderDao {
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Order where id =:id");
		System.out.println("orderId:"+id);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public void addOrder(List<Item> itemList) {
		// TODO Auto-generated method stub
		Order order = new Order();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = df.format(date);
		try {
			date = df.parse(time);
			order.setCreateT(date);
			Session session = sessionFactory.getCurrentSession();
			session.save(order);
			for(Item item:itemList){
				session.save(item);
				order.getItems().add(item);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> queryOrder() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Order> orderList = new ArrayList<>();
		orderList = session.createQuery("from Order").list();
		for(Order o:orderList){
			Set<Item> itemSet = o.getItems();
			for(Item i:itemSet){
				i.getGoods();
			}
		}
		return orderList;
	}

}
