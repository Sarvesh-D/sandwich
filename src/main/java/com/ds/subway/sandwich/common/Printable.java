package com.ds.subway.sandwich.common;

public interface Printable {

    default String print() {
	return this.toString();
    }

}
