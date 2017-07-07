package com.me.note.rpc.client;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		
		
		ExecutorService exe = Executors.newFixedThreadPool(10);
		// 构建完成服务
		ExecutorCompletionService<String> completionService = new ExecutorCompletionService<String>(exe);

		for (int i = 0; i < 50; i++) {
			completionService.submit(new Child());
		}

		for (int i = 0; i < 50; i++) {
			try {
				String y = completionService.take().get();
				System.out.println(y);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("All threads Done!");
		exe.shutdown();

	}

	public static IProductService service;

}

class Child implements Callable<String> {
	public String call() throws Exception {
		String s = "";
		for (int i = 0; i < 100; i++) {
			NoteDetailReqeust rq = new NoteDetailReqeust(1);
			NoteDetailResponse rs = Test.service.getProduct(rq);
			s += rs.getTitle();
		}
		return s;

	}
}
