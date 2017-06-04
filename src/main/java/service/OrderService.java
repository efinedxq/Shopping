package service;

import java.util.List;

import cn.edu.qtech.s2shbase.core.service.BaseService;
import domain.Item;
import domain.Order;

public interface OrderService {
	public void deleteOrder(Integer id);

	public void addOrder(List<Item> itemList);

	public List<Order> queryOrder();
}
