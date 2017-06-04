package service;

import java.util.ArrayList;

import domain.GoodsVo;

public interface CartService {
	public void addToCart(GoodsVo g, int quantity);
	public void update(Integer goodsId, int quantity);
	public void delete(Integer goodsId);
	public ArrayList getCart();
	public void setCart(ArrayList cart);
}
