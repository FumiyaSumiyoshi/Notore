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
import com.notore.springboot.admin.service.UserService;
import com.notore.springboot.model.User;

/**
 * ユーザー一覧のコントローラー
 */
@Controller
@RequestMapping("admin/user")
public class UserController {

	@Autowired
	UserService service;

	/**
	 * ユーザー一覧(TOP)画面の呼び出し
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("userlist", service.findAll());

		return "admin/user/list";

	}

	/**
	 * 新規ユーザーの登録
	 * 
	 * @param user
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("formModel") User user, ModelAndView mav) {

		mav.setViewName("admin/user/create");

		Iterable<User> list = service.findAll();
		mav.addObject("datalist", list);

		return mav;

	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView save(@ModelAttribute("formModel") User user, ModelAndView mav) {

		service.saveAndFlush(user);

		return new ModelAndView("redirect:/admin/user");

	}

	/**
	 * 登録済みユーザー情報の編集
	 * 
	 * @param user
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute User user, @PathVariable int id, ModelAndView mav) {

		mav.setViewName("admin/user/edit");

		mav.addObject("title", "ID =" + id + "の管理者の情報を編集");

		User use = service.findById((long) id).get();
		mav.addObject("formModel", use);

		return mav;

	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView update(@ModelAttribute User user, ModelAndView mav) {

		service.saveAndFlush(user);

		return new ModelAndView("redirect:/admin/user");

	}

	/**
	 * 登録済みユーザー情報の削除
	 * 
	 * @param user
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute User user, @PathVariable int id, ModelAndView mav) {

		mav.setViewName("admin/user/delete");

		mav.addObject("title", "ID =" + id + "の管理者の情報を削除");
		User use = service.findById((long) id).get();

		mav.addObject("formModel", use);

		return mav;

	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView remove(@ModelAttribute User user, ModelAndView mav) {

		service.delete(user);

		return new ModelAndView("redirect:/admin/user");

	}

}