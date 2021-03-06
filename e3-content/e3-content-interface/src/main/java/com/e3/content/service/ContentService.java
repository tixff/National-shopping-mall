package com.e3.content.service;

import java.util.List;

import com.e3.pojo.Content;
import com.e3.utils.PageBean;

public interface ContentService {
	PageBean  getContentList(long id,Integer page,Integer rows);
	List<Content> getContentListByCid(long cid);
	void updateContent(Content content);
	void addContent(Content content);
}
