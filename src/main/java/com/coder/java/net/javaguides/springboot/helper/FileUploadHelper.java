package com.coder.java.net.javaguides.springboot.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
public final String UPLOAD_DIR = "C:\\Users\\ahmed.zeb\\eclipse-workspace\\springboot-crud-hibernate\\src\\main\\resources\\static\\ImageUpload";
public boolean fileupload(MultipartFile multiPart) {
	boolean f = false;
	try {
		//InputStream IS = multiPart.getInputStream();
		//byte data[]  = new byte[IS.available()];
		//IS.read(data);
		//FileOutputStream OS = new FileOutputStream(UPLOAD_DIR+File.separator+ multiPart.getOriginalFilename());
		//OS.write(data);
		//OS.flush();
		//OS.close();
		Files.copy(multiPart.getInputStream(), Paths.get(UPLOAD_DIR+  File.separator+multiPart.getOriginalFilename()),  StandardCopyOption.REPLACE_EXISTING);
		f = true;
	} catch(Exception e)
    {
		e.printStackTrace();
	}
	return f;
}
}
