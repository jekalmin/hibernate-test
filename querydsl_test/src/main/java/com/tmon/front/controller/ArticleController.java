package com.tmon.front.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmon.front.domain.Article;
import com.tmon.front.domain.QArticle;
import com.tmon.front.repository.ArticleRepository;

@Controller
@RequestMapping("/article/*")
public class ArticleController {

	@Resource
	private ArticleRepository articleRepository;
	
	@Resource
	private EntityManagerFactory factory;
	
	@RequestMapping
	public List<Article> list(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="") String keyword){
		QArticle qArticle = QArticle.article;
		
		Page<Article> articlePage = articleRepository.findAll(
				qArticle.content.like("%"+keyword+"%").or(qArticle.title.like("%"+keyword+"%")), new PageRequest(page, 5));
		List<Article> articleList = articlePage.getContent();
		System.out.println(articleList);
		return articleList;
	}
	
	@RequestMapping
	public void write(Article article){
	}
	
	@RequestMapping
	public void writeAction(Article article){
		System.out.println(article);
		articleRepository.save(article);
	}
	
	@RequestMapping
	public void read(int articleNo){
		System.out.println(articleRepository.findOne(articleNo));
	}
	
	@RequestMapping(value="/modify/{articleNo}/{member.seq}/{title}/{content}")
	public void modify(Article article){
		System.out.println(articleRepository.save(article));
	}
	
	@RequestMapping
	public void delete(int articleNo){
		articleRepository.delete(articleNo);
	}
	
}
