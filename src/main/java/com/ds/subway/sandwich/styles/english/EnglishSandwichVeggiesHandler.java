package com.ds.subway.sandwich.styles.english;

import com.ds.subway.sandwich.common.Sandwich;
import com.ds.subway.sandwich.common.Sandwich.SandwichMaker;
import com.ds.subway.sandwich.common.SandwichHandler;
import com.ds.subway.sandwich.common.ingredient.Veggies;

public class EnglishSandwichVeggiesHandler extends SandwichHandler {

    public EnglishSandwichVeggiesHandler() {
	this.successor = new EnglishSandwichDressingsHandler();
    }

    /**
     * {@inheritDoc}. Adds {@link Veggies} to {@link Sandwich}
     */
    @Override
    public Sandwich handle(final SandwichMaker sandwichMaker, final Sandwich sandwich) {
	sandwichMaker.getVeggies()
		     .ifPresent(sandwich::setVeggies);
	return successor.handle(sandwichMaker, sandwich);
    }

}
