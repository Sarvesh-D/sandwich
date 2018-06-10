package com.ds.subway.sandwich.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.ds.subway.sandwich.common.ingredient.Bread;
import com.ds.subway.sandwich.common.ingredient.Cheese;
import com.ds.subway.sandwich.common.ingredient.Dressing;
import com.ds.subway.sandwich.common.ingredient.Meat;
import com.ds.subway.sandwich.common.ingredient.Veggies;
import com.ds.subway.sandwich.core.AbstractSandwichHandlerFactory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor(force = true)
public class Sandwich implements Item {

    private Bread bread;

    private Cheese cheese;

    private Meat meat;

    private Veggies[] veggies;

    private Dressing[] dressings;

    private final Style style;

    @Getter
    public static class SandwichMaker {

	private Optional<Bread> bread = Optional.empty();

	private Optional<Cheese> cheese = Optional.empty();

	private Optional<Meat> meat = Optional.empty();

	private Optional<Veggies[]> veggies = Optional.empty();

	private Optional<Dressing[]> dressings = Optional.empty();

	private final Style style;

	public SandwichMaker(final Style style) {
	    this.style = style;
	}

	public SandwichMaker bread(final Bread bread) {
	    this.bread = Optional.ofNullable(bread);
	    return this;
	}

	public SandwichMaker cheese(final Cheese cheese) {
	    this.cheese = Optional.ofNullable(cheese);
	    return this;
	}

	public SandwichMaker meat(final Meat meat) {
	    this.meat = Optional.ofNullable(meat);
	    return this;
	}

	public SandwichMaker veggies(final Veggies... veggies) {
	    this.veggies = Optional.ofNullable(veggies);
	    return this;
	}

	public SandwichMaker dressings(final Dressing... dressings) {
	    this.dressings = Optional.ofNullable(dressings);
	    return this;
	}

	public Sandwich make() {
	    return AbstractSandwichHandlerFactory.getSandwichHandlerFactory(style)
						 .getRootSandwichHandler()
						 .handle(this, new Sandwich(style));
	}

    }

    @Override
    public List<Item> subItems() throws IllegalAccessException {
	final List<Item> subItems = new ArrayList<>();
	subItems.addAll(Arrays.asList(bread, cheese, meat));
	if (null != veggies) {
	    Stream.of(veggies)
		  .forEach(subItems::add);
	}
	if (null != dressings) {
	    Stream.of(dressings)
		  .forEach(subItems::add);
	}
	return subItems;
    }

    @Override
    public String print() {
	final StringJoiner sandwichPrinter = new StringJoiner("\n");
	sandwichPrinter.add(StringUtils.join(style.print(), " Sandwich -> ", amount()));
	try {
	    sandwichPrinter.add(subItems().stream()
					  .filter(Objects::nonNull)
					  .map(Item::print)
					  .collect(Collectors.joining(",", "(", ")")));
	} catch (final IllegalAccessException e) {
	    // Sandwich has subItems, no need to do anything.
	}
	return sandwichPrinter.toString();
    }

    @Override
    public double amount() {
	try {
	    return subItems().stream()
			     .filter(Objects::nonNull)
			     .mapToDouble(Item::amount)
			     .sum();
	} catch (final IllegalAccessException e) {
	    return 0;
	}
    }

    public String toString_BK() {
	final StringJoiner sj = new StringJoiner("\n");
	sj.add("Style = " + style)
	  .add("Bread = " + bread)
	  .add("Cheese = " + cheese)
	  .add("Meat = " + meat)
	  .add("Veggies = " + Arrays.toString(veggies))
	  .add("Dressings = " + Arrays.toString(dressings))
	  .add("Amount = " + amount());
	return sj.toString();
    }

}
