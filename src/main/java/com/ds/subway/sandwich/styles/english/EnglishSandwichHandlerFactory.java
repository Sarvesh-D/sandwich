package com.ds.subway.sandwich.styles.english;

import com.ds.subway.sandwich.common.SandwichHandler;
import com.ds.subway.sandwich.common.SandwichHandlerFactory;

public class EnglishSandwichHandlerFactory implements SandwichHandlerFactory {

    /**
     * {@inheritDoc} Gets {@link EnglishSandwichBreadHandler} as root handler to
     * prepare English Sandwich.
     */
    @Override
    public SandwichHandler getRootSandwichHandler() {
	return new EnglishSandwichBreadHandler();
    }

}
