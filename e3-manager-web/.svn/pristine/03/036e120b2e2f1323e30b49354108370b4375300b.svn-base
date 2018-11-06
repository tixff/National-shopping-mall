package com.e3.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3.pojo.ItemParam;
import com.e3.service.ItemParamService;
import com.e3.utils.JsonUtils;
import com.e3.utils.PageBean;

@Controller
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/item/param/list")
	@ResponseBody
	public String getItemParamList(@RequestParam(defaultValue="0") Integer page,
			@RequestParam(defaultValue="0") Integer rows){
		PageBean pageBean = itemParamService.getItemParamList(page, rows);
		String json = JsonUtils.objectToJson(pageBean);
		return json;
	}
	
	@RequestMapping("/item/param/query/itemcatid/{cid}")
	@ResponseBody
	public Object getItamParamByCid(@PathVariable Long cid){
		ItemParam itemParam = itemParamService.getItemParamByCId(cid);
		Map map = new HashMap<>();
		if(itemParam!=null){
			map.put("status", 200);
			map.put("data", itemParam.getParamData());
			String objectToJson = JsonUtils.objectToJson(map);
			return objectToJson;
		}else{
			map.put("status", 404);
			map.put("data", null);
			String objectToJson = JsonUtils.objectToJson(map);
			return objectToJson;
		}
	}
	
	
	@RequestMapping("/item/param/save/{cid}")
	@ResponseBody
	public Object insertItemParam(@PathVariable Long cid,String paramData){
		Map map = new HashMap<>();
		try {
			itemParamService.saveItemParam(cid, paramData);
			map.put("status", 200);
			map.put("msg", "成功");
			return map;
		} catch (Exception e) {
			map.put("status", 500);
			map.put("msg", "失败");
			return map;
		}
	}
}
