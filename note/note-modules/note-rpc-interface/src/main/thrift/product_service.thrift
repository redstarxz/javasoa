namespace java com.me.note.rpc.thrift.service


include "product.thrift"

 
service IProductService {

    product.NoteQueryListResponse searchProduct(1:product.NoteQueryListReqeust req);
    
    product.NoteDetailResponse getProduct(1:product.NoteDetailReqeust req);
 
}
