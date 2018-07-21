package com.cafe.manager.dto;

import com.cafe.manager.domain.Order;
import com.cafe.manager.domain.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.Set;

public class TableDto {

    private Long id;

    private String name;

    private Integer capacity;

    private User user;

    private Set<Order> orders;

    public TableDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
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
                .append(user, tableDto.user)
                .append(orders, tableDto.orders)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(capacity)
                .append(user)
                .append(orders)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("capacity", capacity)
                .append("user", user)
                .append("orders", orders)
                .toString();
    }
}
