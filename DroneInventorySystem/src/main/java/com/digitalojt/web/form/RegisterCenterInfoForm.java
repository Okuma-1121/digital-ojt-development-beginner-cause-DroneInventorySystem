package com.digitalojt.web.form;

import com.digitalojt.web.validation.RegisterCenterInfoFormValidator;

import lombok.Data;

/**
 * 在庫センター情報登録画面のフォームクラス
 * 
 * @author Okuma
 *
 */
@Data
@RegisterCenterInfoFormValidator
public class RegisterCenterInfoForm {

	/**
	 * センター名
	 */
	private String centerName;

	/**
	 * 郵便番号
	 */
	private String postCode;

	/**
	 * 住所
	 */
	private String address;

	/**
	 * 電話番号
	 */
	private String phoneNumber;

	/**
	 * 管理者名
	 */
	private String managerName;

	/**
	 * 稼働状況ステータス
	 */
	private int operationalStatus;

	/**
	 * 最大保管容量（m³）
	 */
	private String maxStorageCapacity;

	/**
	 * 現在保管容量（m³）
	 */
	private String currentStorageCapacity;

	/**
	 * 備考
	 */
	private String notes;

}