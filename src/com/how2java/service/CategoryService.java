package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Category;
import com.how2java.util.Page;
public interface CategoryService {
	public List<Category> list();
	//int total();
	//public List<Category> list(Page page);
	public Category get(int id);
	public void update(Category category);
	public void delete(int id);
	
	//新增两条数据
	public void addTwo();
	
	//删除所有
	public void deleteAll();
}
