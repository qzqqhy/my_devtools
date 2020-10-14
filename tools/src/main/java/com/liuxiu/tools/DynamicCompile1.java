package com.liuxiu.tools;


import com.liuxiu.tools.base.ITest;
import org.springframework.stereotype.Component;

@Component
public class DynamicCompile1 extends ITest {

	@Override
	public String getPi() {
		return "sss ß";
	}

	@Override
	public String getBeanName() {
		return "动态编译1";
	}

	@Override
	public String getBeanId() {
		return "dynamicCompile1";
	}

}