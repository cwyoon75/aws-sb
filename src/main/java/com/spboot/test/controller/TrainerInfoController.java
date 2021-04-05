package com.spboot.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spboot.test.entity.TrainerInfo;
import com.spboot.test.repository.TrainerInfoRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TrainerInfoController {

	@Autowired
	private TrainerInfoRepository tiRepo;
	
	@PostMapping()
	public Long insert(TrainerInfo ti) {
		tiRepo.save(ti);
		log.info("ti=>{}",ti);
		return ti.getTiNum();
	}
	
	@GetMapping("/trainer-infos")
	public List<TrainerInfo> getTrainerInfos(){
		return tiRepo.findAll();
	}
}
