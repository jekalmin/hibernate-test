<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${articlePage.getContent()}" var="article">
	<a href="/article/read?articleNo=${article.articleNo}" class="read">${article}</a>
	<a href="/article/delete?articleNo=${article.articleNo}">삭제</a><br/>
</c:forEach>
<a href="/article/write">글쓰기</a>
<input type="text" id="keyword" value="${keyword}"/> <button id="searchBtn">검색</button>
<c:if test="${articlePage.hasPrevious()}">
	<a href="/article/list?page=${articlePage.getNumber()-1}" id="prev">이전페이지</a>
</c:if>
<c:if test="${articlePage.hasNext()}">
	<a href="/article/list?page=${articlePage.getNumber()+1}" id="next">다음페이지</a>
</c:if>
<script type="text/javascript" src="/js/urlutil.js"></script>
<script type="text/javascript">

	var urlParam = UrlUtil.parse(location.href);
	function search(){
		delete urlParam.page;
		urlParam.keyword = keyword.value;
		location.href = location.pathname + UrlUtil.stringify(urlParam);
	}
	searchBtn.onclick = search;
	keyword.onkeydown = function(e){
		if(e.keyCode == 13){
			search();
		}
	}

	function goPage(num){
		urlParam.page = num;
		location.href = location.pathname + UrlUtil.stringify(urlParam);
	}
	var prev = document.querySelector('#prev');
	if(prev){
		prev.onclick = function(){
			goPage(UrlUtil.parse(this.href).page);
			return false;
		}
	}
	var next = document.querySelector('#next');
	if(next){
		next.onclick = function(){
			goPage(UrlUtil.parse(this.href).page);
			return false;
		}
	}
	var reads = document.querySelectorAll('.read');
	Array.prototype.forEach.call(reads, function(element){
		element.onclick = function(){
			urlParam.articleNo = UrlUtil.parse(this.href).articleNo;
			location.href = this.pathname + UrlUtil.stringify(urlParam);
			return false;
		}
	});
	
	
</script>
</body>
</html>