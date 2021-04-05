package com.spboot.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spboot.test.entity.ExhibitonInfo;
import com.spboot.test.repository.ExhibitionRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ExhibitonInfoController {

	@Autowired
	private ExhibitionRepository eiRepo;
	@PostMapping("/exhibition")
	public @ResponseBody int insert(@RequestBody ExhibitonInfo ei) {
		log.info("ei=>{}",ei);
		eiRepo.save(ei);
		return ei.getEiNum();
	}
	
	@GetMapping("/exhibitions")
	public @ResponseBody List<ExhibitonInfo> getExhibitionInfos(){
		return null;
	}
}
