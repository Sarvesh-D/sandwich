package com.ds.subway.sandwich.common;

import java.util.List;

@FunctionalInterface
public interface Item extends Printable {

    double amount();

    default List<Item> subItems() throws IllegalAccessException {
	throw new IllegalAccessException("No more sub-items");
    }

}
