package com.liuxiu.tools;


import com.liuxiu.tools.base.ITest;
import org.springframework.stereotype.Component;

@Component
public class DynamicCompile extends ITest {

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