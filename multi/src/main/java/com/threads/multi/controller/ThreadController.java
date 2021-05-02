package com.threads.multi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;



import com.threads.multi.MultiApplication;
import com.threads.multi.service.ThreadService;




@RestController
public class ThreadController {
	
	public static Logger logger = LoggerFactory.getLogger(MultiApplication.class);
	public  static volatile int count=0;

	public static int counter = 1; // a global counter

	@Autowired
	ThreadService threadservice;

	// @Autowired
	// ThreadService2 threadservice2; Alternative check
	
	@GetMapping("/")
	public ResponseEntity<String> ThreadMethod(){
		
		Thread t1 = new Thread( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (count <15) {
					count++;
					System.out.println("value of count is "+count+" current thread is"+Thread.currentThread().getName());
				}
				
			}
		});
		
		Thread t2 = new Thread( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (count <15) {
					count++;
					System.out.println("value of count is "+count+" current thread is"+Thread.currentThread().getName());
				}
				
			}
		});
		
		
		t2.start();
		try{
			Thread.sleep(30);
//			t2.start();
			
		} catch (Exception e) {
			// TODO: handle exception
			 ResponseEntity.status(500);
			 ResponseEntity.ok().body("status : failed");
//			 return new ResponseEntity<String>("Status: failed", 500);
		}
		// t2.start();
		System.out.println("t1 state is "+t1.getState());
		System.out.println("t2 state is "+t2.getState());

		
		
		
		return ResponseEntity.ok().body("status : suceess");
	}

	@GetMapping("/thread")
	public ResponseEntity<String> ThreadMethod1(){
		Thread thread1 = new Thread(threadservice);
        Thread thread2 = new Thread(threadservice);

		thread1.start();
        thread2.start();




		return ResponseEntity.ok().body("status : suceess");
	}



}
