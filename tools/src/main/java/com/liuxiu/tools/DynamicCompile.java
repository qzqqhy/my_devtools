package com.liuxiu.tools;


import com.liuxiu.tools.base.ITest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DynamicCompile extends ITest {

	static {
		cacheMap.put("dynamicCompile", DynamicCompile.class);
	}
	@PostConstruct
	public void init() {
		System.out.println("DynamicCompile: " + 1111);
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