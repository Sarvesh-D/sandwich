package com.ds.subway.sandwich.common.ingredient;

import java.util.Arrays;
import java.util.function.Supplier;

import com.ds.subway.sandwich.common.Item;
import com.ds.utils.CollectionUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Dressing implements Item {

    MAYONAISE(3),
    MUSTARD(5),
    HONEY(5);

    public static final Supplier<Dressing[]> RANDOM = () -> CollectionUtils.randomElems(Arrays.asList(values()), 2)
									   .toArray(new Dressing[2]);

    private final double amount;

    @Override
    public double amount() {
	return amount;
    }

}
