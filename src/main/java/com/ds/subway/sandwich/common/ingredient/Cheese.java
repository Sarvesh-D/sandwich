package com.ds.subway.sandwich.common.ingredient;

import java.util.Arrays;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;

import com.ds.subway.sandwich.common.Item;
import com.ds.utils.CollectionUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Cheese implements Item {

    MOZARELA(15),
    PAMOSEN(20),
    CHEDDER(10),
    BLUE(25);

    private final double amount;

    public static final Supplier<Cheese> RANDOM = () -> CollectionUtils.randomElem(Arrays.asList(values()));

    @Override
    public double amount() {
	return amount;
    }

    @Override
    public String print() {
	return StringUtils.join(toString(), " Cheese");
    }

}
