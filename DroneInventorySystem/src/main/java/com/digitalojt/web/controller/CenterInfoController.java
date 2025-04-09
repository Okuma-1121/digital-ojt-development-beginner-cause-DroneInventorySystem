package com.digitalojt.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digitalojt.web.consts.ErrorMessage;
import com.digitalojt.web.consts.Region;
import com.digitalojt.web.consts.ResultMessage;
import com.digitalojt.web.consts.UrlConsts;
import com.digitalojt.web.entity.CenterInfo;
import com.digitalojt.web.form.CenterInfoForm;
import com.digitalojt.web.form.DeleteCenterInfoForm;
import com.digitalojt.web.form.RegisterCenterInfoForm;
import com.digitalojt.web.form.UpdateCenterInfoForm;
import com.digitalojt.web.service.CenterInfoService;
import com.digitalojt.web.util.MessageManager;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * 在庫センター情報画面のコントローラークラス
 * 
 * @author Okuma
 *
 */
@Controller
@RequiredArgsConstructor
public class CenterInfoController {

	/** センター情報 サービス */
	private final CenterInfoService centerInfoService;

	/** メッセージソース */
	private final MessageSource messageSource;

	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConsts.CENTER_INFO)
	public String index(Model model) {

		// 在庫センター情報画面に表示するデータを取得
		List<CenterInfo> centerInfoList = centerInfoService.getCenterInfoData();

		// 画面表示用に商品情報リストをセット
		model.addAttribute("centerInfoList", centerInfoList);

		// 都道府県Enumをリストに変換
		List<Region> regions = Arrays.asList(Region.values());

		// 都道府県プルダウン情報をセット
		model.addAttribute("regions", regions);

		return UrlConsts.CENTER_INFO_INDEX;
	}

	/**
	 * 検索結果表示
	 * 
	 * @param model
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(UrlConsts.CENTER_INFO_SEARCH)
	public String search(Model model, @Valid CenterInfoForm form, BindingResult bindingResult) {

		// Valid項目チェック
		if (bindingResult.hasErrors()) {

			// エラーメッセージをプロパティファイルから取得
			String errorMsg = MessageManager.getMessage(messageSource,
					bindingResult.getGlobalError().getDefaultMessage());
			model.addAttribute("errorMsg", errorMsg);

			// 都道府県Enumをリストに変換
			List<Region> regions = Arrays.asList(Region.values());

			// 都道府県プルダウン情報をセット
			model.addAttribute("regions", regions);

			return UrlConsts.CENTER_INFO_INDEX;
		}

		// 在庫センター情報画面に表示するデータを取得
		List<CenterInfo> centerInfoList = centerInfoService.getCenterInfoData(form.getCenterName(), form.getRegion());

		// 画面表示用に商品情報リストをセット
		model.addAttribute("centerInfoList", centerInfoList);

		// 都道府県Enumをリストに変換
		List<Region> regions = Arrays.asList(Region.values());

		// 都道府県プルダウン情報をセット
		model.addAttribute("regions", regions);

		return UrlConsts.CENTER_INFO_INDEX;
	}

	/**
	 * 登録入力画面表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConsts.CENTER_INFO_REGISTER)
	public String register(Model model) {

		return UrlConsts.CENTER_INFO_REGISTER;
	}

	/**
	 * 登録結果表示
	 * 
	 * @param form
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping(UrlConsts.CENTER_INFO_REGISTRATION_COMPLETED)
	public String register(@Valid RegisterCenterInfoForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		// Valid項目チェック
		if (bindingResult.hasErrors()) {

			// エラーメッセージをプロパティファイルから取得しフラッシュ属性として設定
			String errorMsg = MessageManager.getMessage(messageSource,
					bindingResult.getGlobalError().getDefaultMessage());
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);

			return "redirect:" + UrlConsts.CENTER_INFO_REGISTER;
		}

		// 在庫センター情報を登録
		try {
			centerInfoService.registerCenterInfo(form);
		} catch (Exception e) {
			// エラーメッセージをフラッシュ属性として設定
			String errorMsg = messageSource.getMessage(ResultMessage.REGISTRATION_ERROR, null,
					Locale.getDefault());
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);

			// 初期表示にリダイレクト
			return "redirect:" + UrlConsts.CENTER_INFO;
		}

		// 登録完了メッセージをフラッシュ属性として設定
		String completedMsg = messageSource.getMessage(ResultMessage.REGISTRATION_COMPLETED, null,
				Locale.getDefault());
		redirectAttributes.addFlashAttribute("completedMsg", completedMsg);

		// 初期表示にリダイレクト
		return "redirect:" + UrlConsts.CENTER_INFO;
	}

	/**
	 * センター情報詳細（更新/削除）画面表示
	 * 
	 * @param centerId
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping(UrlConsts.CENTER_INFO_DETAILS)
	public String details(@PathVariable int centerId, Model model, RedirectAttributes redirectAttributes) {

		// 在庫センター情報詳細（更新/削除）画面に表示するデータを取得
		List<CenterInfo> centerInfoList = centerInfoService.getCenterInfoData(centerId);

		if (!centerInfoList.isEmpty()) {
			// 在庫センター情報詳細をセット
			model.addAttribute("centerInfoList", centerInfoList);

			return UrlConsts.CENTER_INFO_UPDATE;
		} else {
			// エラーメッセージをプロパティファイルから取得
			String errorMsg = messageSource.getMessage(ErrorMessage.NULL_CENTER_ID_MESSAGE, null,
					Locale.getDefault());
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);

			// 初期表示にリダイレクト
			return "redirect:" + UrlConsts.CENTER_INFO;
		}
	}

	/**
	 * 更新結果を表示
	 * 
	 * @param form
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping(UrlConsts.CENTER_INFO_UPDATE)
	public String update(@Valid UpdateCenterInfoForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		// Valid項目チェック
		if (bindingResult.hasErrors()) {

			// エラーメッセージをプロパティファイルから取得しフラッシュ属性として設定	
			String errorMsg = MessageManager.getMessage(messageSource,
					bindingResult.getGlobalError().getDefaultMessage());
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);

			return "redirect:/admin/centerInfo/details/" + form.getCenterId();
		}

		// 在庫センター情報を登録
		try {
			centerInfoService.updateCenterInfo(form);
		} catch (Exception e) {
			// エラーメッセージをフラッシュ属性として設定
			String errorMsg = messageSource.getMessage(ResultMessage.UPDATE_ERROR, null,
					Locale.getDefault());
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);

			// 初期表示にリダイレクト
			return "redirect:" + UrlConsts.CENTER_INFO;
		}

		// 登録完了メッセージをフラッシュ属性として設定
		String completedMsg = messageSource.getMessage(ResultMessage.UPDATE_COMPLETED, null,
				Locale.getDefault());
		redirectAttributes.addFlashAttribute("completedMsg", completedMsg);

		// 初期表示にリダイレクト
		return "redirect:" + UrlConsts.CENTER_INFO;
	}

	/**
	 * 削除確認画面表示
	 * 
	 * @param centerId
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping(UrlConsts.CENTER_INFO_DELETE_CONFIRM)
	public String delete(@PathVariable int centerId, Model model, RedirectAttributes redirectAttributes) {

		// 削除確認画面に表示するデータを取得
		List<CenterInfo> centerInfoList = centerInfoService.getCenterInfoData(centerId);

		if (!centerInfoList.isEmpty()) {
			// 在庫センター情報詳細をセット
			model.addAttribute("centerInfoList", centerInfoList);

			return UrlConsts.CENTER_INFO_DELETE;
		} else {
			// エラーメッセージをプロパティファイルから取得
			String errorMsg = messageSource.getMessage(ErrorMessage.NULL_CENTER_ID_MESSAGE, null,
					Locale.getDefault());
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);

			// 初期表示にリダイレクト
			return "redirect:" + UrlConsts.CENTER_INFO;
		}
	}

	/**
	 * 削除(論理削除)結果を表示
	 * 
	 * @param form
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping(UrlConsts.CENTER_INFO_DELETE)
	public String delete(@Valid DeleteCenterInfoForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		// Valid項目チェック
		if (bindingResult.hasErrors()) {

			// エラーメッセージをプロパティファイルから取得しフラッシュ属性として設定	
			String errorMsg = MessageManager.getMessage(messageSource,
					bindingResult.getGlobalError().getDefaultMessage());
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);

			return "redirect:/admin/centerInfo/delete/" + form.getCenterId();
		}

		// 在庫センター情報を削除（論理削除）
		try {
			centerInfoService.deleteCenterInfo(form);
		} catch (Exception e) {
			// エラーメッセージをフラッシュ属性として設定
			String errorMsg = messageSource.getMessage(ResultMessage.UPDATE_ERROR, null,
					Locale.getDefault());
			redirectAttributes.addFlashAttribute("errorMsg", errorMsg);

			// 初期表示にリダイレクト
			return "redirect:" + UrlConsts.CENTER_INFO;
		}

		// 登録完了メッセージをフラッシュ属性として設定
		String completedMsg = messageSource.getMessage(ResultMessage.UPDATE_COMPLETED, null,
				Locale.getDefault());
		redirectAttributes.addFlashAttribute("completedMsg", completedMsg);

		// 初期表示にリダイレクト
		return "redirect:" + UrlConsts.CENTER_INFO;
	}

}