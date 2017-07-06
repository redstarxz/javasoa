package com.me.note.rpc.inout;

import java.io.Serializable;

public class NoteQueryListResponse implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int pageNum;
public int getPageNum() {
	return pageNum;
}
public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
private int total;
private int pageSize;

}
