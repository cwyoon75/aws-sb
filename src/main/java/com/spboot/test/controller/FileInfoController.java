package com.spboot.test.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spboot.test.entity.FileInfo;
import com.spboot.test.repository.FileInfoRepositoty;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileInfoController {
	
	@Autowired
	private FileInfoRepositoty fileInfoRepo;
	
	private final static String ROOT ="C:\\study\\workspace11\\aws-sb\\src\\main\\webapps\\resources\\";
	@PostMapping("/file-info")
	public @ResponseBody Integer insert(FileInfo fileInfo) throws Exception {
		String fiName = fileInfo.getFiFile().getOriginalFilename();
		if(fiName==null) {
			throw new Exception("파일은 필수 항목입니다!");
		}
		int idx = fiName.lastIndexOf(".");
		String extName = fiName.substring(idx);
		String path =ROOT+ System.nanoTime()+extName;
		fileInfo.setFiName(fiName);
		fileInfo.setFiPath(path);
		fileInfoRepo.save(fileInfo);
		if(fileInfo.getFiNum()==null) {
			throw new Exception("저장시 오류 발생");
		}
		File f = new File(path);
		fileInfo.getFiFile().transferTo(f);
		log.info("fileInfo=>{}",fileInfo);
		return 1;
	}
	
}
