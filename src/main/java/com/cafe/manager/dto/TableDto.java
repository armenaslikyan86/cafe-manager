package com.cafe.manager.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Set;

public class TableDto {

    private Long id;

    private String name;

    private Integer capacity;

    private Set<OrderDto> orders;

    public TableDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(final Set<OrderDto> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TableDto tableDto = (TableDto) o;

        return new EqualsBuilder()
                .append(id, tableDto.id)
                .append(name, tableDto.name)
                .append(capacity, tableDto.capacity)
                .append(orders, tableDto.orders)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(capacity)
                .append(orders)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("capacity", capacity)
                .append("orders", orders)
                .toString();
    }
}
