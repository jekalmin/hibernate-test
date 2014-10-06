package com.tmon.front.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tmon.front.domain.Article;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer>,
										QueryDslPredicateExecutor<Article>, ArticleRepositoryCustom{

}
