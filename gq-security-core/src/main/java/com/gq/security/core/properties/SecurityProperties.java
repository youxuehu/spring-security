package com.gq.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="gq.security")
public class SecurityProperties {
	private BorrowProperties borrow = new BorrowProperties();

	public BorrowProperties getBorrow() {
		return borrow;
	}

	public void setBorrow(BorrowProperties borrow) {
		this.borrow = borrow;
	}
	
	

}
