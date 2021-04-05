package com.spboot.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="member_info")
public class MemberInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mi_num")
	private Long miNum;
	@Column(name="mi_name")
	private String miName;
	@Column(name="mi_gender")
	private String miGender;
	@Column(name="mi_id")
	private String miId;
	@Column(name="mi_password")
	private String miPassword;
	@Column(name="mi_email")
	private String miEmail;
	@Column(name="mi_img")
	private String miImg;
	@Column(name="mi_phone")
	private String miPhone;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="mi_credat")
	private Date miCredat;
	@Transient
	private MultipartFile miFile;
	
	@Column(name = "ti_num")
	private Long tiNum;
	
	@ManyToOne
	@JoinColumn(name="ti_num")
	@JsonBackReference
	private TrainerInfo trainerInfo;
}
