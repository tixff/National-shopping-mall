package com.e3.content.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.e3.content.service.ContentService;
import com.e3.mapper.ContentMapper;
import com.e3.pojo.Content;
import com.e3.pojo.ContentExample;
import com.e3.utils.PageBean;


/**
 * 内容管理Service
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;
	@Override
	public PageBean getContentList(long id, Integer page, Integer rows) {
		PageBean pageBean = new PageBean();
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("id", (int)id);
		map.put("start", (page-1)*rows);
		map.put("rows", rows);
		List<Content> list = contentMapper.getContentListByCId(map);
		pageBean.setTotal((long)list.size());
		pageBean.setRows(list);
		return pageBean;
	}

	@Override
	public List<Content> getContentListByCid(long cid) {
		ContentExample example = new ContentExample();
		example.createCriteria().andCategoryIdEqualTo(cid);
		List<Content> list = contentMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public void updateContent(Content content) {
		content.setUpdated(new Date());
		try {
			
			contentMapper.updateByPrimaryKey(content);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void addContent(Content content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		try {
			
			contentMapper.insert(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
