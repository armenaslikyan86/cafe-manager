package com.cafe.manager.dto;

import com.cafe.manager.domain.ProductInOrder;
import com.cafe.manager.domain.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.Set;

public class OrderDto {

    private Long id;

    private String description;

    private com.cafe.manager.domain.Table table;

    private Set<ProductInOrder> productInOrders;

    public OrderDto() {

    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Set<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(Set<ProductInOrder> productInOrders) {
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
                .append(table, orderDto.table)
                .append(productInOrders, orderDto.productInOrders)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(description)
                .append(table)
                .append(productInOrders)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("description", description)
                .append("table", table)
                .append("productInOrders", productInOrders)
                .toString();
    }
}
