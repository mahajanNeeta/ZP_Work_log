package com.avics.framework.data;

public class TestScript {
	String testId;
	String desc;
	String keyword;
	boolean skip;
    String param1;
    String param2;
    String param3;
	public TestScript(String testId, String desc, String keyword, boolean skip, String param1, String param2,String param3) {
		super();
		this.testId = testId;
		this.desc = desc;
		this.keyword = keyword;
		this.skip = skip;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 =param3;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public TestScript(String testId, String desc, String keyword, boolean skip) {
		super();
		this.testId = testId;
		this.desc = desc;
		this.keyword = keyword;
		this.skip = skip;
	}

	public TestScript() {
		// TODO Auto-generated constructor stub
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}



}
