package com.notore.springboot.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.notore.springboot.admin.service.AdminService;
import com.notore.springboot.admin.repositories.AdministratorRepository;


@Controller
@RequestMapping("admin/administrator")
public class AdminController {
	
	
//	@Autowired
//	AdminService service;
	@Autowired
	AdministratorRepository service;
	/////////////////////////////////////////////////////////////////////////////////////////////
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
//	 * 管理者情報の保存
//	 * 
//	 * @param administrator
//	 * @param mav
//	 * @return
//	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView create(@ModelAttribute("formModel") Administrator administrator, ModelAndView mav) {
//		mav.setViewName("admin/create");
//		mav.addObject("msg", "this is sample content.");
//		mav.addObject("adminlist",service.findAll() );
//		return mav;
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	@Transactional(readOnly=false)
//	public ModelAndView form(@ModelAttribute("formModel") Administrator administrator, ModelAndView mav) {
//		service.saveAndFlush(administrator);
//		return new ModelAndView("redirect:/");
//	}
	
	
	
	
	
	
	
//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//	@Transactional(readOnly=false)
//	public void test(@ModelAttribute("formModel") Administrator administrator, ModelAndView mav) {
//		service.saveAndFlush(administrator);
//		Administrator test = service.saveAndFlush(administrator);
//		
//		System.out.println(test);
//	}
	
	
	
	
//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//	public ModelAndView edit(@ModelAttribute Administrator administrator, @PathVariable int id, ModelAndView mav) {
//		mav.setViewName("admin/edit");
//		mav.addObject("title", "edit administrator.");
//		Administrator admin = service.findById((long)id);
//		mav.addObject("formModel", admin);
//		return mav;
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	@Transactional(readOnly=false)
//	public ModelAndView update(@ModelAttribute Administrator administrator, ModelAndView mav) {
//		
//		service.saveAndFlush(administrator);
//		return new ModelAndView("redirect:/")
//		
//	}
	
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
//	 */
//	@RequestMapping(value = "/admin.user")
//	public String index5() {
//		
//		return "admin/user";
//	}
	
	@RequestMapping(value = "create")
	public String create() {
		
		System.out.println("aaa");		
		
		return "admin/administrator/create";
		
	}
	
}
