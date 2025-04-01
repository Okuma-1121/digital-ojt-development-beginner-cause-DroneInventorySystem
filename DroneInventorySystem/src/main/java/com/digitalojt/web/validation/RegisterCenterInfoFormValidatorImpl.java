package com.digitalojt.web.validation;

import com.digitalojt.web.consts.ErrorMessage;
import com.digitalojt.web.consts.OperationalStatus;
import com.digitalojt.web.consts.ParamsLimits;
import com.digitalojt.web.form.RegisterCenterInfoForm;
import com.digitalojt.web.util.ParmCheckUtil;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 在庫センター情報登録画面のバリデーションチェック 実装クラス
 * 
 * @author Okuma
 */
public class RegisterCenterInfoFormValidatorImpl
		implements ConstraintValidator<RegisterCenterInfoFormValidator, RegisterCenterInfoForm> {

	/**
	 * バリデーションチェック
	 */
	@Override
	public boolean isValid(RegisterCenterInfoForm form, ConstraintValidatorContext context) {

		// すべてのフィールドが空かをチェック　　→不要　画面の機能で必須項目の入力をチェックしているため

		// センター名のチェック
		// 不正文字列チェック
		if (ParmCheckUtil.isParameterInvalid(form.getCenterName())) {
			setErrorMessage(context, ErrorMessage.INVALID_INPUT_ERROR_MESSAGE);
			return false;
		}

		// 文字数チェック
		if (form.getCenterName().length() > ParamsLimits.CENTER_INFO_MAX_LENGTH) {
			setErrorMessage(context, ErrorMessage.CENTER_NAME_LENGTH_ERROR_MESSAGE);
			return false;
		}

		// 郵便番号のチェック
		// 正規表現によるフォーマットチェック
		if (!form.getPostCode().matches(ParamsLimits.POST_CODE_FORMAT)) {
			setErrorMessage(context, ErrorMessage.INVALID_POST_CODE_ERROR_MESSAGE);
			return false;
		}

		// 住所のチェック
		// 不正文字列チェック
		if (ParmCheckUtil.isParameterInvalid(form.getAddress())) {
			setErrorMessage(context, ErrorMessage.INVALID_INPUT_ERROR_MESSAGE);
			return false;
		}

		// 文字数チェック
		if (form.getAddress().length() > ParamsLimits.ADDRESS_MAX_LENGTH) {
			setErrorMessage(context, ErrorMessage.ADDRESS_LENGTH_ERROR_MESSAGE);
			return false;
		}

		// 電話番号のチェック
		// 正規表現によるフォーマットチェック

		if (!form.getPhoneNumber().matches(ParamsLimits.PHONE_NUMBER_FORMAT)) {
			setErrorMessage(context, ErrorMessage.INVALID_PHONE_NUMBER_ERROR_MESSAGE);
			return false;
		}

		// 管理者名のチェック
		// 不正文字列チェック
		if (ParmCheckUtil.isParameterInvalid(form.getManagerName())) {
			setErrorMessage(context, ErrorMessage.INVALID_INPUT_ERROR_MESSAGE);
			return false;
		}

		// 文字数チェック
		if (form.getManagerName().length() > ParamsLimits.MANAGER_NAME_MAX_LENGTH) {
			setErrorMessage(context, ErrorMessage.MANAGER_NAME_LENGTH_ERROR_MESSAGE);
			return false;
		}

		// 稼働状況ステータスのチェック
		if (form.getOperationalStatus() != OperationalStatus.ACTIVE.getType() &&
				form.getOperationalStatus() != OperationalStatus.INACTIVE.getType()) {
			setErrorMessage(context, ErrorMessage.UNEXPECTED_INPUT_ERROR_MESSAGE);
			return false;
		}

		// 最大保管容量（m³）のチェック
		if (Integer.parseInt(form.getMaxStorageCapacity()) < ParamsLimits.MIN_STORAGE_CAPACITY
				|| Integer.parseInt(form.getMaxStorageCapacity()) > ParamsLimits.MAX_STORAGE_CAPACITY) {
			setErrorMessage(context, ErrorMessage.INVALID_MAX_STORAGE_CAPACITY_ERROR_MESSAGE);
			return false;
		}

		// 現在保管容量（m³）のチェック
		if (Integer.parseInt(form.getCurrentStorageCapacity()) < ParamsLimits.MIN__CURRENT_STORAGE_CAPACITY) {
			setErrorMessage(context, ErrorMessage.INVALID_CURRENT_STORAGE_CAPACITY_ERROR_MESSAGE);
			return false;
		} else if (Integer.parseInt(form.getCurrentStorageCapacity()) > Integer
				.parseInt(form.getMaxStorageCapacity())) {
			setErrorMessage(context, ErrorMessage.INVALID_CURRENT_STORAGE_CAPACITY_OVER_ERROR_MESSAGE);
			return false;
		}

		// 備考のチェック
		// 不正文字列チェック
		if (ParmCheckUtil.isParameterInvalid(form.getNotes())) {
			setErrorMessage(context, ErrorMessage.INVALID_INPUT_ERROR_MESSAGE);
			return false;
		}

		// 文字数チェック
		if (form.getNotes().length() > ParamsLimits.NOTES_MAX_LENGTH) {
			setErrorMessage(context, ErrorMessage.NOTES_LENGTH_ERROR_MESSAGE);
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