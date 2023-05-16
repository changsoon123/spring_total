package com.spring.myweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.freeboard.service.IFreeBoardService;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {

	@Autowired
	private IFreeBoardService service;
	
	//목록 화면
	@GetMapping("/freeList")
	public void freeList(Model model) {
		model.addAttribute("boardList", service.getList());
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "freeBoard/freeRegist";
	}
	
	@PostMapping("/regist")
	public String regist(FreeBoardVO vo) {
		service.regist(vo);
		return "redirect:/freeBoard/freeList";
	}
	
	@GetMapping("/content/{bno}")
	public String content(@PathVariable int bno,Model model) {
		model.addAttribute("article",service.getContent(bno));
		return "freeBoard/freeDetail";	
	}
	
//	@GetMapping("/freeModify")
//	public void modify(int bno,Model model) {
//		model.addAttribute("updatecontent",service.getContent(bno));
//	}
	
	//글 수정 페이지 이동 처리
	@PostMapping("/modify")
	public String modify(@ModelAttribute("article") FreeBoardVO vo) {
		return "freeBoard/freeModify";
	}
	
	//글 수정 처리
	@PostMapping("/update")
	public String update(FreeBoardVO vo) {
		
		service.update(vo);
		return "redirect:/freeBoard/content?bno=" + vo.getBno();
	}
	
	//글 삭제 처리
	@PostMapping("/delete")
	public String delete(int bno) {
		service.delete(bno);
		return "redirect:/freeBoard/freeList";
	}
	
}
