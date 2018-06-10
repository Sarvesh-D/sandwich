package com.ds.subway.sandwich;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.ds.subway.sandwich.common.Item;
import com.ds.subway.sandwich.common.Utils;
import com.ds.subway.sandwich.common.order.HtmlOrderPrinter;
import com.ds.subway.sandwich.common.order.Order;
import com.ds.subway.sandwich.common.order.Order.OrderBuilder;
import com.ds.utils.Random;

public class SubwaySandwich {

    public static void main(final String[] args) {
	final int orderSize = Integer.parseInt(args[0]);
	System.out.println(String.format("Order recieved to prepare [%d] sandwiches.", orderSize));
	final Instant start = Instant.now();

	final List<Item> randomSandwiches = Utils.randomEnglishSanwiches(orderSize)
						 .collect(Collectors.toList());
	final Order order = new OrderBuilder(randomSandwiches).customerName(Random.indianName())
							      .phoneNumber(Random.phoneNumber())
							      .build();

	System.out.println(new HtmlOrderPrinter(order).print());

	final Instant end = Instant.now();
	System.out.println(String.format("Time taken to prepare [%d] sandwiches = [%d] milliSeconds", orderSize,
		Duration.between(start, end)
			.toMillis()));
    }

}
