UrlUtil = {
	parse : function(url){
		var urlParameter = {};
		var httpCheck = /(http|https):\/\/.*/;
		
		if(!httpCheck.test(url)){
			url = 'http://' + url;
		}
		var a = document.createElement('a');
		a.href = url;
		var urlParamString = a.search;
		
		if(urlParamString.length > 1 && urlParamString.charAt(0) == '?'){
			var urlParamArray = urlParamString.substring(1).split('&');
			var i, len, eIdx, urlParam;
			for(i=0, len=urlParamArray.length; i < len; i+=1){
				urlParam = urlParamArray[i];
				eIdx = urlParam.indexOf('=');
				urlParameter[urlParam.substring(0, eIdx)] = decodeURIComponent(urlParam.substring(eIdx+1));
			}
			
		}
		return urlParameter;
	},
	stringify : function(obj){
		if(typeof obj != 'object'){
			return '';
		}
		var urlPairs = [];
		for(var key in obj){
			urlPairs.push(key + '=' + encodeURIComponent(obj[key]));
		}
		if(urlPairs.length < 1){
			return '';
		}
		return '?' + urlPairs.join('&');
	}
};