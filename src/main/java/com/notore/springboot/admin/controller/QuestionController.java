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
import com.notore.springboot.admin.service.QuestionService;
import com.notore.springboot.model.Questions;

/**
 * 問題一覧のコントローラー
 */
@Controller
@RequestMapping("admin/questions")
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	/**
	 * 問題一覧(TOP)画面の呼び出し
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("questionslist", service.findAll());
		return "admin/questions/list";
		
	}
	
	/**
	 * 新規問題の登録
	 * 
	 * @param questions
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("formModel") Questions questions, ModelAndView mav) {
		
		mav.setViewName("admin/questions/create");	
		Iterable<Questions> list = service.findAll();
		mav.addObject("datalist", list);
		return mav;
		
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView save(@ModelAttribute("formModel") Questions questions, ModelAndView mav) {
		
		service.saveAndFlush(questions);
		return new ModelAndView("redirect:/admin/questions");
		
	}
	
	/**
	 * 登録済み問題情報の編集
	 * 
	 * @param questions
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute Questions questions, @PathVariable int id, ModelAndView mav) {
		
		mav.setViewName("admin/questions/edit");
		mav.addObject("title", "ID =" + id + "の管理者の情報を編集");
		Questions quest = service.findById((long)id).get();
		mav.addObject("formModel", quest);
		return mav;
		
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView update(@ModelAttribute Questions questions, ModelAndView mav) {
		
		service.saveAndFlush(questions);
		return new ModelAndView("redirect:/admin/questions");
		
	}
	
	/**
	 * 登録済み問題情報の削除
	 * 
	 * @param questions
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute Questions questions, @PathVariable int id, ModelAndView mav) {
		
		mav.setViewName("admin/questions/delete");
		mav.addObject("title", "ID =" + id + "の管理者の情報を削除");
		Questions quest = service.findById((long)id).get();
		mav.addObject("formModel", quest);
		return mav;
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView remove(@ModelAttribute Questions questions, ModelAndView mav) {
		
		service.delete(questions);
		return new ModelAndView("redirect:/admin/questions");
		
	}
	
}