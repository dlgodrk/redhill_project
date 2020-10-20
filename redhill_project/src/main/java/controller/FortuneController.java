package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import biz.fortune.service.FortuneService;
import biz.fortune.vo.FortuneVO;

@Controller
public class FortuneController {
	@Autowired
	FortuneService service;
	
	@RequestMapping("fortune/fortunelist.do")
	public ModelAndView list(int humanno) {
		ModelAndView mav = new ModelAndView();
		List<FortuneVO> list = service.searchFortuneList(humanno);
		mav.addObject("fortunelist",list);
		mav.addObject("humanno",humanno);
		mav.setViewName("fortune/fortune_list");
		return mav;
	}
	
	@RequestMapping("fortune/viewfortune.do")
	public ModelAndView view(int fortuneno) {
		ModelAndView mav = new ModelAndView();
		FortuneVO fortune = service.getFortune(fortuneno);
		mav.addObject("fortune",fortune);
		mav.setViewName("fortune/view_fortune");
		return mav;
	}
	
	@RequestMapping(value = "fortune/addfortune.do", method = RequestMethod.GET)
	public ModelAndView add(int humanno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("humanno", humanno);
		mav.setViewName("fortune/add_fortune");
		return mav;
	}
	
	@RequestMapping(value = "fortune/addfortune.do", method = RequestMethod.POST)
	public ModelAndView add_proc(int humanno, int innerfortune, int outerfortune, int changefortune,
			String details, String explainfortune,int fortuneyear,int fortunemonth,int fortuneday) {
		ModelAndView mav = new ModelAndView();
		FortuneVO fortune = new FortuneVO();
		String fortunedate = fortuneyear+"-"+fortunemonth+"-"+fortuneday;
		fortune.setChangefortune(changefortune);
		fortune.setDetails(details);
		fortune.setExplainfortune(explainfortune);
		fortune.setFortunedate(fortunedate);
		fortune.setHumanno(humanno);
		fortune.setInnerfortune(innerfortune);
		fortune.setOuterfortune(outerfortune);
		int check = service.addFortune(fortune);
		mav.addObject("check",check);
		mav.setViewName("fortune/add_fortune");
		return mav;
	}
	
	@RequestMapping(value = "fortune/deletefortune.do", method = RequestMethod.GET)
	public ModelAndView delete(int fortuneno,int humanno) {
		ModelAndView mav = new ModelAndView();
		service.deleteFortune(fortuneno);
		mav.setViewName("redirect:/fortune/fortunelist.do?humanno="+humanno);
		return mav;
	}
	
	@RequestMapping(value = "fortune/updatefortune.do", method = RequestMethod.GET)
	public ModelAndView update(int fortuneno) {
		ModelAndView mav = new ModelAndView();
		FortuneVO fortune = service.getFortune(fortuneno);
		mav.addObject("fortune", fortune);
		mav.setViewName("fortune/update_fortune");
		return mav;
	}
	
	@RequestMapping(value = "fortune/updatefortune.do", method = RequestMethod.POST)
	public ModelAndView update_proc(int fortuneno, int innerfortune, int outerfortune, int changefortune,
			String details, String explainfortune,String fortunedate) {
		ModelAndView mav = new ModelAndView();
		FortuneVO fortune = new FortuneVO();
		fortune.setChangefortune(changefortune);
		fortune.setDetails(details);
		fortune.setExplainfortune(explainfortune);
		fortune.setFortunedate(fortunedate);
		fortune.setFortuneno(fortuneno);
		fortune.setInnerfortune(innerfortune);
		fortune.setOuterfortune(outerfortune);
		int check = service.updateFortune(fortune);
		mav.addObject("check",check);
		mav.setViewName("redirect:viewfortune.do?fortuneno="+fortuneno);
		return mav;
	}
	
	
}
