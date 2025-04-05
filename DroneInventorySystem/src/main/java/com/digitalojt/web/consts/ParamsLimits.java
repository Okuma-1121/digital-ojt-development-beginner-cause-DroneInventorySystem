package com.digitalojt.web.consts;

/**
 * 制限の定数クラス
 *
 * @author Okuma
 * 
 * 
 */
public class ParamsLimits {

	// 分類名の最大文字数
	public static final int CATEGORY_MAX_LENGTH = 15;

	// 在庫センター名の最大文字数
	public static final int CENTER_INFO_MAX_LENGTH = 20;

	// 在庫名の最大文字数
	public static final int STOCK_NAME_MAX_LENGTH = 20;

	// 在庫数の最大数
	public static final int STOCK_MAX_NUM = 9999;

	// 在庫数の最小数
	public static final int STOCK_MIN_NUM = 1;

	// 分類IDの最大数
	public static final int CATEGORYID_MAX_NUM = 10;

	// 分類IDの最小数
	public static final int CATEGORYID_MIN_NUM = 1;

	// 住所の最大文字数
	public static final int ADDRESS_MAX_LENGTH = 15;

	//管理者名の最大文字数
	public static final int MANAGER_NAME_MAX_LENGTH = 20;

	//最大保管容量（m³）の最小数
	public static final int MIN_STORAGE_CAPACITY = 1;

	//最大保管容量（m³）の最大数
	public static final int MAX_STORAGE_CAPACITY = 9999;

	//現在保管容量（m³）の最小数
	public static final int MIN__CURRENT_STORAGE_CAPACITY = 0;

	//備考の最大文字数
	public static final int NOTES_MAX_LENGTH = 100;

	//センターIDの数値
	public static final String CENTER_ID_NUMERIC = "/^[0-9]+$/";

	// 郵便番号のフォーマット
	public static final String POST_CODE_FORMAT = "^[0-9]{3}-[0-9]{4}$";

	// 電話番号のフォーマット
	public static final String PHONE_NUMBER_FORMAT = "^[0-9]{2,4}-[0-9]{2,4}-[0-9]{4}$";

}
