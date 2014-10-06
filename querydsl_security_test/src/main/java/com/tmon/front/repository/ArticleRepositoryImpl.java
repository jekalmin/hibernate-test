package com.tmon.front.repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;

import com.tmon.front.domain.Article;
import com.tmon.front.domain.QArticle;

@Repository
public class ArticleRepositoryImpl implements ArticleRepositoryCustom{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@PersistenceContext
	private EntityManager em;
	
	private QueryDslJpaRepository<Article, Integer> articleRepository;
	
	@PostConstruct
	public void init(){
		JpaEntityInformation<Article, Integer> articleEntityInfo = new JpaMetamodelEntityInformation<Article, Integer>(Article.class, em.getMetamodel());
		articleRepository = new QueryDslJpaRepository<Article, Integer>(articleEntityInfo, em);
	}
	
	@Override
	public Page<Article> getArticleList(String keyword, int page) {
		QArticle qArticle = QArticle.article;
		
		Page<Article> articlePage = articleRepository.findAll(
				qArticle.content.like("%"+keyword+"%").or(qArticle.title.like("%"+keyword+"%")), new PageRequest(page, 5));
		return articlePage;
	}

}
