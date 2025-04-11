package com.digitalojt.web.consts;

/**
 * 削除フラグの Enumクラス
 * 
 * @author Okuma
 */
public enum DeleteFlag {

	NOT_DELETE("0"), DELETE("1");

	private final String type;

	DeleteFlag(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}