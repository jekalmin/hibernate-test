package com.tmon.front.repository;

import org.springframework.data.repository.CrudRepository;

import com.tmon.front.domain.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer>{

}
