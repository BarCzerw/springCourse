package com.sda.demo.promotion.service;

import com.sda.demo.promotion.model.Promotion;
import com.sda.demo.promotion.model.PromotionType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionService {

    private List<Promotion> promotionList;

    public PromotionService() {
        this.promotionList = List.of(
                new Promotion("first time client", 10, PromotionType.ONE_TIME),
                new Promotion("weekend", 5, PromotionType.TIMED),
                new Promotion("monday opening", 10, PromotionType.TIMED),
                new Promotion("promo code", 20, PromotionType.ONE_TIME)
        );
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public List<Promotion> getPromotionListByFilter(String filter) {
        return promotionList.stream().filter(promotion -> promotion.getType() == PromotionType.valueOf(filter)).collect(Collectors.toList());
    }
}
