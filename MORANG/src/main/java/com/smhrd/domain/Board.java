package com.smhrd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data                // 기본 메서드(Getter/Setter/toString) 생성
@AllArgsConstructor  // 모든 필드를 요소로 갖는 생성자 생성
@NoArgsConstructor   // 기본생성자
@RequiredArgsConstructor  // 필요한 필드만 요소로 갖는 생성자 생성
public class Board {

	// 약속 1. VO의 필드(변수)이름 == Table의 컬럼명 
	// 약속 2. 반! 드! 시! 기본생성자는 있어야 한다.
	
	
	// 글번호
	private int c_seq;
	// 제목
	@NonNull
	private String c_title;
	// 내용
	@NonNull
	private String c_content;
	
	// 글 작성일
	private String c_date;
	
	// 글 첨부파일
	@NonNull
	private String c_file;
	
	// 작성자
	@NonNull
	private String u_id;

	// 조회수(추천수)
	private int c_likes;
	
	
	
}
