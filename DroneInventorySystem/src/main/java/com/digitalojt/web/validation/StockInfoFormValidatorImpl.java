package com.digitalojt.web.validation;

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
		
		
		
//		
//		//入力フィールドが全て空の場合
//		boolean allFieldsEmpty = form.getCategoryId() == 0 &&
//				StringUtils.isEmpty(form.getName()) &&
//				StringUtils.isEmpty(form.getAmount())&&
//				StringUtils.isEmpty(form.getRange());
//		// すべてのフィールドが空かをチェック
//		if (allFieldsEmpty) {
//			context.disableDefaultConstraintViolation();
//			context.buildConstraintViolationWithTemplate(ErrorMessage.ALL_FIELDS_EMPTY_ERROR_MESSAGE)
//					.addConstraintViolation();
//			return false;
//		}
		
		
		
		
//分類名のチェック		
		// 都道府県のチェック
		if (form.getCategoryId() != 0) {

			// 不正文字列チェック
			if (ParmCheckUtil.isParameterInvalid(form.getCategoryId())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;
			}
		}
		
		
		
//		
////在庫名のチェック
//		// センター名のチェック
//		if (form.getCenterName() != null) {
//
//			// 不正文字列チェック
//			if (ParmCheckUtil.isParameterInvalid(form.getCenterName())) {
//				context.disableDefaultConstraintViolation();
//				context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE)
//						.addConstraintViolation();
//				return false;
//			}
//
//			// 文字数チェック
//			/**
//			 *  TODO:Formクラスをシンプルにしたく、@Sizeを使わずこちらで桁数チェックを行いました。
//			 *  	 車輪の再発明なので、しないほうがいいでしょうか？
//			 */
//			if (form.getCenterName().length() > MAX_LENGTH) {
//				context.disableDefaultConstraintViolation();
//				context.buildConstraintViolationWithTemplate(ErrorMessage.CENTER_NAME_LENGTH_ERROR_MESSAGE)
//						.addConstraintViolation();
//				return false;
//			}
//		}
//
//		
//		
////個数のチェック
//		// 都道府県のチェック
//		if (form.getRegion() != null) {
//
//			// 不正文字列チェック
//			if (ParmCheckUtil.isParameterInvalid(form.getRegion())) {
//				context.disableDefaultConstraintViolation();
//				context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE)
//						.addConstraintViolation();
//				return false;
//			}
//		}
//		
//		
////個数の範囲条件のチェック
//				// 都道府県のチェック
//				if (form.getRegion() != null) {
//
//					// 不正文字列チェック
//					if (ParmCheckUtil.isParameterInvalid(form.getRegion())) {
//						context.disableDefaultConstraintViolation();
//						context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE)
//								.addConstraintViolation();
//						return false;
//					}
//				}
//
		// その他のバリデーションに問題なければtrueを返す
		return true;
	}
}
