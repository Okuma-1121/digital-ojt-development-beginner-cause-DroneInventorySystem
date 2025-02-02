package com.digitalojt.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalojt.web.entity.CategoryInfo;

/**
 * 分類情報テーブルリポジトリー
 *
 * @author Okuma
 * 
 */
@Repository
public interface CategoryInfoRepository extends JpaRepository<CategoryInfo, Integer> {

	/**
	 * 削除フラグが「0」の分類情報を取得
	 * 
	 * @return
	 */
	@Query("SELECT s FROM CategoryInfo s WHERE s.deleteFlag = '0' ORDER BY categoryId ASC")
	List<CategoryInfo> findAllActive();

	
	/**
	 * 引数に合致する分類情報を取得
	 * 
	 * @param categoryName
	 * @return paramで検索した結果
	 */
	@Query("SELECT s FROM CategoryInfo s WHERE s.categoryName = :categoryName")
	List<CategoryInfo> findByCategoryName(String categoryName);
}