package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Controller("myLoginAction")
@Namespace("/")
public class MyLoginAction extends ActionSupport {
	String username;
	String password;
	
	@Action(value = "myLogin", 
			interceptorRefs={@InterceptorRef("defaultStack")},
			results = { @Result(name="success",type="redirect",location="getAllGoods",params={"pageNo","1"})})
	public String execute() {
		if(username.equals("qtech") &&  password.equals("java")){
			ActionContext.getContext().getSession().put("user", "qtech");
			return SUCCESS;
		}else{
			return LOGIN;
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}