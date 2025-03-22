package com.digitalojt.web.consts;
/**
 * 検索範囲の条件(以上・以下） Enumクラス
 * 
 * @author Okuma
 */
public enum OperationalStatus {

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