package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import biz.fortune.service.FortuneService;
import biz.human.service.HumanService;
import biz.human.vo.HumanVO;

@Controller
public class HumanController {
	@Autowired
	HumanService service;
	
	@Autowired
	FortuneService service2;
	
	@RequestMapping("human/humanlist.do")
	public ModelAndView list(@RequestParam(value="humanlist", required=false) List<HumanVO> humanlist) {
		ModelAndView mav = new ModelAndView();
		List<HumanVO> list = service.getHumanList();
		mav.addObject("humanlist",list);	
		mav.setViewName("human/human_list");
		return mav;
	}
	
	@RequestMapping("human/viewhuman.do")
	public ModelAndView view(int humanno) {
		ModelAndView mav = new ModelAndView();
		HumanVO human = service.getHuman(humanno);
		mav.addObject("human",human);
		mav.setViewName("human/view_human");
		return mav;
	}
	
	@RequestMapping(value = "human/addhuman.do", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("human/add_human");
		return mav;
	}
	
	@RequestMapping(value = "human/addhuman.do", method = RequestMethod.POST)
	public ModelAndView add_proc(String name, String sex, String sunmoon, int birthyear,
			int birthmonth, int birthday, int birthhour, int birthminute, String phonenumber, String details) {
		ModelAndView mav = new ModelAndView();
		HumanVO human = new HumanVO();
		human.setBirthday(birthday);
		human.setBirthhour(birthhour);
		human.setBirthminute(birthminute);
		human.setBirthmonth(birthmonth);
		human.setBirthyear(birthyear);
		human.setDetails(details);
		human.setName(name);
		human.setPhonenumber(phonenumber);
		human.setSex(sex);
		human.setSunmoon(sunmoon);
		int check = service.addHuman(human);
		mav.addObject("check",check);
		mav.setViewName("human/add_human");
		return mav;
	}
	
	@RequestMapping(value = "human/deletehuman.do", method = RequestMethod.GET)
	public ModelAndView delete(int humanno) {
		ModelAndView mav = new ModelAndView();
		service2.deleteHuman(humanno);
		service.deleteHuman(humanno);
		mav.setViewName("redirect:/human/humanlist.do");
		return mav;
	}
	
	@RequestMapping(value = "human/updatehuman.do", method = RequestMethod.GET)
	public ModelAndView update(int humanno) {
		ModelAndView mav = new ModelAndView();
		HumanVO human= service.getHuman(humanno);
		mav.addObject("human",human);
		mav.setViewName("human/update_human");
		return mav;
	}
	
	@RequestMapping(value = "human/updatehuman.do", method = RequestMethod.POST)
	public ModelAndView update_proc(String name, String sex, String sunmoon, int birthyear,
		int birthmonth, int birthday, int birthhour, int birthminute, String phonenumber, String details,int humanno) {
		ModelAndView mav = new ModelAndView();
		HumanVO human = new HumanVO();
		human.setBirthday(birthday);
		human.setBirthhour(birthhour);
		human.setBirthminute(birthminute);
		human.setBirthmonth(birthmonth);
		human.setBirthyear(birthyear);
		human.setDetails(details);
		human.setName(name);
		human.setPhonenumber(phonenumber);
		human.setSex(sex);
		human.setSunmoon(sunmoon);
		human.setHumanno(humanno);
		int check = service.updateHuman(human);
		mav.addObject("check",check);
		mav.setViewName("redirect:/human/viewhuman.do?humanno="+human.getHumanno());
		return mav;
	}
	
	@RequestMapping("human/searchhuman.do")
	public ModelAndView search(String name) {
		ModelAndView mav = new ModelAndView();
		List<HumanVO> humanlist = service.searchHuman(name);
		System.out.println(humanlist);
		mav.addObject("humanlist",humanlist);
		mav.setViewName("/human/human_list");
		return mav;
	}
}