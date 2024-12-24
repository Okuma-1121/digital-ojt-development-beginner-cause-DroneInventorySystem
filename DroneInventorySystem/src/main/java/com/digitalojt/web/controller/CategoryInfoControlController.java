package com.digitalojt.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.digitalojt.web.consts.CategoryConsts;
import com.digitalojt.web.consts.UrlConsts;
import com.digitalojt.web.entity.CategoryInfo;
import com.digitalojt.web.form.CategoryInfoControlForm;
import com.digitalojt.web.service.CategoryInfoService;
import com.digitalojt.web.util.MessageManager;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * 分類情報管理画面のコントローラークラス
 * 
 * @author Okuma
 * 
 */
@Controller
@RequiredArgsConstructor
public class CategoryInfoControlController {

	/** 分類情報 サービス */
	private final CategoryInfoService categoryInfoService;

	/** メッセージソース */
	private final MessageSource messageSource;

	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConsts.CATEGORY_INFO_CONTROL)
	public String index(Model model) {

		/*		// 分類名取得を定数クラス→DB取得に変更のためコメント化
				// 分類 Enumをリストに変換
				List<CategoryConsts> categoryConsts = Arrays.asList(CategoryConsts.values());
				// 分類一覧情報をセット
				model.addAttribute("categoryConsts", categoryConsts);
		*/

		try {
			// 分類情報画面に表示するデータを取得
			List<CategoryInfo> categoryInfoList = categoryInfoService.getCategoryInfoData();
			// 分類一覧情報をセット
			model.addAttribute("categoryInfoList", categoryInfoList);
		} catch (RuntimeException e) {
			// エラーメッセージをセット
			String errorMsg = "分類情報を取得できませんでした。";
			model.addAttribute("errorMsg", errorMsg);
		}

		return "admin/categoryInfoControl/index";
	}

	/**
	 * 検索結果表示
	 * 
	 * @param model
	 * @param form
	 * @return
	 */
	@PostMapping(UrlConsts.CATEGORY_INFO_CONTROL_SEARCH)
	public String search(Model model, @Valid CategoryInfoControlForm form, BindingResult bindingResult) {

		// Valid項目チェック
		if (bindingResult.hasErrors()) {

			// エラーメッセージをプロパティファイルから取得
			String errorMsg = MessageManager.getMessage(messageSource,
					bindingResult.getGlobalError().getDefaultMessage());
			model.addAttribute("errorMsg", errorMsg);

			// 分類 Enumをリストに変換
			List<CategoryConsts> categoryConsts = Arrays.asList(CategoryConsts.values());

			// 分類一覧情報をセット
			model.addAttribute("categoryConsts", categoryConsts);

			return "admin/categoryInfoControl/index";
		}

		// 分類情報管理画面に表示するデータを取得
		List<CategoryConsts> categoryConsts = form.getCategoryResearchResult(form.getCategory());

		// 分類一覧情報をセット
		model.addAttribute("categoryConsts", categoryConsts);

		return "admin/categoryInfoControl/index";
	}

}
