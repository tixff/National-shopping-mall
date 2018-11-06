package com.e3.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.e3.mapper.ItemParamMapper;
import com.e3.pojo.ItemParam;
import com.e3.service.impl.ImageServiceImpl;
import com.e3.service.impl.ItemParamServiceImpl;

public class TestService {
	@Test
	public void testFtp() throws Exception {
		ApplicationContext context =new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		String str = "C:\\Users\\Ti\\Pictures\\Screenshots\\1.jpg";
		File file = new File(str);
		System.out.println(file.exists());
		ImageServiceImpl imageServiceImpl = context.getBean(ImageServiceImpl.class);
		InputStream inputStream = new FileInputStream(file);
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		int a=0;
		byte[] bytes;
		while((a=inputStream.read())!=-1){
			arrayOutputStream.write(a);
		}
		bytes = arrayOutputStream.toByteArray();
		imageServiceImpl.uploadImage(bytes);
	}
	
	@Test
	public void testGetItemParamList() throws Exception {
		ApplicationContext context =new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		ItemParamMapper mapper = context.getBean(ItemParamMapper.class);
		Map<String, Integer> map  = new HashMap<>();
		map.put("start", 0);
		map.put("rows",5);
		List<ItemParam> list = mapper.getItemParamList(map);
		for (ItemParam itemParam : list) {
			System.out.println(itemParam.getParamData());
		}
		
	}
}
