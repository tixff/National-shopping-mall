package com.e3.content.service;

import java.util.List;

import com.e3.bean.TreeBean;

public interface ContentCategoryService {
	List<TreeBean> getContentCategory(long parentId);
	void  andContentCategory(Long parentId,String name);

}
