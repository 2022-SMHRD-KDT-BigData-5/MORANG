package com.smhrd.web;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.domain.Board;
import com.smhrd.domain.comment;
import com.smhrd.domain.diary;
import com.smhrd.mapper.BoardMapper;
import com.smhrd.mapper.commentMapper;

@Controller //어노테이션
// 이 파일이 알바생(POJO)이다
public class BoardController {


	@Autowired 
	BoardMapper mapper;
	@Autowired 
	commentMapper mapper2;

	@RequestMapping("/boardList.do") 
	public String boardList( Model model) {

		List<Board> list = mapper.boardList();


		model.addAttribute("list", list);


		return "boardList"; 
	}

	@GetMapping("/boardInsert.do")
	public String boardForm() {
		return "boardForm";
	}

//	@PostMapping("/boardInsert.do")
//	public String boardInsert(Board vo) {
//		mapper.boardInsert(vo);
//
//		return "redirect:/boardList.do";
//
//	}

	@PostMapping("/boardInsert.do")
	public String boardInsert(Board vo,HttpServletRequest request,HttpServletResponse response) {
		
		response.setCharacterEncoding("UTF-8");
		
		String c_title="";
		String u_id="";
		String c_content="";
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String realFolder = "";
		String c_file = "";
		int maxSize = 1024*1024*5;
		String encType = "UTF-8";
		String savefile = "img";
		
		realFolder="C:/Users/smhrd/git/MR/MORANG/src/main/webapp/resources/img";
		try{
			 MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			 Enumeration<?> files = multi.getFileNames();
		     String file1 = (String)files.nextElement();
		     c_file = multi.getFilesystemName(file1);
		     c_title=multi.getParameter("c_title");
		     u_id=multi.getParameter("u_id");
		     c_content=multi.getParameter("c_content");
		}catch(Exception e){
			e.printStackTrace();
		}
	
		String fullpath = "resources/img/"+c_file;
		

		vo.setC_title(c_title);
		vo.setU_id(u_id);
		vo.setC_content(c_content);
		vo.setC_file(fullpath);
		System.out.println(vo.getC_title());
		System.out.println(vo.getC_content());
		System.out.println(vo.getU_id());
		mapper.boardInsert(vo);
		
		return "redirect:/boardList.do";
	}
	
	@RequestMapping("boardContent.do") //Path Variable의 키값 선언
	public String boardContent(Model model,  int c_seq) {

		// 특정한 하나의 글 데이터를 가져오기
		Board vo = mapper.boardContent(c_seq);

		// 확인해보기
		System.out.println(vo.getC_title());
		
		// 객체 바인딩 request 영역에 저장
		model.addAttribute("board", vo);
		List<comment> commentlist = mapper2.commentList(c_seq);
		
		model.addAttribute("commentlist", commentlist);
		return "boardContent"; // Path Variable을 사용할 때는, 반드시 직접 view를 알려줄것
	}

	@RequestMapping("/boardDelete.do")
	public String boardDelete(int c_seq) {

		// 특정한 하나의 게시글 삭제
		mapper.boardDelete(c_seq);

		// 목록페이지 이동
		return "redirect:/boardList.do";
	}

	// Update페이지로 이동하는 Controller 필요
	@RequestMapping("/boardGoUpdate.do")
	public String boardGoUpdate(int c_seq, Model model) {

		// 특정 하나의 게시글 정보를 가져오기
		Board vo = mapper.boardContent(c_seq);

		// 저장(객체바인딩)
		model.addAttribute("board", vo);

		// boardUpdate.jsp로 이동
		// /WEB-INF/views/boardUpdate.jsp
		return "boardUpdate";
	}

	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) {

		// 사용자가 입력한 데이터로, update
		mapper.boardUpdate(vo);

		// (목록)페이지 이동
		return "redirect:/boardList.do";

	}
} 