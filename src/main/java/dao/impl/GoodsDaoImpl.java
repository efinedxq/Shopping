package dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bean.GoodsRowMapper;
import dao.IGoodsDao;
import domain.GoodsVo;
import domain.Item;

@Repository("goodsDao")
public class GoodsDaoImpl implements IGoodsDao{
	

	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;

	
	@Override
	public long getPageCount() {
		long rst = 0;
		String hql = "select count(*) from GoodsVo";
		Session session = sessionFactory.getCurrentSession();
		List l = session.createQuery(hql).list();
		if (l != null && l.size() == 1 )
		{
			rst = (long) l.get(0);
			return (rst-1)/3+1;
		}
		return 0;
	}

	@Override
	public List getGoodsByPage(int pageNo) {
		List<GoodsVo> rst = new ArrayList<GoodsVo>();
		if(pageNo <= 0) pageNo = 1;
		int begin = (pageNo-1)*3;
		int size = 3;
		String hql = "from GoodsVo";
		Session session = sessionFactory.getCurrentSession();
		//分页
		rst = session.createQuery(hql)
			   .setFirstResult(begin)
			   .setMaxResults(size)
			   .list();
		for(GoodsVo g:rst){
			int sum = 0;
			for(Item item:g.getSoldItem()){
				sum += item.getQuantity();
			}
			g.setCnt(sum);
		}
		return rst;
	}

	@Override
	public GoodsVo getGoodsById(Integer goodsId) {
		GoodsVo g = null;
		String hql = "from GoodsVo where goodsid=:goodsid";
		Session session = sessionFactory.getCurrentSession();
		List l = session.createQuery(hql).setParameter("goodsid", goodsId).list();
		if(l!=null){
			return (GoodsVo) l.get(0);
		}
		return g;
	}

	@Override
	public void save(GoodsVo dto) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dto);
	}

	@Override
	public void deleteById(Integer goodsId) {
		//注意 ：冒号后边不能有空格
		String hql = "DELETE GoodsVo WHERE goodsid=:goodsId";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql).setParameter("goodsId", goodsId).executeUpdate();
	}

	@Override
	public void update(GoodsVo dto) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(dto);
		session.flush();
	}

	@Override
	public Set getItemsByGoodsId(Integer goodsId) {
		// TODO Auto-generated method stub
		GoodsVo g = null;
		String hql = "from GoodsVo where goodsid=:goodsid";
		Session session = sessionFactory.getCurrentSession();
		List l = session.createQuery(hql).setParameter("goodsid", goodsId).list();
		g = (GoodsVo) l.get(0);
//		List<Item> items = new ArrayList<>();
//		for(Item item:g.getSoldItem()){
//			items.add(item);
//		}
        return g.getSoldItem();
	}

}
