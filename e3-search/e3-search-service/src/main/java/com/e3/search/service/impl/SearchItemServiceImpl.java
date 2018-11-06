package com.e3.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.bean.SearchResult;
import com.e3.search.dao.SearchDao;
import com.e3.search.service.SearchItemService;
@Service
public class SearchItemServiceImpl implements SearchItemService{

	@Autowired
	private SearchDao searchDao;

	@Override
	public SearchResult searchItem(String keyword, int page, int rows) {
		SolrQuery query = new SolrQuery();
		query.setQuery(keyword);
		query.set("df", "item_keywords");
		if(page==0||page<0){
			page=1;
		}else{
			page=page+1;
		}
		query.setStart((page-1)*rows);
		query.setRows(rows);
		query.setHighlight(true);
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		query.addHighlightField("item_title");
		SearchResult searchResult = searchDao.searchItemByquery(query);
		searchResult.setQuery(keyword);
		searchResult.setPage(page);
		searchResult.setTotalPages(searchResult.getRecourdCount()%rows>0?(searchResult.getRecourdCount()/rows)+1:(searchResult.getRecourdCount()/rows));
		return searchResult;
	}

}
