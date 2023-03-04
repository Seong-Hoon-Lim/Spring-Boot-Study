/**
 * JpaRepository 구현체
 * JpaRepositroy를 상속받아 CRUD의 기능을 담당하는 인터페이스를 생성한다.
 * 그리고 @Query를 사용한 JPQL 방식의 updateBoard() 메서드도 구현해본다.
 * 이 방식으로 쿼리를 직접 작성하여 사용할 수도 있다.
 *
 */

package com.board.study.entity.board;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.board.study.dto.board.BoardRequestDto;


public interface BoardRepository extends JpaRepository<Board, Long> {
	
	String UPDATE_BOARD = "UPDATE Board " +
	"SET TITLE = :#{#boardRequestDto.title} , " +
	"CONTENT = :#{#boardRequestDto.content} , " +
	"UPDATE_TIME = NOW() " +
	"WHERE ID = :#{#boardRequestDto.id}";
	
	@Transactional
	@Modifying
	@Query
	public int updateBoard(@Param("boardRequestDto") BoardRequestDto boardRequesDto);

	public Long save(Long id);

}
