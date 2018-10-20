package com.gq.security.borrow.support;

public class SimpleResponse {
	
	public SimpleResponse(Object content) {
		super();
		this.content = content;
	}

	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
