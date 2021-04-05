package com.spboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.test.entity.MemberInfo;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {

	
}
