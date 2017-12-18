package com.how2java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
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
	public ModelAndView editCategory(Category category){
		ModelAndView mv = new ModelAndView();
		Category c = categoryService.get(category.getId());
		mv.addObject("c",c);
		mv.setViewName("editCategory"); 
		return mv;
	}
	
	@RequestMapping("updateCategory")
	public ModelAndView updateCategory(Category category){
		
		categoryService.update(category);
		ModelAndView mv = new ModelAndView();
		 
		mv.setViewName("redirect:/listCategory");
		
		return mv;
	}
	
	@RequestMapping("deleteCategory")
	public ModelAndView deleteCategory(Category category){
		
		ModelAndView mv = new ModelAndView();
		categoryService.delete(category.getId());
		mv.setViewName("redirect:/listCategory");
		
		return mv;
	}
	
	
	
	//��AJAX��JSON��ʽ�ύ����
	@ResponseBody
	@RequestMapping("submitCategroy")
	public Category submitCategroy(@RequestBody Category category){
		System.out.println("ssm����������ύ��Json����ת��Ϊcategory����"+category);
		return category;
	}
	
	
	//��Ajax��JSON��ȡ��������
	@ResponseBody
	@RequestMapping("/getOneCategory")
	public String getOneCategory(){
		Category c = new Category();
		c.setId(100);
		c.setName("��100������");
		
		JSONObject json = new JSONObject();
		json.put("category", json.toJSON(c));
		
		return json.toJSONString();
	}
	
}
