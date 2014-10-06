package com.tmon.front.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tmon.front.domain.Article;
import com.tmon.front.repository.ArticleRepository;
import com.tmon.front.repository.MemberRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private ArticleRepository articleRepository;
	@Resource
	private MemberRepository memberRepository;
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="") String keyword){
		Page<Article> articlePage = articleRepository.getArticleList(keyword, page);
		ModelAndView mav = new ModelAndView();
		mav.addObject("articlePage", articlePage);
		mav.addObject("keyword", keyword);
		return mav;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void write(Article article){
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Article article, String id){
		article.setMember(memberRepository.findOne(id));
		logger.debug("article : {}",article);
		articleRepository.save(article);
		return "redirect:/article/list";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public Article read(int articleNo){
		Article article = articleRepository.findOne(articleNo);
		logger.debug("article : {}",article);
		return article;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(int articleNo){
		articleRepository.delete(articleNo);
		return "redirect:/article/list";
	}
	
}
