package com.tmon.front.controller;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tmon.front.domain.Article;
import com.tmon.front.domain.QArticle;
import com.tmon.front.repository.ArticleRepository;
import com.tmon.front.repository.MemberRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private ArticleRepository articleRepository;
	
	@Resource
	private MemberRepository memberRepository;
	
	@Resource
	private EntityManagerFactory factory;
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="") String keyword){
		QArticle qArticle = QArticle.article;
		Page<Article> articlePage = articleRepository.findAll(
				qArticle.content.like("%"+keyword+"%").or(qArticle.title.like("%"+keyword+"%")), new PageRequest(page, 5));
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("articlePage", articlePage);
		mav.addObject("keyword", keyword);
		return mav;
	}
	
	@RequestMapping("/write")
	public void write(Article article){
	}
	
	@RequestMapping("/save")
	public String save(Article article, int memberSeq){
		article.setMember(memberRepository.findOne(memberSeq));
		System.out.println(article);
		articleRepository.save(article);
		return "redirect:/article/list";
	}
	
	@RequestMapping("/read")
	public Article read(int articleNo){
		Article article = articleRepository.findOne(articleNo);
		System.out.println(article);
		return article;
	}
	
	@RequestMapping("/delete")
	public String delete(int articleNo){
		articleRepository.delete(articleNo);
		return "redirect:/article/list";
	}
	
}
