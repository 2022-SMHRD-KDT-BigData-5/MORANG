package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.smhrd.domain.Board;

// 추상메서드만 가지는 interface로 구현
public interface BoardMapper {
	
	// 추상메서드 
	// 태그에 주는 id == 메서드 이름
	public List<Board> boardList();  // selectList()
	
	public int boardInsert(Board vo);
	
	public Board boardContent(int c_seq); // selectOne()
	
	// insert/delete/update --> int 반환
	// 어노테이션을 이용한 sql문 작성
	// 어노테이션 이름 == 사용하고자 하는 문장이름
	// @Delete("SQL 쿼리)
	// 추상 메서드 <---mapping(1 : 1) --> SQL쿼리
	@Delete("delete from mr_community where c_seq =#{c_seq}")
	public int boardDelete(int c_seq);
	
	public int boardUpdate(Board vo);
	// 조회수
	public int viewUpdate(Board vo);
	
	
	
}
