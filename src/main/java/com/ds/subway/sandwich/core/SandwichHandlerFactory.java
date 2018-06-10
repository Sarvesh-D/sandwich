package com.ds.subway.sandwich.core;

import com.ds.subway.sandwich.styles.english.EnglishSandwichHandlerFactory;

public enum SandwichHandlerFactory {

    ENGLISH {

	private final transient EnglishSandwichHandlerFactory factory = new EnglishSandwichHandlerFactory();

	@Override
	public com.ds.subway.sandwich.common.SandwichHandlerFactory getFactory() {
	    return factory;
	}

    };

    public abstract com.ds.subway.sandwich.common.SandwichHandlerFactory getFactory();

}
