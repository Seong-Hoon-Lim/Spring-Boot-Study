/*
 * 컨트롤러
 * 목록,등록,상세화면 매핑,등록 액션 메서드를 생성해주었고, 목록에는 페잊이 처리르 위한 파라미터를 받는다.
 */

package com.board.study.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.study.dto.board.BoardRequestDto;
import com.board.study.service.BoardService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Controller
public class BoardController {

	@Autowired
	private final BoardService boardService;
	
	@GetMapping("/board/list")
	public String getBoardListPage(Model model, @RequestParam(required = false, defaultValue = "0") 
	Integer page, @RequestParam(required = false, defaultValue = "5") Integer size) 
			throws Exception {
				try {
					model.addAttribute("resultMap", boardService.findAll(page, size));
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
				
				return "list";
	}
	
	@GetMapping("/board/write")
	public String getBoardWritePage(Model model, BoardRequestDto boardRequestDto) {
		return "write";
	}
	
	@GetMapping("board/view")
	public String getBoardViewPage(Model model, BoardRequestDto boardRequestDto) 
			throws Exception {	
				try {
					if (boardRequestDto.getId() != null) {
						model.addAttribute("info", boardService.findById(boardRequestDto.getId()));
					}
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
				
				return "view";		
		
	}
	@PostMapping
	public String boardWriteAction(Model model, BoardRequestDto boardRequestDto) 
			throws Exception {
				try {
					Long result = boardService.save(boardRequestDto);
					
					if (result < 0) {
						throw new Exception("#Exception boardWriteAction");
					}
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
				return "redirect:/board/list";
	}
}
