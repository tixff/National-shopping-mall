package com.e3.service;


import com.e3.pojo.ItemParam;
import com.e3.utils.PageBean;

public interface ItemParamService {
	PageBean getItemParamList(int page,int rows);
	ItemParam getItemParamByCId(long cid);
	void saveItemParam(long cid,String paramData);

}
