package com.tmon.front.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tmon.front.domain.Member;

public interface MemberRepository extends PagingAndSortingRepository<Member, Integer>, QueryDslPredicateExecutor<Member>{

}
