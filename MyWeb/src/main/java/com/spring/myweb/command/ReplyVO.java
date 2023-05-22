package com.spring.myweb.command;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * 
 * CREATE TABLE freeaply(
	rno INT primary KEY AUTO_INCREMENT,
    bno INT,
    FOREIGN KEY (bno) 
    references freeboard(bno)
    ON delete cascade,
    
    reply VARCHAR(1000),
    reply_id VARCHAR(50),
    reply_pw VARCHAR(50),
    reply_date DATETIME default CURRENT_TIMESTAMP,
    update_date DATETIME default NULL
);
 * 
 */
@Getter
@Setter
@ToString
public class ReplyVO {

	private int rno;
	private int bno;
	
	private String reply;
	private String replyId;
	private String replyPw;
	private LocalDateTime replyDate;
	private LocalDateTime updateDate;
	
	
}
