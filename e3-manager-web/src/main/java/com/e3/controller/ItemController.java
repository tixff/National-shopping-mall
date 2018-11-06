package com.e3.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3.pojo.Item;
import com.e3.search.service.ImportItemService;
import com.e3.service.ItemService;
import com.e3.utils.PageBean;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	/*@Autowired
	private ImportItemService importItemService;*/
	@RequestMapping("item/{itemId}")
	@ResponseBody
	public Item getItemById(@PathVariable Long itemId){
		Item item = itemService.getItemById(itemId);
		return item;
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public Object getItemList( @RequestParam(name="page",defaultValue="1") Integer page,@RequestParam(name="rows",defaultValue="30") Integer rows){
		PageBean pageBean = itemService.getItemList(page,rows);
		return pageBean;
		
	}
	/*@RequestMapping("/index/item/import")
	@ResponseBody
	public Object importAllItemToSolr(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			importItemService.importAllItems();
			map.put("status", 200);
			map.put("msg", "导入成功");
		} catch (Exception e) {
			map.put("status", 500);
			map.put("msg", "导入发生错误");
			e.printStackTrace();
		}
		return map;
	}*/
	@RequestMapping("/item/save")
	@ResponseBody
	public Object addItem(Item item,String desc){
		Map<String,Object> map  = new HashMap<String,Object>();
		try {
			itemService.addItem(item, desc);
			map.put("status", 200);
			map.put("msg", "添加成功");
			
		} catch (Exception e) {
			map.put("status", 500);
			map.put("msg", "添加失败");
			e.printStackTrace();
		}
		return map;
	}
}
