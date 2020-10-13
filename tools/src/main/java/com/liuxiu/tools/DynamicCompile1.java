package com.liuxiu.tools;


import com.liuxiu.tools.base.ITest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DynamicCompile1 extends ITest {

	@PostConstruct
	public void init(){
		cacheMap.put("dynamicCompile1", DynamicCompile1.class);
		System.out.println(1111);
	}

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