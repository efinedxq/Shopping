package dao;

import java.util.List;

import cn.edu.qtech.s2shbase.core.dao.BaseDao;
import domain.Item;
import domain.Order;

public interface OrderDao{
    public void deleteOrder(Integer id);
    public void addOrder(List<Item> itemList);
    public List<Order> queryOrder();
}
