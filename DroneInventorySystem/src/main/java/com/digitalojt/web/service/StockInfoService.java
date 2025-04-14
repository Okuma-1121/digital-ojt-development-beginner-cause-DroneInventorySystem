package com.digitalojt.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalojt.web.entity.StockInfo;
import com.digitalojt.web.repository.StockInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 在庫一覧画面のサービスクラス
 *
 * @author Okuma
 * 
 */
@Service
@RequiredArgsConstructor
public class StockInfoService {

	/** センター情報テーブル リポジトリー */
	private final StockInfoRepository repository;

	/**
	 * 在庫センター情報を全件検索で取得（削除フラグ「0」のみ)
	 * 
	 * @return
	 */
	public List<StockInfo> getStockInfoData() {
		return repository.findAllActive();
	}

	/**
	 * 引数に合致する在庫情報を取得
	 * 
	 * @param categoryId
	 * @param name 
	 * @param amount
	 * @param range
	 * @return 
	 * 
	 */
	public List<StockInfo> getStockInfoData(Integer categoryId, String name, Integer amount, String range) {
		return repository.findByCategoryInfoCategoryIdAndNameAndAmount(categoryId, name, amount, range);
	}

	/**
	 * 引数に合致する在庫情報を取得
	 * 
	 * @param centerId
	 * @return 
	 * 
	 */
	public List<StockInfo> getStockInfoData(Integer centerId) {
		return repository.findByCenterId(centerId);
	}
}