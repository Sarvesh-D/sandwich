package com.ds.subway.sandwich.common.ingredient;

import java.util.Arrays;
import java.util.function.Supplier;

import com.ds.subway.sandwich.common.Item;
import com.ds.utils.CollectionUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Veggies implements Item {

    LETTUCE(5),
    PEPPERS(4),
    CABBAGE(3),
    TOMATOES(2);

    private final double amount;

    public static final Supplier<Veggies[]> RANDOM = () -> CollectionUtils.randomElems(Arrays.asList(values()), 2)
									  .toArray(new Veggies[2]);

    @Override
    public double amount() {
	return amount;
    }

}
