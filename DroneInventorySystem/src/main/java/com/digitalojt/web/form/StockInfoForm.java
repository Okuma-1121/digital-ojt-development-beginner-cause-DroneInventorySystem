package com.digitalojt.web.form;

import com.digitalojt.web.validation.StockInfoFormValidator;

import lombok.Data;

/**
 * 在庫一覧画面のフォームクラス
 * 
 * @author Okuma
 *
 */
@Data
@StockInfoFormValidator
public class StockInfoForm {

	/**
	 * 分類ID
	 */
	private Integer categoryId;

	/**
	 * 在庫名
	 */
	private String name;

	/**
	 * 個数
	 */
	private Integer amount;

	/**
	 * 検索範囲の条件(以上・以下）
	 */
	private String range;

}
