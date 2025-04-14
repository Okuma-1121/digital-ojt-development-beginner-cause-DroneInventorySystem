package com.digitalojt.web.consts;

/**
 * URL定数クラス
 *
 * @author Okuma
 * 
 * 
 */
public class UrlConsts {

	// ログイン
	public static final String LOGIN = "/login";

	// 認証
	public static final String AUTHENTICATE = "/authenticate";

	// 在庫一覧画面
	public static final String STOCK_LIST = "/admin/stockList";

	// 在庫一覧画面　表示
	public static final String STOCK_LIST_INDEX = "/admin/stockList/index";

	// 在庫一覧画面 検索
	public static final String STOCK_LIST_SEARCH = "/admin/stockList/search";

	// 分類情報管理画面
	public static final String CATEGORY_INFO_CONTROL = "/admin/categoryInfoControl";

	// 分類情報管理画面 検索
	public static final String CATEGORY_INFO_CONTROL_SEARCH = "/admin/categoryInfoControl/search";

	// 在庫センター情報画面
	public static final String CENTER_INFO = "/admin/centerInfo";

	// 在庫センター情報画面　表示
	public static final String CENTER_INFO_INDEX = "/admin/centerInfo/index";

	// 在庫センター情報画面 検索
	public static final String CENTER_INFO_SEARCH = "/admin/centerInfo/search";

	// 在庫センター情報画面 登録
	public static final String CENTER_INFO_REGISTER = "/admin/centerInfo/register";

	// 在庫センター情報画面 登録完了
	public static final String CENTER_INFO_REGISTRATION_COMPLETED = "/admin/centerInfo/registrationCompleted";

	// 在庫センター情報画面 更新/削除画面　表示
	public static final String CENTER_INFO_DETAILS = "/admin/centerInfo/details/{centerId}";

	// 在庫センター情報画面 更新/削除画面
	public static final String CENTER_INFO_UPDATE = "/admin/centerInfo/update";

	// 在庫センター情報画面 削除確認画面　表示
	public static final String CENTER_INFO_DELETE_CONFIRM = "/admin/centerInfo/delete/{centerId}";

	// 在庫センター情報画面 削除確認画面
	public static final String CENTER_INFO_DELETE = "/admin/centerInfo/delete";

	// 認証不要画面
	public static final String[] NO_AUTHENTICATION = { LOGIN, AUTHENTICATE };

}