package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Category;
import com.how2java.util.Page;

public interface CategoryMapper {
	public void add(Category category);
	
	public void delete(int id);
	
	public void update(Category category);
	
	public Category get(int id);
	
	public List<Category> list();
	
	//public int total();
	//∑÷“≥≤È—Ø
	//public List<Category> list(Page page);
	
}
	