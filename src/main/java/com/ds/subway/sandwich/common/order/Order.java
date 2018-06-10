package com.ds.subway.sandwich.common.order;

import java.util.List;

import com.ds.subway.sandwich.common.Item;
import com.ds.utils.Random;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode(of = "id")
@ToString
@Getter
public class Order {

    private final long id;
    private final List<Item> items;
    private final double amount;
    private final String customerName;
    private final String phoneNumber;
    private final String email;

    private Order(final OrderBuilder orderBuilder) {
	this.id = orderBuilder.id;
	this.items = orderBuilder.items;
	this.amount = orderBuilder.amount;
	this.customerName = orderBuilder.customerName;
	this.phoneNumber = orderBuilder.phoneNumber;
	this.email = orderBuilder.email;
    }

    public static class OrderBuilder {

	private final long id;
	private final List<Item> items;
	private final double amount;
	private String customerName;
	private String phoneNumber;
	private String email;

	public OrderBuilder(final List<Item> items) {
	    this.id = Random.id();
	    this.items = items;
	    this.amount = this.items.stream()
				    .mapToDouble(Item::amount)
				    .sum();
	}

	public OrderBuilder customerName(final String name) {
	    customerName = name;
	    return this;
	}

	public OrderBuilder phoneNumber(final String number) {
	    phoneNumber = number;
	    return this;
	}

	public OrderBuilder email(final String email) {
	    this.email = email;
	    return this;
	}

	public Order build() {
	    return new Order(this);
	}
    }

}
