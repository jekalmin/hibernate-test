package com.tmon.front.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/front/*")
public class FrontController {

	@RequestMapping
	public ModelAndView index(String testData, HttpServletRequest request){
		System.out.println("testData : " + testData);
		System.out.println("getParameter: " + request.getParameter("testData"));
		System.out.println("getAttribute : " + request.getAttribute("testData"));
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
}
