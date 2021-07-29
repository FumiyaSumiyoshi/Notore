package com.notore.springboot.front.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Collections;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.notore.springboot.front.service.AnsweredQuestionServiceFront;
import com.notore.springboot.front.service.ChoicesServiceFront;
//import com.notore.springboot.front.repositories.QuestionRepository2;
//import com.notore.springboot.front.repositories.LevelsRepository2;
import com.notore.springboot.front.service.LevelsServiceFront;
import com.notore.springboot.front.service.QuestionServiceFront;
import com.notore.springboot.front.service.UserServiceFront;
import com.notore.springboot.model.AnsweredQuestion;
import com.notore.springboot.model.Choices;
import com.notore.springboot.model.Levels;
import com.notore.springboot.model.Questions;
import com.notore.springboot.model.User;

/**
 * front用コントローラー
 */
@Controller
public class FrontController {

	public Long id;
	public Long levelId;
	public int goukei = 0;
	public Long userId;
	public Long questionId;
	List<Long> list = new ArrayList<>();
	List<Long> selectCuestionNumbers = new ArrayList<>();
	public long newNo = 0;

	@Autowired
	LevelsServiceFront levelService;

	@Autowired
	QuestionServiceFront questionService;

	@Autowired
	UserServiceFront userService;

	@Autowired
	AnsweredQuestionServiceFront answeredQuestionService;

	@Autowired
	ChoicesServiceFront choicesService;

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
	 * 新規ユーザーの登録
	 * 
	 * @param user
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "front/create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("formModel") User user, ModelAndView mav) {

		mav.setViewName("front/create");

		Iterable<User> list = userService.findAll();

		mav.addObject("datalist", list);
		return mav;

	}

	@RequestMapping(value = "front/save", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView save(@ModelAttribute("formModel") User user, ModelAndView mav) {

		userService.saveAndFlush(user);

		this.userId = user.getId();

		return new ModelAndView("redirect:/front/selectLevel");

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
	public ModelAndView selected(@ModelAttribute Levels levels, Questions questions, @PathVariable Long id,
			ModelAndView mav) {

		mav.setViewName("front/start");

		Levels lev = levelService.findById((long) id).get();
		mav.addObject("thisLevel", lev);
		//レベルから問題の範囲を絞る
		Questions quest[] = questionService.findBylevelId((long) id);

		int length = quest.length;

		Random rand = new Random();
		int num = rand.nextInt(length);

		list.add(quest[num].getId());

		Questions question = questionService.findBylevelIdAndId((long) id, (long) quest[num].getId()).get();
		mav.addObject("letQuestion", question);

		return mav;

	}

	/**
	 * 問題回答画面
	 * 
	 * @param levels
	 * @param id
	 * @param mav
	 * @return
	 */
	@RequestMapping(value = "front/start/question/{levelId}/{id}", method = RequestMethod.GET)
	public ModelAndView answer(@ModelAttribute("test") AnsweredQuestion answerQuestion, Questions questions,
			@PathVariable long levelId, @PathVariable long id, ModelAndView mav) {

		mav.setViewName("front/question");

		Questions quest3 = questionService.findBylevelIdAndId((long) levelId, (long) id).get();
		mav.addObject("formModel", quest3);

		//被らないかテスト
		Questions answeredObject[] = questionService.findBylevelIdAndIdNotIn((long) levelId, list);

		int length = answeredObject.length;

		for (int num = 0; num < length; num++) {

			this.newNo = answeredObject[num].getId();

		}

		System.out.println(list);

		Questions quest4 = questionService.findBylevelIdAndId((long) levelId, (long) newNo).get();
		mav.addObject("formModel2", quest4);

		this.questionId = id;

		//回答形式の取得
		Questions question = questionService.findBylevelIdAndId((long) levelId, (long) id).get();
		question.getAnswerForm();

		this.id = id;
		this.levelId = levelId;

		mav.addObject("answerForm", question);

		//各問の配点を加算していく
		Questions answered[] = questionService.findBylevelIdAndIdIn((long) levelId, list);

		int goukei = 0;
		int questionN = 0;

		for (int num = 0; num < answered.length; num++) {

			goukei += answered[num].getQuestionPoint();

			questionN += 1;//ついでに何問目の問題化を取得

		}

		mav.addObject("goukei", goukei);//各問の配点を合計
		mav.addObject("nBan", questionN);//何問目かの表示

		String answerFormSelect = question.getAnswerForm();

		if (answerFormSelect.equals("複数選択")) {

			Choices choices = choicesService.findByquestionId(id).get();

			mav.addObject("choices", choices);

		}

		return mav;

	}

	@RequestMapping(value = "front/question", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView next(@ModelAttribute("test") AnsweredQuestion answeredQuestion, Questions questions, User user,
			ModelAndView mav) {

		answeredQuestion.setQuestionId(questionId);
		answeredQuestion.setUserId(userId);

		answeredQuestionService.saveAndFlush(answeredQuestion);

		list.add(newNo);
		//回答済み番号(配列)取得
		AnsweredQuestion[] qNumber = answeredQuestionService.findByuserId((long) userId);//配列
		int length = qNumber.length;//保存したデータの数

		for (int i = 0; i < length; i++) {

			list.add(qNumber[i].getQuestionId());

		}
		//回答の照合
		Questions question = questionService.findBylevelIdAndId((long) levelId, (long) id).get();
		AnsweredQuestion answeredInfo = answeredQuestionService.findByuserIdAndQuestionId(userId, questionId).get();

		Questions qqq = questionService.findBylevelIdAndId(levelId, id).get();

		if (question.getExactAnswer().equals(answeredInfo.getUserAnswer())) {

			int sum = 0;
			sum += qqq.getQuestionPoint();

			this.goukei += sum;

		} else {

			int sum = 0;
			this.goukei += sum;

		}

		//得点合計の確認
		System.out.println(goukei);

		return new ModelAndView("redirect:/front/lastPage");

	}

	/**
	 * 回答終了ページ
	 * 
	 * @return
	 */
	@RequestMapping(value = "front/finishPage", method = RequestMethod.GET)
	public String finish(Model model) {

		model.addAttribute("getPoint", goukei);

		return "front/finishPage";

	}

	/**
	 * 結果ページ
	 * 
	 * @return
	 */
	@RequestMapping(value = "front/lastPage", method = RequestMethod.GET)
	public String result(Model model) {

		model.addAttribute("getPoint", goukei);

		return "front/lastPage";

	}

}
