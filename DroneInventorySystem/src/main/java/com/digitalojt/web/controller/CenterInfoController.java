package com.digitalojt.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digitalojt.web.consts.CompletedMessage;
import com.digitalojt.web.consts.Region;
import com.digitalojt.web.consts.UrlConsts;
import com.digitalojt.web.entity.CenterInfo;
import com.digitalojt.web.form.CenterInfoForm;
import com.digitalojt.web.form.RegisterCenterInfoForm;
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

		// フラッシュ属性から完了メッセージを取得し、モデルに追加
	    String completedMsg = (String) model.asMap().get("completedMsg");
	    model.addAttribute("completedMsg", completedMsg);
	    
		return "admin/centerInfo/index";
	}

	/**
	 * 検索結果表示
	 * 
	 * @param model
	 * @param form
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

			return "admin/centerInfo/index";
		}

		// 在庫センター情報画面に表示するデータを取得
		List<CenterInfo> centerInfoList = centerInfoService.getCenterInfoData(form.getCenterName(), form.getRegion());

		// 画面表示用に商品情報リストをセット
		model.addAttribute("centerInfoList", centerInfoList);

		// 都道府県Enumをリストに変換
		List<Region> regions = Arrays.asList(Region.values());

		// 都道府県プルダウン情報をセット
		model.addAttribute("regions", regions);

		return "admin/centerInfo/index";
	}

	/**
	 * 登録入力画面表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConsts.CENTER_INFO_REGISTER)
	public String register(Model model) {
		return "admin/centerInfo/register";
	}

	/**
	 * 登録結果表示
	 * 
	 * @param model
	 * @param form
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(UrlConsts.CENTER_INFO_REGISTRATION_COMPLETED)
	public String register(Model model, @Valid RegisterCenterInfoForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		// Valid項目チェック
		if (bindingResult.hasErrors()) {

//何項目のエラーか把握し、それによりエラーメッセージを入力する個所を変更する
			
			
			// エラーメッセージをプロパティファイルから取得
			String errorMsg = MessageManager.getMessage(messageSource,
					bindingResult.getGlobalError().getDefaultMessage());
			model.addAttribute("errorMsg", errorMsg);

//			// 項目ごとにエラーメッセージを表示する  
//	            bindingResult.getFieldErrors().forEach(fieldError -> {
//	                String field = fieldError.getField();
//	                String errorMessage =MessageManager.getMessage(messageSource, fieldError.getDefaultMessage());
//	                model.addAttribute(field + "ErrorMsg", errorMessage);
//	            });
	        
			
			return "admin/centerInfo/register";
		}
		
		//// 在庫センター情報を登録するためのCenterInfoオブジェクトを作成
		CenterInfo centerInfo = new CenterInfo();
		centerInfo.setCenterName(form.getCenterName());
		centerInfo.setPostCode(form.getPostCode());
		centerInfo.setAddress(form.getAddress());
		centerInfo.setPhoneNumber(form.getPhoneNumber());
		centerInfo.setManagerName(form.getManagerName());
		centerInfo.setOperationalStatus(form.getOperationalStatus());
		centerInfo.setMaxStorageCapacity(form.getMaxStorageCapacity());
		centerInfo.setCurrentStorageCapacity(form.getCurrentStorageCapacity());
		// 在庫センター情報を登録
		centerInfoService.registerCenterInfo(centerInfo);

		
		// 登録完了メッセージをフラッシュ属性として設定
        String completedMsg = messageSource.getMessage(CompletedMessage.REGISTRATION_COMPLETED, null, Locale.getDefault());
        redirectAttributes.addFlashAttribute("completedMsg", completedMsg);

		// 初期表示にリダイレクト
	    return "redirect:" + UrlConsts.CENTER_INFO;
	}
}
