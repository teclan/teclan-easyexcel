package com.teclan.easyexcel.handler;

import java.util.List;
import java.util.Map;

public interface Handler {

	public void handle(List<?> list) ;
	
	public Long getCount();
	
	public String[] getHeaders();
	
}
