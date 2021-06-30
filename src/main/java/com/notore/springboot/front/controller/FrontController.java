package com.notore.springboot.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.notore.springboot.front.repositories.LevelsRepository2;
import com.notore.springboot.front.repositories.QuestionRepository2;
import com.notore.springboot.model.Levels;
import com.notore.springboot.model.Questions;

/**
 * front用コントローラー
 */
@Controller
public class FrontController {
	
	@Autowired
	LevelsRepository2 levelService;
	
	@Autowired
	QuestionRepository2 quesitonService;
	
	/**
	 * TOPページの呼び出し
	 * 
	 * @return
	 */
	@RequestMapping("front/topPage")
	public String top() {
		
		return "front/topPage";
		
	}
	
	/**
	 * レベル選択ページの呼び出し
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "front/selectLevel", method = RequestMethod.GET)
	public String select(Model model) {
		
		model.addAttribute("levelslist", levelService.findAll());
		return "front/selectLevel";
		
	}
	
	/**
	 * レベル選択後のSTART画面
	 * 
	 * @param levels
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "front/start/{id}", method = RequestMethod.GET)
	public ModelAndView selected(@ModelAttribute Levels levels, @PathVariable int id, ModelAndView mav) {
		
		mav.setViewName("front/start");
		Levels lev = levelService.findById((long)id).get();
		mav.addObject("formModel", lev);
		return mav;
		
	}
	
	@RequestMapping(value = "front/start", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView start(@ModelAttribute Levels levels, ModelAndView mav) {
		
//		return new ModelAndView("redirect:/front/question");
		return new ModelAndView("redirect:/front/topPage");
	}
	
	/**
	 * 問題回答画面
	 * 
	 * @param levels
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "front/question/{id}", method = RequestMethod.GET)
	public ModelAndView answer(@ModelAttribute Questions questions, @PathVariable int id, ModelAndView mav) {
		
		mav.setViewName("front/question");
		Questions quest = quesitonService.findById((long)id).get();
		mav.addObject("formModel", quest);
		return mav;
		
	}
	
	@RequestMapping(value = "front/question", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView next(@ModelAttribute Questions questions, ModelAndView mav) {
		
		return new ModelAndView("redirect:/front/topPage");
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//test
	
	
//	@RequestMapping("front/question")
//	public String start() {
//		
//		return "front/question";
//		
//	}
	
}
