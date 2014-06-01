package com.eventoris.service;

import java.util.List;

import eventoris.dao.EventDAO;
import eventoris.datatypes.CategoryInfo;

public class CategoryManagerImpl implements CategoryManager{

	private EventDAO eventDaoProvider;


	public void setDataSource(EventDAO dataSource) {
		eventDaoProvider = dataSource;
	}

	
	public List<CategoryInfo> getAllCategories() {
		List<CategoryInfo> result = eventDaoProvider.getAllCategories();
		return result;
	}

}
