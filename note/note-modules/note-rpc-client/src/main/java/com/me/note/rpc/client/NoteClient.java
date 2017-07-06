package com.me.note.rpc.client;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.me.note.rpc.inout.NoteDetailReqeust;
import com.me.note.rpc.inout.NoteDetailResponse;
import com.me.note.rpc.service.IProductService;

@Service
public class NoteClient {
	@Resource
	IProductService iProductService;

	public String getNote() throws TException {
		// AbstractApplicationContext ctx=new
		// ClassPathXmlApplicationContext("classpath:spring-conf/spring-note-rpc-client.xml");
		// IProductService.Iface service=(IProductService.Iface
		// )ctx.getBean("iProductService");

		// IProductService.Iface iProductService = (Iface)
		// ctx.getBean("iProductService");
		NoteDetailReqeust rq = new NoteDetailReqeust(1);
		if (iProductService == null) {
			System.out.println("aaaa");
		}
		NoteDetailResponse rs = iProductService.getProduct(rq);
		return rs.getTitle();
	}
}
