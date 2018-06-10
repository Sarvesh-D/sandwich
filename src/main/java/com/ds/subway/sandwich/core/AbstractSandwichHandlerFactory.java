package com.ds.subway.sandwich.core;

import com.ds.subway.sandwich.common.Sandwich;
import com.ds.subway.sandwich.common.SandwichHandlerFactory;
import com.ds.subway.sandwich.common.Style;

public class AbstractSandwichHandlerFactory {

    private AbstractSandwichHandlerFactory() {
    }

    /**
     * Determines the SandwichHandlerFactory which can handle/prepare
     * {@link Sandwich} for given {@link Style}
     *
     * @param style
     *            for which {@link SandwichHandlerFactory} is required
     * @return Appropriate {@link SandwichHandlerFactory}
     */
    public static SandwichHandlerFactory getSandwichHandlerFactory(final Style style) {
	switch (style) {
	case AMERICAN:
	    break;
	case ENGLISH:
	    return com.ds.subway.sandwich.core.SandwichHandlerFactory.ENGLISH.getFactory();
	case INDIAN:
	    break;
	case ITALIAN:
	    break;
	}
	throw new IllegalArgumentException(String.format("Style [%s] is not yet supported. Try later", style));
    }

}
