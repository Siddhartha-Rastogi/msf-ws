package com.msf.ecm.restws.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.msf.ecm.restws.services.DocuSignService;

@RestController
@RequestMapping("docu-sign")
public class DocuSignController {
	@Autowired
	DocuSignService docuSingServiceObj;
	
	
	
	@RequestMapping(value="/GetMsg",method=RequestMethod.GET)
	public String getSpringBootMsg(){
		
		return "hello";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, 
			value = "generateEnvelopes", 
			consumes=MediaType.MULTIPART_FORM_DATA_VALUE,	
			produces={MediaType.APPLICATION_XML_VALUE+";charset=UTF-8", MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8"},	
			headers="Accept=application/json" )
	public String generateEnvelope(HttpServletRequest request, 
			@RequestParam(value = "metadata", required=true) String json, 
			@RequestParam(value = "file", required = true) MultipartFile file) {														/*public @ResponseBody String ingestDocument(			HttpServletRequest request,			@RequestParam(value = "metadata", required=true) String json,			@RequestParam(value="file", required=true) MultipartFile file) throws DctmException, ServiceException, ServiceBadRequestException  {*/
		String strReturned = docuSingServiceObj.generateEnvelopes(request, json, file);
		
		return strReturned;
	}
	
}
