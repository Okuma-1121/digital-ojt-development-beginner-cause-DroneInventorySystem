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

	//	/**
	//	 * 引数に合致する在庫情報を取得
	//	 * 
	//	 * @param categoryId
	//	 * @param name 
	//	 * @param amount
	//	 * @param range
	//	 * @return 個数の範囲条件によって以下の検索結果を取得
	//	 * 　　　　・「以上」の場合の検索結果
	//	 * 　　　　・「以上」の場合の検索結果
	//	 * 　　　　・「以下」の場合の検索結果
	//	 * 　　　　・「以下」「以上」以外の場合「IllegalArgumentException」にする	
	//	 */
	//	public List<StockInfo> getStockInfoData(String categoryId, String name, Integer amount, String range) {
	//		if (range.equals("over")) {
	//			return repository.findByCategoryInfoCategoryIdAndNameAndAmountLessThanEqual(categoryId, name, amount);
	//		} else if (range.equals("under")) {
	//			return repository.findByCategoryInfoCategoryIdAndNameAndAmountGreaterThanEqual(categoryId, name, amount);
	//		} else {
	//			throw new IllegalArgumentException("Invalid range: " + range);
	//		}
	//	}
	/**
	 * 引数に合致する在庫情報を取得
	 * 
	 * @param categoryId
	 * @param name 
	 * @param amount
	 * @param range
	 * @return 個数の範囲と分類の条件によって以下の検索結果を取得
	 * 　　　　・「以上」かつ「すべて」の場合の検索結果
	 * 　　　　・「以上」かつ「すべて以外」」の場合の検索結果
	 * 　　　　・「以下」かつ「すべて」の場合の検索結果
	 * 　　　　・「以下」かつ「すべて以外」の場合の検索結果
	 * 　　　　・「以下」「以上」以外の場合「IllegalArgumentException」にする	
	 */
	public List<StockInfo> getStockInfoData(String categoryId, String name, Integer amount, String range) {
		//個数の範囲「以上」
		if ("OVER".equals(range)) {
			if (categoryId.equals("")) {
				return repository.findByNameAndAmountGreaterThanEqual(name, amount);
			} else {
				return repository.findByCategoryInfoCategoryIdAndNameAndAmountGreaterThanEqual(categoryId, name,
						amount);
			}
		}
		//個数の範囲「以下」
		if ("UNDER".equals(range)) {
			if (categoryId.equals("")) {
				return repository.findByNameAndAmountLessThanEqual(name, amount);
			} else {
				return repository.findByCategoryInfoCategoryIdAndNameAndAmountLessThanEqual(categoryId, name, amount);
			}
		}
		throw new IllegalArgumentException("Invalid range: " + range);
	}
}
