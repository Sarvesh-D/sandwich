package com.ds.subway.sandwich.common.ingredient;

import java.util.Arrays;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;

import com.ds.subway.sandwich.common.Item;
import com.ds.utils.CollectionUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Bread implements Item {

    BROWN(6),
    WHITE(5),
    GARLIC(8),
    MULTIGRAIN(10);

    private final double amount;

    public static final Supplier<Bread> RANDOM = () -> CollectionUtils.randomElem(Arrays.asList(values()));

    @Override
    public double amount() {
	return amount;
    }

    @Override
    public String print() {
	return StringUtils.join(toString(), " Bread");
    }

}
