package com.notore.springboot.admin.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.notore.springboot.admin.service.CategoryService;
import com.notore.springboot.admin.service.LevelsService;
import com.notore.springboot.admin.service.QuestionService;
import com.notore.springboot.model.Categories;
import com.notore.springboot.model.Levels;
import com.notore.springboot.model.Questions;

/**
 * 問題一覧のコントローラー
 */
@Controller
@RequestMapping("admin/questions")
public class QuestionController {

	@Autowired
	QuestionService questService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	LevelsService levelService;

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * 問題一覧(TOP)画面の呼び出し
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model,
			@ModelAttribute("formModel") Questions questions) {

		Page<Questions> questionPage = questService.getQuestions(pageable);

		model.addAttribute("page", questionPage);
		model.addAttribute("questionslist", questionPage.getContent());

		Iterable<Levels> lev = levelService.findAll();
		model.addAttribute("levelslist", lev);

		Iterable<Categories> categ = categoryService.findAll();
		model.addAttribute("categorylist", categ);

		model.addAttribute("msg", "問題の検索");
		model.addAttribute("msg2", "検索条件を入力してください");

		return "admin/questions/list";

	}

	//検索結果の受け取り処理
	//@ModelAttributeでformからformModelを受け取り、
	//その型(Questions)と変数(questions)を指定する
	@RequestMapping(method = RequestMethod.POST)
	public String select(@ModelAttribute("formModel") Questions questions, Model model) {

		Iterable<Levels> lev = levelService.findAll();
		model.addAttribute("levelslist", lev);

		Iterable<Categories> categ = categoryService.findAll();
		model.addAttribute("categorylist", categ);

		model.addAttribute("msg", "検索結果");

		//questionsのゲッターで各値を取得する
		List<Questions> result = questService.search(questions.getCategoryId(), questions.getLevelId(),
				questions.getAnswerForm());
		model.addAttribute("questionslist", result);
		
		model.addAttribute("formModel.answerForm", questions.getAnswerForm());

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

		Iterable<Questions> list = questService.findAll();
		mav.addObject("datalist", list);

		Iterable<Levels> lev = levelService.findAll();
		mav.addObject("levelslist", lev);

		Iterable<Categories> categ = categoryService.findAll();
		mav.addObject("categorylist", categ);

		return mav;

	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView save(@ModelAttribute("formModel") Questions questions, ModelAndView mav) {

		questService.saveAndFlush(questions);

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

		Questions quest = questService.findById((long) id).get();
		mav.addObject("formModel", quest);

		Iterable<Levels> lev = levelService.findAll();
		mav.addObject("levelslist", lev);

		Iterable<Categories> categ = categoryService.findAll();
		mav.addObject("categorylist", categ);

		return mav;

	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView update(@ModelAttribute Questions questions, ModelAndView mav) {

		questService.saveAndFlush(questions);

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

		Questions quest = questService.findById((long) id).get();
		mav.addObject("formModel", quest);

		return mav;

	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView remove(@ModelAttribute Questions questions, ModelAndView mav) {

		questService.delete(questions);

		return new ModelAndView("redirect:/admin/questions");

	}

}
