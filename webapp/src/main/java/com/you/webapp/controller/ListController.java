package com.you.webapp.controller;


//import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;

import com.you.webapp.vo.request.Batparam;

import com.me.note.rpc.client.NoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "list", tags = "note list")
@Controller
public class ListController {  
	
	
	@Autowired
	public NoteClient noteClient;
	
	
	
    @ApiOperation(value = "one", notes = "tow")
    @ResponseBody
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public  String test() throws Exception {
    	//  access dubbo domain-service
    	return noteClient.getNote();  	
    }  
    
    
    @ApiOperation(value = "one", notes = "tow")
    @ResponseBody
    @RequestMapping(value="/bat", method = RequestMethod.POST)
    public  String bat(@Valid @RequestBody Batparam btp) throws Exception {
    	//  access dubbo domain-service
    	return "tttttttttttt";

    	//return noteClient.getNote();  	
    } 
}