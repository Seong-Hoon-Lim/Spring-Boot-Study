/**
 * 게시판 요청 데이터를 담당
 * 게시물 등록, 수정, 상세 조회에 필요한 필드를 정의한다.
 * toEntity() 메서드는 Board Entity 를 builder 하여 사용한다.
 *
 */

package com.board.study.dto.board;

import com.board.study.entity.board.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequestDto {
	
	private Long id;
	private String title;
	private String content;
	private String registerId;
	
	public Board toEntitiy() {
		return Board.builder()
				.title(title)
				.content(content)
				.registerId(registerId)
				.build();
	}
	

}
