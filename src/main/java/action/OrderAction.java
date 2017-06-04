package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Item;
import domain.Order;
import service.OrderService;

@Scope("prototype")
@Controller("orderAction")
@Namespace("/order")
public class OrderAction extends ActionSupport {

	@Resource(name="orderService")
	OrderService orderService;
	
	private Integer orderid;
	
	//返回一个订单列表，不需要参数
	@Action(value="queryOrder",
			results={@Result(name="success",location="/WEB-INF/content/orderList.jsp")})
	public String queryOrder(){
		List<Order> orderList = orderService.queryOrder();
		ActionContext.getContext().put("orderList", orderList);
		return SUCCESS;
	}
    //删除订单之后仍在订单列表中，需要订单id
	@Action(value = "deleteOrder", 
			results = { @Result(name="success",type="redirect",location="queryOrder")})
	public String deleteOrder(){
		orderService.deleteOrder(orderid);
		return SUCCESS;
	}
	//添加之后返回订单列表，需要items信息
	@Action(value = "addOrder", 
			results = { @Result(name="success",type="redirect",location="queryOrder")})
	public String addOrder(){
		List<Item> itemList = (List<Item>) ActionContext.getContext().getSession().get("cart");
		orderService.addOrder(itemList);
		return SUCCESS;
	}
}
