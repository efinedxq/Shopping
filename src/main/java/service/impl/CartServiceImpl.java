package service.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import service.CartService;
import domain.GoodsVo;
import domain.Item;

@Service("cartService")
public class CartServiceImpl implements CartService {
	private ArrayList cart;

	public ArrayList getCart() {
		return cart;
	}

	public void setCart(ArrayList cart) {
		this.cart = cart;
	}

	@Override
	public void addToCart(GoodsVo g, int quantity) {
		if(cart == null){
			cart = new ArrayList();
			Item item = new Item(g,quantity);
			cart.add(item);
		}else{
			boolean find = false;

			Iterator it = cart.iterator();
			while(it.hasNext()){
				Item temp = (Item)it.next();
				Integer tGoodsId = temp.getGoods().getGoodsid();
				
				if(tGoodsId.equals(g.getGoodsid())){
					temp.setQuantity(temp.getQuantity()+quantity);
					find = true;
					break;
				}
			}//while
			if(!find){
				Item item = new Item(g,quantity);
				cart.add(item);
			}
		}//else
	}

	@Override
	public void update(Integer goodsId, int quantity) {
		Iterator it = cart.iterator();
		while(it.hasNext()){
			Item temp = (Item)it.next();
			Integer tgoodsId = temp.getGoods().getGoodsid();
			if(tgoodsId.equals(goodsId)){
				temp.setQuantity(quantity);
				break;
			}
		}
	}

	@Override
	public void delete(Integer goodsId) {
		Iterator it = cart.iterator();
		while(it.hasNext()){
			Item temp = (Item)it.next();
			Integer tgoodsId = temp.getGoods().getGoodsid();
			if(tgoodsId.equals(goodsId)){
				cart.remove(temp);
				break;
			}
		}
	}

}
