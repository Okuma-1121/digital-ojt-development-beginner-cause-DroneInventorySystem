package com.digitalojt.web.consts;
/**
 * 検索範囲の条件(以上・以下） Enumクラス
 * 
 * @author Okuma
 */
public enum RangeType {

	OVER("以上"),
	UNDER("以下");

    private final String type;

    RangeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
