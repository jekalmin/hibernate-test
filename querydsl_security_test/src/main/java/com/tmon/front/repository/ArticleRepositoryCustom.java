package com.tmon.front.repository;

import org.springframework.data.domain.Page;

import com.tmon.front.domain.Article;

public interface ArticleRepositoryCustom {

	public Page<Article> getArticleList(String keyword, int page);
}
