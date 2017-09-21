package com.zmm.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AuthUserInterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getApplication();
		Object user = session.get("userInfo");
		if (user == null) {
			return "backLogin";
		}
		System.out.println(user+"user");
		return arg0.invoke();
	}

}
