package com.me.note.rpc.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.me.note.rpc.inout.NoteDetailReqeust;
import com.me.note.rpc.inout.NoteDetailResponse;
import com.me.note.rpc.service.IProductService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring-conf/spring-note-rpc-client.xml");
		service = (IProductService) ctx.getBean("iProductService");
		for (int i = 0; i < 10; i++) {
			new Thread(new Child()).start();
			
		}
	}

	public static IProductService service;

}

class Child implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			NoteDetailReqeust rq = new NoteDetailReqeust(1);
			NoteDetailResponse rs = Test.service.getProduct(rq);
			System.out.println(rs.getTitle());
		}
	}
}
