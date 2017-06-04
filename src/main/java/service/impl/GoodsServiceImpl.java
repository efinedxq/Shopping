package service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.GoodsService;
import dao.IGoodsDao;
import domain.GoodsVo;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Resource(name="goodsDao")
	IGoodsDao goodsDao;
	
	@Override
	public long getPageCount() {
		return goodsDao.getPageCount();
	}

	@Override
	public List getGoodsByPage(int pageNo) {
		return goodsDao.getGoodsByPage(pageNo);
	}

	@Override
	public GoodsVo getGoodsById(Integer goodsId) {
		return goodsDao.getGoodsById(goodsId);
	}

	@Override
	public void save(GoodsVo dto) {
		goodsDao.save(dto);
	}

	@Override
	public void deleteById(Integer goodsId) {
		goodsDao.deleteById(goodsId);
	}

	@Override
	public void update(GoodsVo dto) {
		goodsDao.update(dto);
	}

	@Override
	public Set getItemsByGoodsId(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.getItemsByGoodsId(goodsId);
	}

}
