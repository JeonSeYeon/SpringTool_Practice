package com.inhatc.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BoardVO1{
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
}

