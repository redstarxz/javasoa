package com.me.note.rpc.service;

public interface IProductService {
	public com.me.note.rpc.inout.NoteQueryListResponse searchProduct(com.me.note.rpc.inout.NoteQueryListReqeust req) ;

    public com.me.note.rpc.inout.NoteDetailResponse getProduct(com.me.note.rpc.inout.NoteDetailReqeust req);
}
