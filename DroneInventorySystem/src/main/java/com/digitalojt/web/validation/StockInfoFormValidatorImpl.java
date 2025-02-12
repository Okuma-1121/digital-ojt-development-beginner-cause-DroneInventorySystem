package com.digitalojt.web.validation;

import org.thymeleaf.util.StringUtils;

import com.digitalojt.web.consts.ErrorMessage;
import com.digitalojt.web.consts.SearchParamsLimits;
import com.digitalojt.web.form.StockInfoForm;
import com.digitalojt.web.util.ParmCheckUtil;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 在庫一覧画面のバリデーションチェック 実装クラス
 * 
 * @author Okuma
 */
public class StockInfoFormValidatorImpl implements ConstraintValidator<StockInfoFormValidator, StockInfoForm> {
	/**
	 * バリデーションチェック
	 */
	@Override
	public boolean isValid(StockInfoForm form, ConstraintValidatorContext context) {

		// 在庫名の最大文字数
		int MAX_LENGTH = SearchParamsLimits.STOCK_NAME_MAX_LENGTH;
		// 分類IDの最大数
		int CATEGORYID_MAX_NUM = SearchParamsLimits.CATEGORYID_MAX_NUM;
		// 分類IDの最小数
		int CATEGORYID_MIN_NUM = SearchParamsLimits.CATEGORYID_MIN_NUM;
		// 在庫の最大数
		int STOCK_MAX_NUM = SearchParamsLimits.STOCK_MAX_NUM;
		// 在庫の最大数
		int STOCK_MIN_NUM = SearchParamsLimits.STOCK_MIN_NUM;

		//分類IDのチェック		
		if (form.getCategoryId() != null) {

			//最小数以上かつ最大数以下かチェック
			if (CATEGORYID_MIN_NUM > form.getCategoryId() || CATEGORYID_MAX_NUM < form.getCategoryId()) {
				setErrorMessage(context, ErrorMessage.CATEGORY_ID_MAXIMUM_LIMIT_ERROR_MESSAGE);
				return false;
			}
		}

		//在庫名のチェック
		if (form.getName() != null) {

			// 不正文字列チェック
			if (ParmCheckUtil.isParameterInvalid(form.getName())) {
				setErrorMessage(context, ErrorMessage.INVALID_INPUT_ERROR_MESSAGE);
				return false;
			}

			// 文字数チェック
			if (form.getName().length() > MAX_LENGTH) {
				setErrorMessage(context, ErrorMessage.STOCK_NAME_LENGTH_ERROR_MESSAGE);
				return false;
			}
		}

		//個数のチェック
		if (form.getAmount() != null) {

			//最小数以上かつ最大数以下かチェック
			if (STOCK_MIN_NUM > form.getAmount() || STOCK_MAX_NUM < form.getAmount()) {
				setErrorMessage(context, ErrorMessage.STOCK_NUM_INPUT_ERROR_MESSAGE);
				return false;
			}
		}

		//個数の検索の条件(以上・以下）のチェック
		if (form.getRange() != null) {

			// 不正文字列チェック
			if (ParmCheckUtil.isParameterInvalid(form.getRange())) {
				setErrorMessage(context, ErrorMessage.INVALID_INPUT_ERROR_MESSAGE);
				return false;
			}

		}

		//入力フィールドが全て空かをチェック

		if (areAllFieldsEmpty(form)) {
			setErrorMessage(context, ErrorMessage.ALL_FIELDS_EMPTY_ERROR_MESSAGE);
			return false;
		}

		//その他のバリデーションに問題なければtrueを返す
		return true;
	}

	/**	
	 * 入力フィールド(分類・名称・個数)が全て空かをチェック
	 * 
	 * @param form
	 * @return boolean
	 * 
	 */
	private boolean areAllFieldsEmpty(StockInfoForm form) {
		return form.getCategoryId() == null && StringUtils.isEmpty(form.getName()) && form.getAmount() == null;
	}

	/**	
	 * エラーメッセージを設定
	 * 
	 * @param context
	 * @param errorMessage
	 * 
	 */
	private void setErrorMessage(ConstraintValidatorContext context, String errorMessage) {
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(errorMessage)
				.addConstraintViolation();
	}
}
