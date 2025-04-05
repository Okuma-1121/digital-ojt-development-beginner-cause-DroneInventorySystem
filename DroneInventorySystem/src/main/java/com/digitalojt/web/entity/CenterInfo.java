package com.digitalojt.web.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * センター情報Entity
 * 
 * @author Okuma
 *
 */
@Data
@Getter
@Setter
@Entity
public class CenterInfo {

	/**
	 * センターID
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int centerId;

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
	 * 未使用フラグ
	 */
	private int operationalStatus;

	/**
	 * 最大容量
	 */
	private String maxStorageCapacity;

	/**
	 * 現在容量
	 */
	private String currentStorageCapacity;

	/**
	 *　備考
	 */
	private String notes;

	/**
	 * 論理削除フラグ
	 */
	private String deleteFlag;

	/**
	 * 更新日
	 */
	private Timestamp updateDate;

	/**
	 * 登録日
	 */
	@Column(updatable = false)
	private Timestamp createDate;

	/**
	 * 新規登録時に呼び出されるメソッド
	 * エンティティの作成日時および更新日時を設定し、
	 * 削除フラグのデフォルト値を設定
	 */
	@PrePersist
	protected void onCreate() {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		createDate = now;
		updateDate = now;
		deleteFlag = "0"; // デフォルト値を設定
	}

	/**
	 * 更新時に呼び出されるメソッド
	 * エンティティの更新日時を現在の日時に設定
	 */
	@PreUpdate
	protected void onUpdate() {
		updateDate = new Timestamp(System.currentTimeMillis());
	}
}