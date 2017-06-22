package com.me.note.service;

import java.util.List;

import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.TException;

import com.me.note.rpc.thrift.inout.NoteDetailResponse;
import com.me.note.dao.entity.Notes;
import com.me.note.dao.mapper.NotesMapper;
import com.me.note.rpc.thrift.inout.NoteDetailReqeust;

import com.me.note.rpc.thrift.inout.NoteQueryListReqeust;
import com.me.note.rpc.thrift.inout.NoteQueryListResponse;
import com.me.note.rpc.thrift.service.IProductService.Iface;



public class ProductService implements Iface {

	private Logger log = LogManager.getRootLogger();
	


	@Resource
	NotesMapper  notesMapper;

	
    public NoteQueryListResponse searchProduct(NoteQueryListReqeust req) throws TException {
    	NoteQueryListResponse response = null;
	
		return response;
    }

	/**
	 * 单个产品详情查询
	 * @param req 请求参数
	 * @return 返回值
	 */
    public NoteDetailResponse getProduct(NoteDetailReqeust req) throws TException {
    	NoteDetailResponse response = null;
		try {
			// mybatis  conn
			 List<Notes>  notes = notesMapper.selectAll();
			 String s = "";
			 String c = "";
			 for (Notes note : notes){
				 s += note.getTitle();
				 c += note.getContent();
			 }
			 response = new NoteDetailResponse(s,c);

		}catch (Exception ex) {
		
		} finally {
		
		}
		return response;
    }
	
}
