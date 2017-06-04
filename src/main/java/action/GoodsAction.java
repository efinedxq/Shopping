package action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.GoodsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.GoodsVo;
import domain.Item;

@Scope("prototype")
@Controller("goodsAction")
@Namespace("/")
public class GoodsAction extends ActionSupport implements ModelDriven<GoodsVo>{
	
	@Resource(name="goodsService")
	GoodsService goodsService;
	
	private int pageNo = 1;
	
	private GoodsVo dto ;
	
	private Integer goodsId;
	
	@Action(value="getAllGoods",
			results={@Result(name="success",location="/WEB-INF/content/goodslist.jsp")})
	public String findAllGoods() {
		List<GoodsVo> goods = goodsService.getGoodsByPage(pageNo);
		long pageCount = goodsService.getPageCount();
		ActionContext ctx = ActionContext.getContext();
		ctx.put("goodslist", goods);
		ctx.put("pageNo", pageNo);
		ctx.put("pageCount", pageCount);
		return SUCCESS;
	}
	@Action(value="showAddGoods",
			results={@Result(name="success",location="/WEB-INF/content/goodsDetail.jsp")})
	public String showAddGoods() {
		return SUCCESS;
	}
	@Action(value="addGoods",
			results={@Result(name="success",type="chain",location="getAllGoods")})
	public String addGoods() {
		System.out.println("goodsName:"+dto.getGoodsname());
		String s = dto.getGoodsname();
		try {
			s = new String(s.getBytes("utf-8"),"utf-8");
			System.out.println("goodsName:"+s);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setGoodsname(s);
		goodsService.save(dto);
		return SUCCESS;
	}
	@Action(value="showModifyGoods",
			results={@Result(name="success",location="/WEB-INF/content/modifyGoods.jsp")})
	public String showModifyGoods() {
		System.out.println("goodsId"+goodsId);
		dto = goodsService.getGoodsById(goodsId);
		return SUCCESS;
	}
	@Action(value="modifyGoodsDetail",
			results={@Result(name="success",type="chain",location="getAllGoods")})
	public String modifyGoods() {
		goodsService.update(dto);
		return SUCCESS;
	}
	@Action(value="deleteGoodsById",
			results={@Result(name="success",type="chain",location="getAllGoods")})
	public String deleteGoods() {
		goodsService.deleteById(goodsId);
		return SUCCESS;
	}
	
	
	
	public GoodsVo getModel() {
		if(dto == null)
			dto = new GoodsVo();
		return dto;
	}
	public GoodsVo getDto() {
		return dto;
	}
	public void setDto(GoodsVo dto) {
		this.dto = dto;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}