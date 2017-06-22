namespace java com.me.note.rpc.thrift.inout



/**
* 用车产品实体
*/
struct NoteEntity{
	1:i32 id,
	2:string title,
	3:string content
}


/**
* 详情请求实体
*/
struct NoteDetailReqeust{
	1:i32 id
}

/**
* 详情请求实体
*/
struct NoteDetailResponse{
	1:string title,
	2:string content
	
}

/**
* 产品列表查询请求实体
*/
struct NoteQueryListReqeust{
	1:string type
}


/**
* 产品列表查询返回实体
*/
struct NoteQueryListResponse{
	1:i32 pageNum,
	2:i32 pageSize,
	3:i64 total,
	4:list<NoteEntity> listEntitys
}
