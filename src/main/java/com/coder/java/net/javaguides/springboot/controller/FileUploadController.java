package com.coder.java.net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.coder.java.net.javaguides.springboot.helper.FileUploadHelper;

@RestController
@RequestMapping("/api/fileupload")
public class FileUploadController {
	
	@Autowired
    private FileUploadHelper fileUploadHelper;
	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)  
 public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		System.out.println(file.getOriginalFilename());
		try {
			if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Cotain File");
		}
		if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Jpeg type is allowed");
		}
		boolean f =  fileUploadHelper.fileupload(file);
		if(f) {
			return ResponseEntity.ok("File Succesfully Uploaded");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	 return ResponseEntity.ok(file.getOriginalFilename());
 }
}
