package com.digitalojt.web.form;

import com.digitalojt.web.validation.CenterInfoFormValidator;

import lombok.Data;

/**
 * 在庫一覧画面のフォームクラス
 * 
 * @author Okuma
 *
 */
@Data
@CenterInfoFormValidator
public class StockInfoForm {

	/**
	 * 分類ID
	 */
	private long categoryId;

	/**
	 * 在庫名
	 */
	private String Name;

	/**
	 * 個数
	 */
	private long amount;

	/**
	 * 個数の検索範囲
	 */
	private String range;

}
