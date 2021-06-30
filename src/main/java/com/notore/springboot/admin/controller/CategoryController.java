package com.notore.springboot.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.notore.springboot.admin.repositories.AdministratorRepository;
import com.notore.springboot.admin.service.CategoryService;
import com.notore.springboot.model.Categories;

/**
 * カテゴリ一覧のコントローラー
 */
@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	/**
	 * カテゴリ一覧(TOP)画面の呼び出し
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("categorieslist", service.findAll());
		return "admin/categories/list";
		
	}
	
	/**
	 * 新規カテゴリの登録
	 * 
	 * @param categories
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("formModel") Categories categories, ModelAndView mav) {
		
		mav.setViewName("admin/categories/create");	
		Iterable<Categories> list = service.findAll();
		mav.addObject("datalist", list);
		return mav;
		
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView save(@ModelAttribute("formModel") Categories categories, ModelAndView mav) {
		
		service.saveAndFlush(categories);
		return new ModelAndView("redirect:/admin/categories");
		
	}
	
	/**
	 * 登録済みカテゴリ情報の編集
	 * 
	 * @param categories
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute Categories categories, @PathVariable int id, ModelAndView mav) {
		
		mav.setViewName("admin/categories/edit");
		mav.addObject("title", "ID =" + id + "の管理者の情報を編集");
		Categories categ = service.findById((long)id).get();
		mav.addObject("formModel", categ);
		return mav;
		
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView update(@ModelAttribute Categories categories, ModelAndView mav) {
		
		service.saveAndFlush(categories);
		return new ModelAndView("redirect:/admin/categories");
		
	}
	
	/**
	 * 登録済みカテゴリ情報の削除
	 * 
	 * @param categories
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute Categories categories, @PathVariable int id, ModelAndView mav) {
		
		mav.setViewName("admin/categories/delete");
		mav.addObject("title", "ID =" + id + "の管理者の情報を削除");
		Categories categ = service.findById((long)id).get();
		mav.addObject("formModel", categ);
		return mav;
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView remove(@ModelAttribute Categories categories, ModelAndView mav) {
		
		service.delete(categories);
		return new ModelAndView("redirect:/admin/categories");
		
	}
	
}