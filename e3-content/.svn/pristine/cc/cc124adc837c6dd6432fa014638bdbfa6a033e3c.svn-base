package com.e3.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.mapper.ContentCategoryMapper;
import com.e3.pojo.ContentCategory;
import com.e3.pojo.ContentCategoryExample;
import com.e3.bean.TreeBean;
import com.e3.content.service.ContentCategoryService;

/**
 * 内容分类管理Service
 * <p>Title: ContentCategoryServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private ContentCategoryMapper categoryMapper;
	@Override
	public List<TreeBean> getContentCategory(long parentId) {
		List<TreeBean> list = new ArrayList<TreeBean>();
		ContentCategoryExample example = new ContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<ContentCategory> selectByExample = categoryMapper.selectByExample(example);
		for (ContentCategory contentCategory : selectByExample) {
			TreeBean bean = new TreeBean();
			bean.setId(contentCategory.getId());
			bean.setText(contentCategory.getName());
			bean.setState(contentCategory.getIsParent()?"closed":"open");
			list.add(bean);
		}
		return list;
	}
	@Override
	public void andContentCategory(Long parentId, String name) {

		ContentCategory  contentCategory =  new ContentCategory();
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		contentCategory.setSortOrder(1);
		contentCategory.setStatus(1);
		contentCategory.setIsParent(false);
		try {
			
			categoryMapper.insert(contentCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ContentCategory parentCategory = categoryMapper.selectByPrimaryKey(parentId);
		if(!parentCategory.getIsParent()){
			parentCategory.setIsParent(true);
			try {
				
				categoryMapper.updateByPrimaryKey(parentCategory);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
