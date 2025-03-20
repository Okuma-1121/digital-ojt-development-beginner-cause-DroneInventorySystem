package com.digitalojt.web.form;

import java.util.ArrayList;
import java.util.List;

import com.digitalojt.web.consts.CategoryConsts;
import com.digitalojt.web.validation.CategoryInfoControlFormValidator;

import lombok.Data;

/**
 * 分類情報管理画面のフォームクラス
 * 
 * @author Okuma
 *
 */
@Data
@CategoryInfoControlFormValidator
public class CategoryInfoControlForm {

	/**
	 * 分類名
	 */
	private String category;

	/**
	 * 引数に合致する分類情報を取得
	 * 
	 * @param category
	 * @return
	 */
	public List<CategoryConsts> getCategoryResearchResult(String category) {

		List<CategoryConsts> categoryResearchResult = new ArrayList<>();
		for (CategoryConsts CategoryConsts : CategoryConsts.values()) {
			if (CategoryConsts.getCategory().equals(category)) {
				categoryResearchResult.add(CategoryConsts);
			}
		}
		return categoryResearchResult;
	}

}
