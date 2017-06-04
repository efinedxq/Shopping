package action;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.CartService;
import service.GoodsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.GoodsVo;

@Scope("prototype")
@Controller("cartAction")
@Namespace("/")
public class CartAction extends ActionSupport {
	@Resource(name="goodsService")
	GoodsService goodsService;
	
	@Resource(name="cartService")
	CartService cartService;
	
	Integer goodsId;
	int quantity;

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	@Action(value="addToCart",
			results={@Result(name="success",location="/WEB-INF/content/userCart.jsp")})
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		ArrayList cart = (ArrayList)ctx.getSession().get("cart");
		
		GoodsVo goods = goodsService.getGoodsById(goodsId);
		cartService.setCart(cart);
		cartService.addToCart(goods, 1);
		cart = cartService.getCart();
		
		ctx.getSession().put("cart", cart);
		
		return SUCCESS;
	}
	
	@Action(value="modifyGoods",
			results={@Result(name="success",location="/WEB-INF/content/userCart.jsp")})
	public String modify(){
		ActionContext ctx = ActionContext.getContext();
		ArrayList cart = (ArrayList)ctx.getSession().get("cart");
		
		cartService.setCart(cart);
		cartService.update(goodsId, quantity);
		cart = cartService.getCart();
		
		ctx.getSession().put("cart", cart);
		
		return SUCCESS;
	}
	@Action(value="deleteGoods",
			results={@Result(name="success",location="/WEB-INF/content/userCart.jsp")})
	public String delete(){
		ActionContext ctx = ActionContext.getContext();
		ArrayList cart = (ArrayList)ctx.getSession().get("cart");
		
		cartService.setCart(cart);
		cartService.delete(goodsId);
		cart = cartService.getCart();
		
		ctx.getSession().put("cart", cart);

		return SUCCESS;
	}
	@Action(value="clearCart",
			results={@Result(name="success",location="/WEB-INF/content/userCart.jsp")})
	public String clear(){
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("cart", null);

		return SUCCESS;
	}

	
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}