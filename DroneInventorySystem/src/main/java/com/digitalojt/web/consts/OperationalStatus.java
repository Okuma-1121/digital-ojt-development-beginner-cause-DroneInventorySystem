package com.digitalojt.web.consts;

/**
 * 稼働ステータス Enumクラス
 * 
 * @author Okuma
 */
public enum OperationalStatus {

	/**
	 * 0：稼働中
	 * 1：稼働停止
	 */
	ACTIVE(0), 
	INACTIVE(1);

	private final int type;

	OperationalStatus(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
