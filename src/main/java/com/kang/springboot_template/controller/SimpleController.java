package com.kang.springboot_template.controller;

import java.util.ArrayList;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class SimpleController {
	@SuppressWarnings("rawtypes")
	ArrayList<DeferredResult> list = new ArrayList<DeferredResult>();
	
	@RequestMapping("/")
	String home() {
		getQuoteAndUpdateClients();
		return "see localhost:8080/index.html";
	}
	
	@RequestMapping(value = "/getQuote.do", method = RequestMethod.POST)
	public DeferredResult<String> getQuote() {
		final DeferredResult<String> deferredResult = new DeferredResult<String>();
		list.add(deferredResult);
		return deferredResult;
	}
	public void getQuoteAndUpdateClients(){ 
	      String quote = String.valueOf((int)(Math.random()*100));
	      for (int i = 0; i < list.size(); i++) {
	    	@SuppressWarnings("unchecked")
			DeferredResult<String> defer =list.get(i);
	    	defer.setResult(quote);
		}
	      for (int i = 0; i < list.size(); i++) {
	    		list.remove(i); 
	      }
	 }
	 @Scheduled(fixedDelay = 5000)
	    public void AutoDone() {
		 getQuoteAndUpdateClients();
	    }
}
