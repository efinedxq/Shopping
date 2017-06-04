package dao;

import java.util.List;
import java.util.Set;

import domain.GoodsVo;

public interface IGoodsDao {
	public long getPageCount();
	public List getGoodsByPage(int pageNo);
	public GoodsVo getGoodsById (Integer goodsId);
	public void save(GoodsVo dto);
	public void deleteById(Integer goodsId);
	public void update(GoodsVo dto);
	public Set getItemsByGoodsId(Integer goodsId);
}
