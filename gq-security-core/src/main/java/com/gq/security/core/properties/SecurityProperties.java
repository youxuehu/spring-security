package com.gq.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="gq.security")
public class SecurityProperties {
	private BorrowProperties borrow = new BorrowProperties();

	private ValidateCodeProperties code = new ValidateCodeProperties();

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	public BorrowProperties getBorrow() {
		return borrow;
	}

	public void setBorrow(BorrowProperties borrow) {
		this.borrow = borrow;
	}
	
	

}
