package com.ds.subway.sandwich.common.order;

import com.ds.subway.sandwich.common.Printable;

public interface OrderPrinter extends Printable {

    String header();

    String footer();

    String amount();
}
