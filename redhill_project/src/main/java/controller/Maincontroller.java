package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Maincontroller {
	@RequestMapping("/main/main.do")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/main");
		return mav;
	}
	@RequestMapping("/main/about.do")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/main/about");
		return mav;
	}
}
