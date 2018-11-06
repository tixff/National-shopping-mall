package com.e3.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr.Item;
import com.e3.bean.ItemParamBean;
import com.e3.mapper.ItemCatMapper;
import com.e3.mapper.ItemParamMapper;
import com.e3.pojo.ItemCat;
import com.e3.pojo.ItemParam;
import com.e3.pojo.ItemParamExample;
import com.e3.service.ItemParamService;
import com.e3.utils.PageBean;
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private ItemParamMapper itemParamMapper; 
	@Autowired
	private ItemCatMapper itemCatMapper;
	@Override
	public PageBean getItemParamList(int page, int rows) {
		PageBean pageBean = new PageBean();
		ItemParamExample example = new ItemParamExample();
		int count = itemParamMapper.countByExample(example);
		pageBean.setTotal((long)count);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("start", (page-1)*rows);
		map.put("rows", rows);
		List<ItemParam> itemParamList = itemParamMapper.getItemParamList(map);
		List<ItemParamBean> list = new ArrayList<ItemParamBean>();
		if(itemParamList!=null&&itemParamList.size()>0){
			for (ItemParam itemParam : itemParamList) {
				ItemParamBean bean = new ItemParamBean();
				bean.setId(itemParam.getId());
				bean.setItemCatId(itemParam.getItemCatId());
				bean.setCreated(new SimpleDateFormat("yyyy-MM-dd").format(itemParam.getCreated()));
				bean.setParamData(itemParam.getParamData());
				bean.setUpdated(new SimpleDateFormat("yyyy-MM-dd").format(itemParam.getUpdated()));
				ItemCat itemCat = itemCatMapper.selectByPrimaryKey(itemParam.getItemCatId());
				bean.setItemCatName(itemCat.getName());
				list.add(bean);
			}
		}
		pageBean.setRows(list);
		
		return pageBean;
	}
	@Override
	public ItemParam getItemParamByCId(long cid) {
		ItemParamExample example = new ItemParamExample();
		example.createCriteria().andItemCatIdEqualTo(cid);
		List<ItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void saveItemParam(long cid,String paramData) {
		ItemParam itemParam = new ItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		itemParamMapper.insert(itemParam);
	}

}
