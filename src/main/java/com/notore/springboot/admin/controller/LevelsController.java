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
import com.notore.springboot.admin.service.LevelsService;
import com.notore.springboot.model.Levels;

/**
 * レベル一覧のコントローラー
 */
@Controller
@RequestMapping("admin/levels")
public class LevelsController {

	@Autowired
	LevelsService service;

	/**
	 * レベル一覧(TOP)画面の呼び出し
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("levelslist", service.findAll());

		return "admin/levels/list";

	}

	/**
	 * 新規レベルの登録
	 * 
	 * @param levels
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("formModel") Levels levels, ModelAndView mav) {

		mav.setViewName("admin/levels/create");

		Iterable<Levels> list = service.findAll();
		mav.addObject("datalist", list);

		return mav;

	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView save(@ModelAttribute("formModel") Levels levels, ModelAndView mav) {

		service.saveAndFlush(levels);

		return new ModelAndView("redirect:/admin/levels");

	}

	/**
	 * 登録済みレベル情報の編集
	 * 
	 * @param levels
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute Levels levels, @PathVariable int id, ModelAndView mav) {

		mav.setViewName("admin/levels/edit");

		mav.addObject("title", "ID =" + id + "の管理者の情報を編集");
		Levels lev = service.findById((long) id).get();

		mav.addObject("formModel", lev);

		return mav;

	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView update(@ModelAttribute Levels levels, ModelAndView mav) {

		service.saveAndFlush(levels);

		return new ModelAndView("redirect:/admin/levels");

	}

	/**
	 * 登録済みレベル情報の削除
	 * 
	 * @param levels
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute Levels levels, @PathVariable int id, ModelAndView mav) {

		mav.setViewName("admin/levels/delete");

		mav.addObject("title", "ID =" + id + "の管理者の情報を削除");

		Levels lev = service.findById((long) id).get();
		mav.addObject("formModel", lev);

		return mav;

	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView remove(@ModelAttribute Levels levels, ModelAndView mav) {

		service.delete(levels);

		return new ModelAndView("redirect:/admin/levels");

	}

}