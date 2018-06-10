package com.ds.subway.sandwich.styles.english;

import com.ds.subway.sandwich.common.Sandwich;
import com.ds.subway.sandwich.common.Sandwich.SandwichMaker;
import com.ds.subway.sandwich.common.SandwichHandler;
import com.ds.subway.sandwich.common.ingredient.Dressing;

public class EnglishSandwichDressingsHandler extends SandwichHandler {

    /**
     * {@inheritDoc}. Applies {@link Dressing} to {@link Sandwich}
     */
    @Override
    public Sandwich handle(final SandwichMaker sandwichMaker, final Sandwich sandwich) {
	sandwichMaker.getDressings()
		     .ifPresent(sandwich::setDressings);
	return sandwich;
    }

}
