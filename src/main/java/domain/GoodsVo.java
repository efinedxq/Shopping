package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="goods")
public class GoodsVo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="goodsid")
	private Integer goodsid;
	private String goodsname;
	private Float price;
	private Integer cnt;
	
	@OneToMany(targetEntity=Item.class)
//	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "goods_items",
	   joinColumns = @JoinColumn(name = "goodsId", referencedColumnName = "goodsid"), 
	   inverseJoinColumns = @JoinColumn(name = "itemId", referencedColumnName = "id",unique=true))
	private Set<Item> soldItem = new HashSet<>();
	
	
	public GoodsVo(){
	}
    public GoodsVo(String goodsname,Float price){
    	this.goodsname = goodsname;
    	this.price = price;
    }
	public GoodsVo(Integer goodsid, String goodsname,Float price){
		this.goodsid = goodsid;
		this.goodsname = goodsname;
    	this.price = price;
	}
	
	
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Set<Item> getSoldItem() {
		return soldItem;
	}
	public void setSoldItem(Set<Item> soldItem) {
		this.soldItem = soldItem;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	
}
