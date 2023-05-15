package com.spring.myweb.command;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//create TABLE freeboard(
//		bno INT primary KEY auto_increment,
//	    title VARCHAR(300) NOT NULL,
//	    writer VARCHAR(50) NOT NULL,
//	    content VARCHAR(3000) NOT NULL,
//	    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
//	    update_date DATETIME DEFAULT NULL
//
//	);

@Getter 
@Setter
@ToString
public class FreeBoardVO {

	private int bno;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	
}
