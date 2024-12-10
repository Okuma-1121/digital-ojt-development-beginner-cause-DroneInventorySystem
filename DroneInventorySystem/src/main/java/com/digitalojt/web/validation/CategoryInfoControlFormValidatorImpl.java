package com.digitalojt.web.validation;

import org.thymeleaf.util.StringUtils;

import com.digitalojt.web.consts.ErrorMessage;
import com.digitalojt.web.consts.Limits;
import com.digitalojt.web.form.CategoryInfoControlForm;
import com.digitalojt.web.util.ParmCheckUtil;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 分類情報管理画面のバリデーションチェック 実装クラス
 * 
 * @author Okuma
 */
public class CategoryInfoControlFormValidatorImpl implements ConstraintValidator<CategoryInfoControlFormValidator, CategoryInfoControlForm>  {

	/**
	 * バリデーションチェック
	 */
	@Override
	public boolean isValid(CategoryInfoControlForm form, ConstraintValidatorContext context) {

		// 最大文字数
		int MAX_LENGTH = Limits.CATEGORY_MAX_LENGTH;

		boolean allFieldsEmpty = StringUtils.isEmpty(form.getCategory());

		// 分類名フィールドが空かをチェック
		if (allFieldsEmpty) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorMessage.CATEGORY_FIELDS_EMPTY_ERROR_MESSAGE)
					.addConstraintViolation();
			return false;
		}

		// 分類名のチェック
		if (form.getCategory() != null) {

			// 不正文字列チェック
			if (ParmCheckUtil.isParameterInvalid(form.getCategory())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;
			}

			// 文字数チェック
			if (form.getCategory().length() > MAX_LENGTH) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(ErrorMessage.CATEGORY_LENGTH_ERROR_MESSAGE)
						.addConstraintViolation();
				return false;
			}
		}

		// その他のバリデーションに問題なければtrueを返す
		return true;
	}
}
