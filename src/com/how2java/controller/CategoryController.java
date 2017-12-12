package com.how2java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;

@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page){
		ModelAndView mv = new ModelAndView();
//		List<Category> cs = categoryService.list(page);
//		int total = categoryService.total();
		
		PageHelper.offsetPage(page.getStart(),5);
        List<Category> cs= categoryService.list();
        int total = (int) new PageInfo<Category>(cs).getTotal();
		page.caculateLast(total);
		
		mv.addObject("cs",cs);
		mv.setViewName("listCategory");
		
		return mv;
	}

	@RequestMapping("editCategory")
	public ModelAndView updateCategory(Category category){
		int id = category.getId();
		
		ModelAndView mv = new ModelAndView();
		 
		mv.setViewName("editCategory");
		
		return mv;
	}
}
