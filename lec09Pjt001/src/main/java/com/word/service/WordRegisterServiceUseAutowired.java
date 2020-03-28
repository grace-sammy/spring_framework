package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseAutowired {

	//@Autowired는 생성자,property, method에 모두 사용이 가능하다. 단지 property와 method에 사용할 경우 디폴트 생성자가 꼭 필요하다.
	//@Autowired는 객체의 타입으로 찾는다.
	@Autowired
//	@Qualifier("usedDao")
	private WordDao wordDao;
	
	public WordRegisterServiceUseAutowired() {
		//@AutoWired는 생성자,property, method에 모두 사용이 가능하다. 단지 property와 method에 사용할 경우 디폴트 생성자가 꼭 필요하다.
	}
	
//	@Autowired
	public WordRegisterServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
