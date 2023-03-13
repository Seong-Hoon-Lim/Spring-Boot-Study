package com.hooneystory.shoppingmall.controller;

import com.hooneystory.shoppingmall.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {

    @GetMapping(value = "/ex01")
    public String thymeleafExample01(Model model) {
        model.addAttribute("data", "타임리프 예제입니다.");
        return "thymeleafEx/thymeleafEx01";
    }

    /**
     * th:text 를 이용한 상품 데이터 출력용 컨트롤러
     * @param model
     * @return
     */
    @GetMapping(value = "/ex02")
    public String thymeleafExample02(Model model) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx02";
    }

    /**
     * th:each 를 이용한 상품 리스트 출력용 컨트롤러
     * @param model
     * @return
     */
    @GetMapping(value = "/ex03")
    public String thymeleafExample03(Model model) {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i = 1; i <= 10; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx03";
    }

    /**
     * th:if, th:unless (단일 조건)
     * th:sqitch, th:case (여러 조건)
     * 들을 활용한 조건문 처리용 컨트롤러
     * @param model
     * @return
     */
    @GetMapping(value = "/ex04")
    public String thymeleafExample04(Model model) {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i = 1; i <= 10; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx04";
    }

    /**
     * th:href 를 이용한 링크 처리용 컨트롤러
     * @return
     */
    @GetMapping(value = "/ex05")
    public String thymeleafExample05() {
        return "thymeleafEx/thymeleafEx05";
    }

    /**
     * th:href 를 이용한 파라미터 데이터 전달용 컨트롤러
     * @param param1
     * @param param2
     * @param model
     * @return
     */
    @GetMapping(value = "/ex06")
    public String thymeleafExample06(String param1, String param2, Model model) {
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thymeleafEx/thymeleafEx06";
    }

    /**
     * layout 을 활용한 예제 컨트롤러
     * @return
     */
    @GetMapping(value = "/ex07")
    public String thymeleafExample07() {
        return "thymeleafEx/thymeleafEx07";
    }


}
