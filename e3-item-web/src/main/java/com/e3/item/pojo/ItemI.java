package com.e3.item.pojo;

import org.apache.commons.lang3.StringUtils;

import com.e3.pojo.Item;

public class ItemI extends Item{
	public ItemI(Item item){
		setId(item.getId());
		setCid(item.getCid());
		setBarcode(item.getBarcode());
		setCreated(item.getCreated());
		setImage(item.getImage());
		setNum(item.getNum());
		setPrice(item.getPrice());
		setSellPoint(item.getSellPoint());
		setTitle(item.getTitle());
		setUpdated(item.getUpdated());
	}
	public String[] getImages(){
		String images = getImage();
		String[] strings = null;
		if(!StringUtils.isBlank(images)){
			 strings = images.split(",");
		}
		return strings;
	}

}
