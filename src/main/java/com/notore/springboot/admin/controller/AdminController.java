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
import com.notore.springboot.admin.service.AdminService;
import com.notore.springboot.model.Administrator;

@Controller
@RequestMapping("admin/administrator")
public class AdminController {
	
	
	@Autowired
	AdminService service;

	/**
	 * 問題一覧(TOP)画面の呼び出し
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("adminlist", service.findAll());
        return "admin/administrator/list";
    }
	
	
//	/**
//	 * カテゴリ一覧画面の呼び出し
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/admin.category")
//	public String index2() {
//		
//		return "admin/categorylist";
//	}
//	
//	/**
//	 * レベル一覧画面の呼び出し
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/admin.level")
//	public String index3() {
//		
//		return "admin/levellist";
//	}
//	
//	/**
//	 * 問題の登録画面の呼び出し
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/admin.setquestion")
//	public String index4() {
//		
//		return "admin/setquestion";
//	}
//	
//	/**
//	 * ユーザー管理画面の呼び出し
//	 * 
//	 * @return
////	 */
//	@RequestMapping(value = "/admin.user")
//	public String index5() {
//		
//		return "admin/user";
//	}
	/**
	 * 新規管理者の登録
	 * 
	 * @param administrator
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("formModel") Administrator administrator, ModelAndView mav) {
		
		mav.setViewName("admin/administrator/create");	
		Iterable<Administrator> list = service.findAll();
		mav.addObject("datalist", list);
		return mav;
		
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView save(@ModelAttribute("formModel") Administrator administrator, ModelAndView mav) {
		
		service.saveAndFlush(administrator);
		
		return new ModelAndView("redirect:/admin/administrator");
		
	}
	
	/**
	 * 登録済み管理者情報の編集
	 * 
	 * @param administrator
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute Administrator administrator, @PathVariable int id, ModelAndView mav) {
		
		mav.setViewName("admin/administrator/edit");
		mav.addObject("title", "ID =" + id + "の管理者の情報を編集");
		Administrator admin = service.findById((long)id).get();
		mav.addObject("formModel", admin);
		
		
		return mav;
		
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView update(@ModelAttribute Administrator administrator, ModelAndView mav) {
		
		service.saveAndFlush(administrator);
		return new ModelAndView("redirect:/admin/administrator");
		
	}
	
	/**
	 * 登録済み管理者情報の削除
	 * 
	 * @param administrator
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute Administrator administrator, @PathVariable int id, ModelAndView mav) {
		
		mav.setViewName("admin/administrator/delete");
		mav.addObject("title", "ID =" + id + "の管理者の情報を削除");
		Administrator admin = service.findById((long)id).get();
		mav.addObject("formModel", admin);
		return mav;
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView remove(@ModelAttribute Administrator administrator, ModelAndView mav) {
		
		service.delete(administrator);
		return new ModelAndView("redirect:/admin/administrator");
		
	}
	
}
