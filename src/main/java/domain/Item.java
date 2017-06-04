package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int quantity;
	@ManyToOne(targetEntity=GoodsVo.class)
	@JoinTable(name = "goods_items",
	   joinColumns = @JoinColumn(name = "itemId", referencedColumnName = "id",unique=true), 
	   inverseJoinColumns = @JoinColumn(name = "goodsId", referencedColumnName = "goodsid"))
	private GoodsVo goods;
	
	public Item(){
	}
    public Item(int quantity){
    	this.quantity = quantity;
    }
	public Item(GoodsVo g, int quantity){
		this.goods = g;
		this.quantity = quantity;
	}
	
	public GoodsVo getGoods() {
		return goods;
	}
	public void setGoods(GoodsVo goods) {
		this.goods = goods;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
