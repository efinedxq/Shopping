package bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import domain.GoodsVo;

public class GoodsRowMapper implements RowMapper<GoodsVo> {
	public GoodsVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		GoodsVo goods = new GoodsVo();
		goods.setGoodsid(Integer.getInteger(rs.getString("goodsid")));
		goods.setGoodsname(rs.getString("goodsname"));
		goods.setPrice(rs.getFloat("price"));

		return goods;
	}
}
