package com.ds.subway.sandwich.common.ingredient;

import java.util.Arrays;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;

import com.ds.subway.sandwich.common.Item;
import com.ds.utils.CollectionUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Meat implements Item {

    SALAME(12),
    PORK(14),
    BEEF(8),
    JERKY(6);

    public static final Supplier<Meat> RANDOM = () -> CollectionUtils.randomElem(Arrays.asList(values()));

    private final double amount;

    @Override
    public double amount() {
	return amount;
    }

    @Override
    public String print() {
	return StringUtils.join(toString(), " Meat");
    }

}
