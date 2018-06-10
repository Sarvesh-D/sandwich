package com.ds.subway.sandwich.styles.english;

import com.ds.subway.sandwich.common.Sandwich;
import com.ds.subway.sandwich.common.Sandwich.SandwichMaker;
import com.ds.subway.sandwich.common.SandwichHandler;
import com.ds.subway.sandwich.common.ingredient.Bread;

public class EnglishSandwichBreadHandler extends SandwichHandler {

    public EnglishSandwichBreadHandler() {
	this.successor = new EnglishSandwichCheeseHandler();
    }

    /**
     * {@inheritDoc}. Adds {@link Bread} to {@link Sandwich}
     */
    @Override
    public Sandwich handle(final SandwichMaker sandwichMaker, final Sandwich sandwich) {
	if (sandwichMaker.getBread()
			 .isPresent()) {
	    sandwich.setBread(sandwichMaker.getBread()
					   .get());
	} else {
	    sandwich.setBread(Bread.WHITE);
	}
	return successor.handle(sandwichMaker, sandwich);
    }

}
