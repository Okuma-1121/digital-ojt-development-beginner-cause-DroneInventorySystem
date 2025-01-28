package com.digitalojt.web.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * 在庫情報Entity
 * 
 * @author Okuma
 *
 */
@Data
@Entity
public class StockInfo {
	/**
	 * 在庫ID
	 */
	@Id
	private int stockId;

	/**
	 * 分類ID
	 */
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private CategoryInfo categoryInfo;

	/**
	 * 在庫名
	 */
	private String name;

	/**
	 * センターID
	 */
	@ManyToOne
	@JoinColumn(name = "centerId")
	private CenterInfo centerInfo;

	/**
	 * 説明
	 */
	private String description;

	/**
	 * 個数
	 */
	private long amount;

	/**
	 * 論理削除フラグ
	 */
	private int deleteFlag;

	/**
	 * 更新日
	 */
	private Timestamp updateDate;

	/**
	 * 登録日
	 */
	private Timestamp createDate;

	public String getCategoryName() {
		return categoryInfo != null ? categoryInfo.getCategoryName() : null;
	}

	public int getCategoryId() {
		return categoryInfo != null ? categoryInfo.getCategoryId() : null;
	}

	public String getCenterName() {
		return centerInfo != null ? centerInfo.getCenterName() : null;
	}
}
