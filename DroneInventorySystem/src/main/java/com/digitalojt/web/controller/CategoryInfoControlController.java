package com.digitalojt.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.digitalojt.web.consts.CategoryConsts;
import com.digitalojt.web.consts.UrlConsts;

/**
 * 分類情報管理画面のコントローラークラス
 * 
 * @author Okuma
 * 
 */
@Controller
public class CategoryInfoControlController{
	
	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConsts.CATEGORY_INFO_CONTROL)
	public String index(Model model) {
		
		// 分類 Enumをリストに変換
		List<CategoryConsts> categoryConsts = Arrays.asList(CategoryConsts.values());

		// 分類一覧情報をセット
		model.addAttribute("categoryConsts", categoryConsts);

		return "admin/categoryInfoControl/index";
	}
	
	
}
