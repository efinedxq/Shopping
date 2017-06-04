package service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.qtech.s2shbase.core.dao.BaseDao;
import cn.edu.qtech.s2shbase.core.service.impl.BaseServiceImpl;
import dao.OrderDao;
import domain.Item;
import domain.Order;
import service.OrderService;
@Service("orderService")
public class OrderServiceImpl  implements OrderService {
  
	@Resource(name="orderDao")
	OrderDao orderDao;

	@Override
	public void deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		orderDao.deleteOrder(id);
	}

	@Override
	public void addOrder(List<Item> itemList) {
		// TODO Auto-generated method stub
		orderDao.addOrder(itemList);
	}

	@Override
	public List<Order> queryOrder() {
		// TODO Auto-generated method stub
		return orderDao.queryOrder();
	}
	
}
