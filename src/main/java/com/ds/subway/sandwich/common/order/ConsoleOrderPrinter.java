package com.ds.subway.sandwich.common.order;

import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import com.ds.subway.sandwich.common.Item;
import com.ds.utils.StringUtils4;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsoleOrderPrinter implements OrderPrinter {

    private final Order order;

    @Override
    public String print() {
	final StringJoiner invoice = new StringJoiner("\n");
	invoice.add(header());
	order.getItems()
	     .stream()
	     .forEach(item -> invoice.add(item.print()));
	invoice.add(amount());
	invoice.add(footer());
	return invoice.toString();
    }

    @Override
    public String header() {
	final StringJoiner header = new StringJoiner("\n");
	header.add(StringUtils.join(StringUtils4.multiply("*", 10), "Subway Sandwich", StringUtils4.multiply("*", 10)))
	      .add(StringUtils.join("Order Id : ", order.getId()))
	      .add(StringUtils.join("Name : ", order.getCustomerName()))
	      .add(StringUtils.join("Phone : ", order.getPhoneNumber()))
	      .add(StringUtils.join("Email : ", order.getEmail()))
	      .add(StringUtils4.multiply("-", 30));
	return header.toString();
    }

    @Override
    public String footer() {
	return "Thanks for visiting!!";
    }

    @Override
    public String amount() {
	final double total = order.getItems()
				  .stream()
				  .mapToDouble(Item::amount)
				  .sum();
	return StringUtils.join("Total Amount = ", total);
    }

}
