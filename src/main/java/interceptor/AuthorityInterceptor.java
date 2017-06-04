package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;



public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		
		String user = (String)session.get("user");
 
		if(user != null && user.equals("qtech")){
			return invocation.invoke();
			
		}else{
			String actionName = ctx.getName();
			if(!actionName.equals("userLogin")){
				ctx.put("tip","您还没有登录，请使用qtech登录！");	
			}
			
			return Action.LOGIN;
		}
		
	}

}
