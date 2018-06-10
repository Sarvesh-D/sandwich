package com.ds.subway.sandwich.common.order;

import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

public class HtmlOrderPrinter implements OrderPrinter {

    private final Order order;
    private final ConsoleOrderPrinter consoleOrderPrinter;

    public HtmlOrderPrinter(final Order order) {
	this.order = order;
	consoleOrderPrinter = new ConsoleOrderPrinter(this.order);
    }

    @Override
    public String print() {
	final StringJoiner invoice = new StringJoiner("\n");
	invoice.add(header());
	invoice.add("<ol>");
	order.getItems()
	     .stream()
	     .forEach(item -> invoice.add(StringUtils.join("<li>", item.print(), "</li>")));
	invoice.add("</ol>");
	invoice.add(amount());
	invoice.add(footer());
	return invoice.toString();
    }

    @Override
    public String header() {
	return StringUtils.join("<b>", consoleOrderPrinter.header()
							  .replaceAll("\n", "<br>"),
		"</b>");
    }

    @Override
    public String footer() {
	return StringUtils.join("<b>", consoleOrderPrinter.footer()
							  .replaceAll("\n", "<br>"),
		"</b>");
    }

    @Override
    public String amount() {
	return StringUtils.join("<b>", consoleOrderPrinter.amount()
							  .replaceAll("\n", "<br>"),
		"</b>");
    }

}
