package com.ds.subway.sandwich;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ds.subway.sandwich.common.Sandwich;
import com.ds.subway.sandwich.common.Utils;
import com.ds.subway.sandwich.common.ingredient.Bread;

public class SubwaySandwichStats {

    public static void main(final String[] args) {
	final List<Sandwich> sandwiches = Utils.randomEnglishSanwiches(21)
					       .collect(Collectors.toList());

	// Most popular Bread?
	final Optional<Entry<String, Long>> mostPopularBread = sandwiches.stream()
									 .map(Sandwich::getBread)
									 .collect(Collectors.groupingBy(Bread::name,
										 Collectors.counting()))
									 .entrySet()
									 .stream()
									 .max(Comparator.comparingLong(
										 Entry::getValue));

	System.out.println(mostPopularBread);

	// Most popular Cheese?

	// Most popular Veggies?

	// Most popular Dressings?

	// Average Cost of sandwich

	// Most expensive sandwich

	// Most cheap sandwich

	// Number of sandwiches whose amount is greater than average cost

    }

}
