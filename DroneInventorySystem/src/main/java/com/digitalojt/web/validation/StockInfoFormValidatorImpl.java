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

		// 最大文字数
		int MAX_LENGTH = SearchParamsLimits.STOCK_NAME_MAX_LENGTH;
		// 分類IDの最大数
		int CATEGORYID_MAX_NUM = SearchParamsLimits.CATEGORYID_MAX_NUM;
		// 在庫の最大数
		int STOCK_MAX_NUM = SearchParamsLimits.STOCK_MAX_NUM;

		//分類IDのチェック		
		if (form.getCategoryId() != null) {

			//0より大きく最大数より小さいかチェック
			if (0 > form.getCategoryId() || CATEGORYID_MAX_NUM < form.getCategoryId()) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.CATEGORY_ID_MAXIMUM_LIMIT_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;

			}
		}

		//在庫名のチェック
		if (form.getName() != null) {

			// 不正文字列チェック
			if (ParmCheckUtil.isParameterInvalid(form.getName())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;
			}

			// 文字数チェック
			if (form.getName().length() > MAX_LENGTH) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.STOCK_NAME_LENGTH_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;
			}
		}

		//個数のチェック
		if (form.getAmount() != null) {

			//0以上最大数以下かチェック
			if (0 < form.getAmount() && STOCK_MAX_NUM >= form.getAmount()) {
				//0以上最大数以下の場合正常

			} else {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.STOCK_NUM_INPUT_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;
			}
		}

		//個数の範囲条件のチェック
		if (form.getRange() != null) {

			// 不正文字列チェック
			if (ParmCheckUtil.isParameterInvalid(form.getRange())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;
			}
		}

		//入力フィールドが全て空かをチェック
		boolean allFieldsEmpty = form.getCategoryId() == null &&
				StringUtils.isEmpty(form.getName()) &&
				form.getAmount() == null;

		if (allFieldsEmpty) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorMessage.ALL_FIELDS_EMPTY_ERROR_MESSAGE)
					.addConstraintViolation();
			return false;
		}

		//その他のバリデーションに問題なければtrueを返す
		return true;
	}
}
