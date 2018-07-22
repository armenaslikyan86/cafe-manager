package com.cafe.manager.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "product_in_order")
public class ProductInOrder {

    @Id
    @SequenceGenerator(name = "product_in_order_generator", sequenceName = "product_in_order_sequence")
    @GeneratedValue(generator = "product_in_order_generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "account")
    private Double account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Column(name = "amount")
    private Long amount;

    public ProductInOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(final Double account) {
        this.account = account;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(final Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(final Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof ProductInOrder)) return false;

        final ProductInOrder that = (ProductInOrder) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(account, that.account)
                .append(product, that.product)
                .append(order, that.order)
                .append(amount, that.amount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(account)
                .append(product)
                .append(order)
                .append(amount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("account", account)
                .append("product", product)
                .append("order", order)
                .append("amount", amount)
                .toString();
    }
}
