package com.tmon.front.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tmon.front.domain.Member;
import com.tmon.front.domain.MemberRole;
import com.tmon.front.repository.MemberRepository;

@Service
public class MemberService implements UserDetailsService{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	MemberRepository memberRepository;

	/**
	 * 로그인 체크
	 * UserDetails에 아이디와 비밀번호를 담아서 리턴하면 시큐리티가 알아서 사용자 입력값과 비교해서 처리해준다.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findOne(username);
		logger.debug("member : {}", member);
		logger.debug("role : {}", member.getRoles());
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for(MemberRole role : member.getRoles()){
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new User(member.getId(), member.getPassword(), roles);
	}

}
