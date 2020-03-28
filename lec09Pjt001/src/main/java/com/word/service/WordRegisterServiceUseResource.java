package com.word.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseResource {

	//@Resource는 property, method에 모두 사용이 가능하다. 단지 디폴트 생성자가 꼭 필요하다.
	//@Resource는 객체의 이름으로 찾는다.
	
	@Resource
//	@Qualifier("usedDao")
	private WordDao wordDao;
	
	public WordRegisterServiceUseResource() {
		
	}
	
	//@Resource
	public WordRegisterServiceUseResource(WordDao wordDao) {
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
	
	//@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}