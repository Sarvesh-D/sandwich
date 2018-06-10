package com.ds.subway.sandwich.styles.english;

import com.ds.subway.sandwich.common.Sandwich;
import com.ds.subway.sandwich.common.Sandwich.SandwichMaker;
import com.ds.subway.sandwich.common.SandwichHandler;
import com.ds.subway.sandwich.common.ingredient.Cheese;

public class EnglishSandwichCheeseHandler extends SandwichHandler {

    public EnglishSandwichCheeseHandler() {
	this.successor = new EnglishSandwichMeatHandler();
    }

    /**
     * {@inheritDoc}. Applies {@link Cheese} to {@link Sandwich}
     */
    @Override
    public Sandwich handle(final SandwichMaker sandwichMaker, final Sandwich sandwich) {
	sandwichMaker.getCheese()
		     .ifPresent(sandwich::setCheese);
	return successor.handle(sandwichMaker, sandwich);
    }

}
