package com.e3.search.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.e3.bean.SearchResult;
import com.e3.search.service.ImportItemService;
import com.e3.search.service.SearchItemService;

@Controller
public class SearchItemController {

	@Autowired
	private SearchItemService service;

	@RequestMapping("/search")
	public String search(String keyword,@RequestParam(defaultValue="0")Integer page,
			@RequestParam(defaultValue="30")Integer rows,Model model){
		try {
			keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SearchResult result = service.searchItem(keyword, page, rows);
		model.addAttribute("query", result.getQuery());
		model.addAttribute("totalPages", result.getTotalPages());
		model.addAttribute("page", result.getPage());
		model.addAttribute("recourdCount", result.getRecourdCount());
		model.addAttribute("itemList", result.getItemList());
		
		//返回逻辑视图
		return "search";
	}
}
