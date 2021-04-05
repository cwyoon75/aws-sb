package com.spboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.test.entity.TrainerInfo;

public interface TrainerInfoRepository extends JpaRepository<TrainerInfo, Long> {

}
