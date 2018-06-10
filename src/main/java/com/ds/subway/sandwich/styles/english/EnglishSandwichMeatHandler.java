package com.ds.subway.sandwich.styles.english;

import com.ds.subway.sandwich.common.Sandwich;
import com.ds.subway.sandwich.common.Sandwich.SandwichMaker;
import com.ds.subway.sandwich.common.SandwichHandler;
import com.ds.subway.sandwich.common.ingredient.Meat;

public class EnglishSandwichMeatHandler extends SandwichHandler {

    public EnglishSandwichMeatHandler() {
	this.successor = new EnglishSandwichVeggiesHandler();
    }

    /**
     * {@inheritDoc}. Adds {@link Meat} to {@link Sandwich}
     */
    @Override
    public Sandwich handle(final SandwichMaker sandwichMaker, final Sandwich sandwich) {
	sandwichMaker.getMeat()
		     .ifPresent(sandwich::setMeat);
	return successor.handle(sandwichMaker, sandwich);
    }

}
