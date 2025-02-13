package com.digitalojt.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalojt.web.entity.CategoryInfo;
import com.digitalojt.web.repository.CategoryInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 分類情報画面のサービスクラス
 *
 * @author Okuma
 * 
 */
@Service
@RequiredArgsConstructor
public class CategoryInfoService {

	/** 分類情報テーブル リポジトリー */
	private final CategoryInfoRepository repository;

	/**
	 * 分類情報を全件検索で取得
	 * 
	 * @return
	 */
	public List<CategoryInfo> getCategoryInfoData() {

		return repository.findAll();
	}
	
	/**
	 * 分類情報をを全件検索で取得（削除フラグ「0」のみ)
	 * 
	 * @return
	 */
	public List<CategoryInfo> getCategoryInfoDataActive() {
		return repository.findAllActive();
	}
	
	/**
	 * 引数に合致する分類情報を取得
	 * 
	 * @param categoryName
	 * @return
	 */
	public List<CategoryInfo> getCategoryInfoData(String categoryName) {

		return repository.findByCategoryName(categoryName);
	}

}
