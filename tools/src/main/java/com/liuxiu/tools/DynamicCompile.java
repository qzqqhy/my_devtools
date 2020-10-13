package com.liuxiu.tools;


import com.liuxiu.tools.base.ITest;

public class DynamicCompile extends ITest {

	static {
		cacheMap.put("dynamicCompile", DynamicCompile.class);
	}

	@Override
	public String getPi() {
		return String.valueOf(Math.PI);
	}

	@Override
	public String getBeanName() {
		return "动态编译";
	}

	@Override
	public String getBeanId() {
		return "dynamicCompile";
	}

}