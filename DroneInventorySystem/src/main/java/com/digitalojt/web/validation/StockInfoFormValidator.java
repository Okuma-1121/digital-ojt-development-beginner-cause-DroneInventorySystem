package com.digitalojt.web.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

/**
 * 在庫一覧画面のバリデーションチェック インターフェース
 * 
 * @author Okuma
 */
@Constraint(validatedBy = StockInfoFormValidatorImpl.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface StockInfoFormValidator {

}
