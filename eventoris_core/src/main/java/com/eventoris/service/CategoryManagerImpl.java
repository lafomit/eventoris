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


	public CategoryInfo getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public CategoryInfo getCategoryById(int id) {
		return eventDaoProvider.getCategory(id);
	}


	public void createCategory(CategoryInfo categoryInfo) {
		// TODO Auto-generated method stub
		
	}


	public boolean deleteCategoryInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean updateCategoryInfo(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
