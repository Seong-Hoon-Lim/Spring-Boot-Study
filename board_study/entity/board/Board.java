/**
 * board 테이블의 @Entity(독립체)
 * Entity를 정의한다.
 * 테이블의 모든 필드와 Builder 생성자를 구현한다.
 * 혹시나 테이블명이 Class명과 다를 경우 @Entity(name="테이블명")을 설정한다
 */

package com.board.study.entity.board;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private int readCnt;
	private String registerId;
	
	@Builder
	public Board(Long id, String title, String content, int readCnt, String registerId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.readCnt = readCnt;
		this.registerId = registerId;
		
	}

	public LocalDateTime getRegisterTime() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
