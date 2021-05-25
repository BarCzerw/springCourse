package com.sda.demo.promotion.rest;

import com.sda.demo.promotion.model.Promotion;
import com.sda.demo.promotion.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//nei dzialalo, bo bylo poza packagem z DemoApplication
//albo wywalic wyzej, albo dodac adnotacje wskazujaca gdzie przeszukiwac

@RestController
public class RestPromotion {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/promotionsDiv")
    private String showAllPromotionsDiv(){
        StringBuilder sb = new StringBuilder();
        promotionService.getPromotionList().forEach(promotion -> sb.append("<DIV>").append(promotion.toString()).append("</DIV>"));
        return sb.toString();
    }

    @GetMapping("/promotions")
    private List<Promotion> showAllPromotions() {
        return promotionService.getPromotionList();
    }

    @GetMapping("/promotionType")
    private List<Promotion> showFilteredPromotions(@RequestParam String type) {
        return promotionService.getPromotionListByFilter(type);
    }

}
