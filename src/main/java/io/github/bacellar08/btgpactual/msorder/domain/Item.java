package io.github.bacellar08.btgpactual.msorder.domain;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

public class Item {

    private String product;
    private Long quantity;
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;


    public Item() {
    }

    public String getProcut() {
        return product;
    }

    public void setProcut(String product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
