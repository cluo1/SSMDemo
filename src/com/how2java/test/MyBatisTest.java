package com.how2java.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyBatisTest {
//	@Autowired
//	CategoryMapper categoryMapper;
	
	@Autowired
	CategoryService categoryService;
	
//	@Test
//	public void add(){
//		for(int i=0;i<100;i++){
//			Category category = new Category();
//			category.setName("new Category");
//			//categoryMapper.add(category);
//		}
//	}
//	
//	@Test
//	public void total(){
//		int total = categoryMapper.total();
//		System.out.println("total="+total);
//	}
//	
//	@Test
//	public void testPage(){
//		Page page = new Page();
//		page.setStart(6);
//		page.setLast(10);
//		
//		List<Category> cs = categoryMapper.list(page);
//		for(Category c : cs){
//			System.out.println(c);
//		}
//	}
//	
	
	@Test
	public void testAddTwo(){
		categoryService.deleteAll();
		categoryService.addTwo();
	}
}
