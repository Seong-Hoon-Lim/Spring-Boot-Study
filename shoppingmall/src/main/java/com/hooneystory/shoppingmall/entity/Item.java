package com.hooneystory.shoppingmall.entity;

import com.hooneystory.shoppingmall.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 상품 클래스
 * Item 클래스를 엔티티로 선언 하고 item 테이블과 매핑
 * name을 item 으로 지정
 * 엔티티 선언된 클래스는 반드시 기본키가 있어야 하므로 id 멤버변수에 @Id 붙여줌
 */

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)//JPA 구현체가 자동으로 생성 전략 결정
    private Long id;    //상품 코드(상품 id)

    @Column(nullable = false, length = 50)  //null 값의 허용 여부 설정. false 설정 시 DDL 생성 시에 NOT NULL 조건부여
    private String itemNm;   //상품명

    @Column(name = "price", nullable = false)
    private int price;  //상품가격

    @Column(nullable = false)
    private int stockNumber; //상품 재고 수량

    @Lob    //데이터를 DB 외부에 저장하기 위한 타입 매핑
    @Column(nullable = false)
    private String itemDetail;  //상품 상세 설명

    @Enumerated(EnumType.STRING)    //enum 타입 String 으로 매핑
    private ItemSellStatus itemSellStatus; //상품 판매 상태

    private LocalDateTime regTime;  //상품 등록 시간

    private LocalDateTime updateTime;   //상품 수정 시간

}
