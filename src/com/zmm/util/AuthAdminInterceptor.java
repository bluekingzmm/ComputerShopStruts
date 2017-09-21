package com.zmm.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AuthAdminInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getApplication();
		Object admin = session.get("admin");
		if (admin == null) {
			System.out.println("quit");
			return "quit";
		}
		return arg0.invoke();
	}

}
