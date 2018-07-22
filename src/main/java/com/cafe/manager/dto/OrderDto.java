package com.cafe.manager.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Set;

public class OrderDto {

    private Long id;

    private String description;

    private Set<ProductInOrderDto> productInOrders;

    public OrderDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Set<ProductInOrderDto> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(final Set<ProductInOrderDto> productInOrders) {
        this.productInOrders = productInOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OrderDto orderDto = (OrderDto) o;

        return new EqualsBuilder()
                .append(id, orderDto.id)
                .append(description, orderDto.description)
                .append(productInOrders, orderDto.productInOrders)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(description)
                .append(productInOrders)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("description", description)
                .append("productInOrders", productInOrders)
                .toString();
    }
}
