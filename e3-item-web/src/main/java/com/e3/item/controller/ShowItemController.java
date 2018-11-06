package com.e3.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e3.item.pojo.ItemI;
import com.e3.pojo.Item;
import com.e3.pojo.ItemDesc;
import com.e3.service.ItemService;

@Controller
public class ShowItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId, Model model) {
		Item item = itemService.getItemById(itemId);
		ItemI itemI = null;
		if(item!=null){
			itemI = new ItemI(item);
		}
		ItemDesc itemDesc = itemService.getItemDescById(itemId);
		model.addAttribute("item",itemI);
		model.addAttribute("itemDesc",itemDesc);
		return "item";
	}

}
