package com.e3.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.mapper.ItemDescMapper;
import com.e3.mapper.ItemMapper;
import com.e3.pojo.Item;
import com.e3.pojo.ItemDesc;
import com.e3.pojo.ItemDescExample;
import com.e3.pojo.ItemExample;
import com.e3.service.ItemService;
import com.e3.utils.IDUtils;
import com.e3.utils.PageBean;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;

    @Override
    public Item getItemById(long id) {
        Item item = itemMapper.selectByPrimaryKey(id);
        return item;
    }

    @Override
    public PageBean getItemList(int page, int rows) {
        PageBean pageBean = new PageBean();
        Map<String, Integer> map = new HashMap<>();
        map.put("start", (page - 1) * rows);
        map.put("count", rows);
        List<Item> list = new ArrayList<>();
        try {
            list = itemMapper.queryItem(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int count = itemMapper.countByExample(new ItemExample());
        pageBean.setRows(list);
        pageBean.setTotal((long) count);
        return pageBean;

    }

    @Override
    public ItemDesc getItemDescById(long id) {
        ItemDescExample example = new ItemDescExample();
        example.createCriteria().andItemIdEqualTo(id);
        try {

            List<ItemDesc> list = itemDescMapper.selectByExampleWithBLOBs(example);
            if (list != null && list.size() > 0) {
                ItemDesc itemDesc = list.get(0);
                return itemDesc;
            } else {

                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addItem(Item item, String desc) {
        long itemId = IDUtils.genItemId();
        item.setId(itemId);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        item.setStatus((byte) 1);
        try {

            itemMapper.insert(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDesc.setItemDesc(desc);
        try {

            itemDescMapper.insert(itemDesc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
