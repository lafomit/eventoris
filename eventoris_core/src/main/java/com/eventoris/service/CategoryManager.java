package com.eventoris.service;

import java.util.List;

import eventoris.datatypes.CategoryInfo;

public interface CategoryManager {

	public List<CategoryInfo>  getAllCategories();
	
	public CategoryInfo getCategoryByName(String name);
	
	public CategoryInfo getCategoryById(int id);
	
	public void createCategory(CategoryInfo categoryInfo);
	
	public boolean deleteCategoryInfo(int id);
	
	public boolean updateCategoryInfo(int id);
}
