package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;


@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper categoryMapper;
	public List<Category> list() {
		return categoryMapper.list();
	}
	/*@Override
	public int total() {
		return categoryMapper.total();
	}
	@Override
	public List<Category> list(Page page) {
		return categoryMapper.list(page);
	};*/
	@Override
	public void update(Category category) {
		categoryMapper.update(category);
	}
	@Override
	public Category get(int id) {
		return categoryMapper.get(id);
	}
	@Override
	public void delete(int id) {
		categoryMapper.delete(id);
	}
	
	@Override
	//������������ ֧������ع�
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Excetion")
	public void addTwo() {
		Category category = new Category();
		category.setName("sb");
		categoryMapper.add(category);
		
		category.setName("���ֳ���Ӧ�ֶηŲ���,���ֳ���Ӧ�ֶηŲ���,���ֳ���Ӧ�ֶηŲ���,���ֳ���Ӧ�ֶηŲ���,���ֳ���Ӧ�ֶηŲ���,���ֳ���Ӧ�ֶηŲ���,���ֳ���Ӧ�ֶηŲ���,���ֳ���Ӧ�ֶηŲ���");
		categoryMapper.add(category);
		
	}
	@Override
	//ɾ������
	public void deleteAll() {
		List<Category> list = categoryMapper.list();
		for(Category c : list){
			categoryMapper.delete(c.getId());
		}
	}
	
}
