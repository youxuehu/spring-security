package com.gq.security.core.properties;
 

public class BorrowProperties {

	private String loginPage = "/mySignIn.html";
	
	private LoginType loginType = LoginType.JSON;
	
	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
	
}
