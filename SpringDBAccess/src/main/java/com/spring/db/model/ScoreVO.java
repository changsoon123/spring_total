package com.spring.db.model;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//create table scores(
//		stu_id int primary key AUTO_INCREMENT,
//	    sty_name VARCHAR(30) NOT NULL,
//	    kor INT DEFAULT 0,
//	    eng INT DEFAULT 0,
//	    math INT default 0,
//	    total int DEFAULT 0,
//	    average DECIMAL(5, 2)
//	);

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Controller
public class ScoreVO {
	
	private int stuId;
	private String stuName;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double average;
	
	//총점, 평균을 구하는 메서드
	public void calcData() {
		this.total = this.kor + this.eng + this.math;
		this.average = Math.round((this.total/3.0) * 100) / 100.0;
	}
}
