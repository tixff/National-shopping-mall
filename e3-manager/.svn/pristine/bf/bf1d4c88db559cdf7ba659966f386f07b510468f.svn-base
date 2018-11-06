package com.e3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.bean.TreeBean;
import com.e3.mapper.ItemCatMapper;
import com.e3.pojo.ItemCat;
import com.e3.pojo.ItemCatExample;
import com.e3.pojo.ItemCatExample.Criteria;
import com.e3.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private ItemCatMapper itemCatMapper;

	@Override
	public List<TreeBean> getItemList(long parentId) {
		List<TreeBean> treeBeans = new ArrayList<TreeBean>();
		ItemCatExample example = new ItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<ItemCat> list = itemCatMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			for (ItemCat itemCat : list) {
				TreeBean bean = new TreeBean();
				bean.setId(itemCat.getId());
				bean.setText(itemCat.getName());
				bean.setState(itemCat.getIsParent()?"closed":"open");
				treeBeans.add(bean);
			}
		}
		return treeBeans;
	}

}
