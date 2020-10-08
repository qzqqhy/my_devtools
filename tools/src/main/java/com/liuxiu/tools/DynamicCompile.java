package com.liuxiu.tools;

import org.springframework.stereotype.Service;

@Service
public class DynamicCompile implements ITest {
	
	@Override
	public String getPi() {
		return String.valueOf(Math.PI);
	}
 
}