package com.ds.subway.sandwich.common;

/**
 * Interface for clients to implement to setup chain of
 * {@link SandwichHandler}'s for preparing a particular {@link Style} of
 * {@link Sandwich}
 *
 * @author <a href="mailto:sarvesh.dubey@cdk.com">Sarvesh Dubey</a>
 *
 * @since 06-12-2017
 * @version
 */
public interface SandwichHandlerFactory {

    /**
     * Gets the root {@link SandwichHandler} from where the preparation of
     * {@link Sandwich} begins. This {@link SandwichHandler} marks as the first link
     * in the preparation chain.
     *
     * @return {@link SandwichHandler}
     */
    SandwichHandler getRootSandwichHandler();

}
