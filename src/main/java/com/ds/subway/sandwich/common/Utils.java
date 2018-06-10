package com.ds.subway.sandwich.common;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.ds.subway.sandwich.common.ingredient.Bread;
import com.ds.subway.sandwich.common.ingredient.Cheese;
import com.ds.subway.sandwich.common.ingredient.Dressing;
import com.ds.subway.sandwich.common.ingredient.Veggies;

public final class Utils {

    private Utils() {
    }

    public static double getAmount(final Optional<? extends Item> item) {
	if (item.isPresent()) {
	    return getAmount(item);
	}
	return 0;
    }

    public static double getTotalAmount(final Optional<? extends Item[]> items) {
	if (items.isPresent()) {
	    return Stream.of(items.get())
			 .mapToDouble(Utils::getAmount)
			 .sum();
	}
	return 0;
    }

    public static double getAmount(final Item item) {
	if (null == item) {
	    return 0;
	}
	return item.amount();
    }

    public static double getTotalAmount(final Item... items) {
	if (null == items) {
	    return 0;
	}
	return Stream.of(items)
		     .mapToDouble(Utils::getAmount)
		     .sum();
    }

    public static Supplier<Sandwich> randomEnglishSandwich() {
	return () -> new Sandwich.SandwichMaker(Style.ENGLISH).bread(Bread.RANDOM.get())
							      .cheese(Cheese.RANDOM.get())
							      .dressings(Dressing.RANDOM.get())
							      .veggies(Veggies.RANDOM.get())
							      .make();
    }

    public static Stream<Sandwich> randomEnglishSanwiches(final int count) {
	return Stream.generate(randomEnglishSandwich())
		     .limit(count);
    }

}
