package com.ds.subway.sandwich;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.ds.subway.sandwich.common.Sandwich;
import com.ds.subway.sandwich.common.Style;
import com.ds.subway.sandwich.common.ingredient.Bread;
import com.ds.subway.sandwich.common.ingredient.Cheese;
import com.ds.subway.sandwich.common.ingredient.Dressing;
import com.ds.subway.sandwich.common.ingredient.Meat;
import com.ds.subway.sandwich.common.ingredient.Veggies;
import com.ds.subway.sandwich.common.order.Order;

@RunWith(JUnit4.class)
public class SandwichTest {

    @Test
    public void englishSandwichWithoutAnyExtraIngredientsShouldReturnBread() {
	final Sandwich plainSandwich = new Sandwich.SandwichMaker(Style.ENGLISH).make();
	assertTrue(plainSandwich.getBread() == Bread.WHITE);
	assertNull(plainSandwich.getCheese());
	assertNull(plainSandwich.getMeat());
	assertNull(plainSandwich.getDressings());
	assertNull(plainSandwich.getVeggies());
    }

    @Test(expected = IllegalArgumentException.class)
    public void italianStyleSandwichShouldFail() {
	new Sandwich.SandwichMaker(Style.ITALIAN).make();
    }

    @Test(expected = IllegalArgumentException.class)
    public void indianStyleSandwichShouldFail() {
	new Sandwich.SandwichMaker(Style.INDIAN).make();
    }

    @Test(expected = IllegalArgumentException.class)
    public void americanStyleSandwichShouldFail() {
	new Sandwich.SandwichMaker(Style.AMERICAN).make();
    }

    @Test
    public void englishSandwichWithBrownBreadChedderCheeseSalameLettuceHoneyShouldCost38() {
	final Sandwich salameSandwich = new Sandwich.SandwichMaker(Style.ENGLISH).bread(Bread.BROWN)
										 .cheese(Cheese.CHEDDER)
										 .meat(Meat.SALAME)
										 .veggies(Veggies.LETTUCE)
										 .dressings(Dressing.HONEY)
										 .make();
	final Order order = new Order.OrderBuilder(Arrays.asList(salameSandwich)).build();
	assertTrue(order.getAmount() == 38);
    }

}
