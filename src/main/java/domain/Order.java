package domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder.In;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	Date createT;
	@OneToMany(targetEntity=Item.class)
	@JoinTable(name = "order_items",
	   joinColumns = @JoinColumn(name = "orderId", referencedColumnName = "id"), 
	   inverseJoinColumns = @JoinColumn(name = "itemId", referencedColumnName = "id",unique=true))
	private Set<Item> items = new HashSet<>();
	
	
	public Order(){
	}
    public Order(Date createT){
    	this.createT = createT;
    }
    public Order(Integer id, Date createT){
    	this.id = id;
    	this.createT = createT;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateT() {
		return createT;
	}
	public void setCreateT(Date createT) {
		this.createT = createT;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
