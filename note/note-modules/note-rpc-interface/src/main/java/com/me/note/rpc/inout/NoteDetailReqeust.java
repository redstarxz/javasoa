package com.me.note.rpc.inout;

import java.io.Serializable;

public class NoteDetailReqeust implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoteDetailReqeust(int id)
	{
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
}
