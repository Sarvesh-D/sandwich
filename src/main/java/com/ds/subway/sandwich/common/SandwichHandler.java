package com.ds.subway.sandwich.common;

import com.ds.subway.sandwich.common.Sandwich.SandwichMaker;
import com.ds.subway.sandwich.common.ingredient.Bread;
import com.ds.subway.sandwich.common.ingredient.Cheese;
import com.ds.subway.sandwich.common.ingredient.Dressing;
import com.ds.subway.sandwich.common.ingredient.Meat;
import com.ds.subway.sandwich.common.ingredient.Veggies;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Abstract Sandwich Handler class to be extended by each type of Sandwich
 * Handler. Each {@link SandwichHandler} is responsible for handling single
 * part/ingredient of {@link Sandwich} like {@link Bread}, {@link Cheese},
 * {@link Meat}, {@link Veggies}, {@link Dressing}
 *
 * @author <a href="mailto:sarvesh.dubey@cdk.com">Sarvesh Dubey</a>
 *
 * @since 06-12-2017
 * @version
 */
public abstract class SandwichHandler {

    @Getter(value = AccessLevel.PROTECTED)
    protected SandwichHandler successor;

    /**
     * Applies a single ingredient to {@link Sandwich}
     *
     * @param sandwichMaker
     *            Holding details of the ingredients/parts of {@link Sandwich}
     * @param sandwich
     *            to apply respective ingredient to.
     * @return {@link Sandwich} with applied ingredient. The ingredient won't be
     *         applied if it's not present in {@link SandwichMaker}
     */
    public abstract Sandwich handle(SandwichMaker sandwichMaker, Sandwich sandwich);

}
