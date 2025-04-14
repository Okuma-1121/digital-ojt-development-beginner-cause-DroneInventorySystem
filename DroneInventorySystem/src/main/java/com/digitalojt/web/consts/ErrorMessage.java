package com.digitalojt.web.consts;

/**
 * エラーメッセージ定数クラス
 * 
 * @author Okuma
 *
 */
public class ErrorMessage {

	// ログイン情報の入力に誤りがあった場合に、出力するエラーメッセージのID
	public static final String LOGIN_WRONG_INPUT = "login.wrongInput";

	// すべての項目が空の場合のエラーメッセージ
	public static final String ALL_FIELDS_EMPTY_ERROR_MESSAGE = "allField.empty";

	// 空文字検索や予期しない入力に関するエラーメッセージ
	public static final String UNEXPECTED_INPUT_ERROR_MESSAGE = "unexpected.input";

	// 不正な文字列を使用した検索に関するエラーメッセージ
	public static final String INVALID_INPUT_ERROR_MESSAGE = "invalid.input";

	// 文字超過に関するエラーメッセージ
	public static final String CENTER_NAME_LENGTH_ERROR_MESSAGE = "centerName.length.wrongInput";

	// 文字超過に関するエラーメッセージ
	public static final String STOCK_NAME_LENGTH_ERROR_MESSAGE = "stockName.length.wrongInput";

	// 文字超過に関するエラーメッセージ
	public static final String CATEGORY_LENGTH_ERROR_MESSAGE = "category.length.wrongInput";

	// 分類名が空の場合のエラーメッセージ
	public static final String CATEGORY_FIELDS_EMPTY_ERROR_MESSAGE = "category.empty";

	// 分類IDが最大数以上の場合のエラーメッセージ
	public static final String CATEGORY_ID_MAXIMUM_LIMIT_ERROR_MESSAGE = "categoryId.maximum.limit";

	// 在庫数項目で不正な値を使用した検索に関するエラーメッセージ
	public static final String STOCK_NUM_INPUT_ERROR_MESSAGE = "stockNum.input";

	// 郵便番号に関するエラーメッセージ
	public static final String INVALID_POST_CODE_ERROR_MESSAGE = "invalid.postCode.Input";

	// 文字超過に関するエラーメッセージ（住所）
	public static final String ADDRESS_LENGTH_ERROR_MESSAGE = "address.length.wrongInput";

	// 電話番号に関するエラーメッセージ
	public static final String INVALID_PHONE_NUMBER_ERROR_MESSAGE = "invalid.phoneNumber.Input";

	// 文字超過に関するエラーメッセージ（管理者名）
	public static final String MANAGER_NAME_LENGTH_ERROR_MESSAGE = "managerName.length.wrongInput";

	// 最大保管容量（m³）に関するエラーメッセージ
	public static final String INVALID_MAX_STORAGE_CAPACITY_ERROR_MESSAGE = "invalid.maxStorageCapacity.Input";

	// 現在保管容量（m³）に関するエラーメッセージ
	public static final String INVALID_CURRENT_STORAGE_CAPACITY_ERROR_MESSAGE = "invalid.currentStorageCapacity.Input";

	// 現在保管容量（m³）に関するエラーメッセージ
	public static final String INVALID_CURRENT_STORAGE_CAPACITY_OVER_ERROR_MESSAGE = "invalid.currentStorageCapacity.over.Input";

	// 文字超過に関するエラーメッセージ（備考）
	public static final String NOTES_LENGTH_ERROR_MESSAGE = "notes.length.wrongInput";

	// 在庫情報に紐づくセンター情報を削除使用とした場合のエラーメッセージ
	public static final String LINKED_CENTER_ID = "linked.centerId";

	// センターIDに紐づくデータが空の場合のエラーメッセージ
	public static final String NULL_CENTER_ID_MESSAGE = "null.centerId";

	// DataAccessExceptionの場合のエラーメッセージ
	public static final String DATA_ACCESS_ERROR_MESSAGE = "dataAccess.exception";

	// NullPointerExceptionの場合のエラーメッセージ
	public static final String NULL_POINTER_ERROR_MESSAGE = "nullPointer.exception";

	// Exceptionの場合のエラーメッセージ
	public static final String ALL_ERROR_MESSAGE = "all.exception";
}