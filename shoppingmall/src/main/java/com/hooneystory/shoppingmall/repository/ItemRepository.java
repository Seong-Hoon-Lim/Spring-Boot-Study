package com.hooneystory.shoppingmall.repository;

import com.hooneystory.shoppingmall.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {

    /**
     * 상품명을 이용하여 데이터를 조회하는 쿼리 메소드
     * 매개변수로는 검색할 때 사용할 상품명 변수를 전달
     * @param itemNm
     * @return
     */
    List<Item> findByItemNm(String itemNm);

    /**
     * 상품명과 상품 상세 설명을 OR 조건을 이용하여
     * 조회하는 쿼리 메소드
     * @param itemNm
     * @param itemDetail
     * @return
     */
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    /**
     * 파라미터로 넘어온 price 변수보다 값이 작은 상품 데이터를
     * 조회하는 쿼리 메소드
     * @param price
     * @return
     */
    List<Item> findByPriceLessThan(Integer price);

    /**
     * LessThan 으로 출력된 결과를 오름차순으로 정렬 조회
     * 상품의 가격이 높은 순으로 조회하는 쿼리 메소드
     * @param price
     * @return
     */
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    /**
     * @Query 어노테이션을 이용하여 상품 데이터를 조회하는 쿼리 메소드
     * 상품 상세 설명을 파라미터로 받아 해당 내용을 상품 상세 설명에 포함하고 있는
     * 데이터를 조회하며, 정렬 순서는 가격이 높은 순으로 조회
     * @param itemDetail
     * @return
     */
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    //JPQL 로 작성한 쿼리문 from 뒤에는 엔티티 클래스 Item을 i 로 지정 하고 Item으로부터 데이터를 select 한다.
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
    //파라미터에 @Param 어노테이션을 이용하여 itemDetail 변수를 "like % % 사이에 :itemDetail 로 지정"

    /**
     * 기존 데이터베이스에서 사용하던 쿼리를 그대로 사용해야 할 떄
     * @Query의 nativeQuery 속성을 사용하여 기존 쿼리를 그대로 사용하는 쿼리 메소드
     * 특정 데이터베이스에 종속되기 때문에 복잡한 통계용 쿼리에 활용하는 것이 좋다
     * @param itemDetail
     * @return
     */
    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc"
                       , nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);

}
