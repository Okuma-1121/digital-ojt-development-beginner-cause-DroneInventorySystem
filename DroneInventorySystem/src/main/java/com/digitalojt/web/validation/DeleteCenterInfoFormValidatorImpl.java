package com.digitalojt.web.validation;

import com.digitalojt.web.consts.ErrorMessage;
import com.digitalojt.web.form.DeleteCenterInfoForm;
import com.digitalojt.web.service.StockInfoService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

/**
 * 在庫センター情報 削除画面のバリデーションチェック 実装クラス
 * 
 * @author Okuma
 */
@RequiredArgsConstructor
public class DeleteCenterInfoFormValidatorImpl
		implements ConstraintValidator<DeleteCenterInfoFormValidator, DeleteCenterInfoForm> {

	/** センター情報テーブル サービス */
	private final StockInfoService stockInfoService;

	/**
	 * バリデーションチェック
	 */
	@Override
	public boolean isValid(DeleteCenterInfoForm form, ConstraintValidatorContext context) {

		//在庫一覧情報に紐付けがあるかチェック
		if (!stockInfoService.getStockInfoData(form.getCenterId()).isEmpty()) {
			setErrorMessage(context, ErrorMessage.LINKED_CENTER_ID);
			return false;
		}

		// その他のバリデーションに問題なければtrueを返す
		return true;
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