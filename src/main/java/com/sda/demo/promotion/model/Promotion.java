package com.sda.demo.promotion.model;

public class Promotion {

    private String name;
    private Integer discount;
    private PromotionType type;

    public Promotion(String name, Integer discount, PromotionType type) {
        this.name = name;
        this.discount = discount;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getDiscount() {
        return discount;
    }

    public PromotionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "name='" + name + '\'' +
                ", discount=" + discount +
                ", type=" + type +
                '}';
    }
}
