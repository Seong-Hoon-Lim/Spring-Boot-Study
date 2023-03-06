package com.hooneystory.shoppingmall.repository;

import com.hooneystory.shoppingmall.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
