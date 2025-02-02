package com.digitalojt.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.digitalojt.web.consts.RangeType;
import com.digitalojt.web.consts.UrlConsts;
import com.digitalojt.web.entity.CategoryInfo;
import com.digitalojt.web.entity.StockInfo;
import com.digitalojt.web.form.StockInfoForm;
import com.digitalojt.web.service.CategoryInfoService;
import com.digitalojt.web.service.StockInfoService;
import com.digitalojt.web.util.MessageManager;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * 在庫一覧画面コントローラークラス
 * 
 * @author Okuma
 *
 */
@Controller
@RequiredArgsConstructor
public class StockListController extends AbstractController {

	/** 在庫一覧 サービス */
	private final StockInfoService stockInfoService;

	/** 分類情報 サービス */
	private final CategoryInfoService categoryInfoService;

	/** メッセージソース */
	private final MessageSource messageSource;

	/**
	 * 初期表示
	 * 
	 * @return String(path)
	 */
	@GetMapping(UrlConsts.STOCK_LIST)
	public String index(Model model) {

		// 在庫一覧画面に表示するデータを取得
		List<StockInfo> stockInfoList = stockInfoService.getStockInfoData();

		// 画面表示用に情報リストをセット
		model.addAttribute("stockInfoList", stockInfoList);

		// プルダウン用に分類名を取得しリストに変換
		List<CategoryInfo> categoryInfoList = categoryInfoService.getCategoryInfoDataActive();

		// プルダウン用の分類一覧情報をセット
		model.addAttribute("categoryInfoList", categoryInfoList);

		// 検索範囲の条件Enumをリストに変換
		List<RangeType> rangeTypes = Arrays.asList(RangeType.values());

		// 検索範囲の条件プルダウン情報をセット
		model.addAttribute("rangeType", rangeTypes);

		return "admin/stockList/index";
	}

	/**	
	 * 検索結果表示
	 * 
	 * @param model
	 * @param form
	 * @return
	 */
	@PostMapping(UrlConsts.STOCK_LIST_SEARCH)
	public String search(Model model, @Valid StockInfoForm form, BindingResult bindingResult) {

		// Valid項目チェック
		if (bindingResult.hasErrors()) {

			// エラーメッセージをプロパティファイルから取得
			String errorMsg = MessageManager.getMessage(messageSource,
					bindingResult.getGlobalError().getDefaultMessage());
			model.addAttribute("errorMsg", errorMsg);

			// プルダウン用に分類名を取得しリストに変換
			List<CategoryInfo> categoryInfoList = categoryInfoService.getCategoryInfoData();

			// プルダウン用の分類一覧情報をセット
			model.addAttribute("categoryInfoList", categoryInfoList);

			// 検索範囲の条件Enumをリストに変換
			List<RangeType> rangeTypes = Arrays.asList(RangeType.values());

			// 検索範囲の条件プルダウン情報をセット
			model.addAttribute("rangeType", rangeTypes);

			return "admin/stockList/index";
		}

		// 在庫一覧画面に表示するデータを取得
		List<StockInfo> stockInfoList = stockInfoService.getStockInfoData(form.getCategoryId(), form.getName(),
				form.getAmount(), form.getRange());

		// 画面表示用に商品情報リストをセット
		model.addAttribute("stockInfoList", stockInfoList);

		// プルダウン用に分類名を取得しリストに変換
		List<CategoryInfo> categoryInfoList = categoryInfoService.getCategoryInfoData();

		// プルダウン用の分類一覧情報をセット
		model.addAttribute("categoryInfoList", categoryInfoList);

		// 検索範囲の条件Enumをリストに変換
		List<RangeType> rangeTypes = Arrays.asList(RangeType.values());

		// 検索範囲の条件プルダウン情報をセット
		model.addAttribute("rangeType", rangeTypes);

		return "admin/stockList/index";
	}
}
