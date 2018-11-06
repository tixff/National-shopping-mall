package com.e3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3.bean.TreeBean;
import com.e3.service.ItemCatService;
import com.e3.utils.JsonUtils;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public String getItemCatList(@RequestParam(name="id",defaultValue="0") Long parentId){
		List<TreeBean> list = itemCatService.getItemList(parentId);
		String json = JsonUtils.objectToJson(list);
		return json;
	}
}
