package com.example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="education")
public class EducationVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ed_id;
	
	//0102 찬주 검색으로 인해 변경
	@Column(name="ed_title")
	private String edTitle;
	
	//0103 찬주 검색으로 인해 변경
	@Column(name="ed_name")
	private String edName;
	
	private Date ed_enlist_date;
	private Date ed_start_date;
	private Date ed_end_date;
	private String ed_addr;
	private Integer ed_price;
	private String ed_intro;
	private String ed_keyword;
	private String ed_time;
	private String ed_comm;
	private String ed_curriculum;
	private Boolean ed_tf;
	
}
