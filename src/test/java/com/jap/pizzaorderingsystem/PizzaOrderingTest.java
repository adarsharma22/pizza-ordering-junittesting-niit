package com.jap.pizzaorderingsystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderingTest {
    PizzaOrdering pizzaOrdering;

    @BeforeEach
    void setUp() {
        pizzaOrdering = new PizzaOrdering();
    }

    @AfterEach
    void tearDown() {
        pizzaOrdering = null;
    }

    /* NOTE: Write a minimum of 4 assert statements for each test case */

    @Test
    public void givenPizzaChoiceAndSizeCalculateBill() {
        assertEquals(350,pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(0,1,"M"));
        assertEquals(300,pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(0,4,"M"));
        assertEquals(200,pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(0,4,"R"));
        assertEquals(0,pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(0,2,"R"));
    }

    @Test
    public void givenCrustChoiceEstimatePrice() {
        assertEquals(60,pizzaOrdering.estimatePriceOfCrust(1));
        assertEquals(80,pizzaOrdering.estimatePriceOfCrust(2));
        assertEquals(70,pizzaOrdering.estimatePriceOfCrust(3));
        assertEquals(0,pizzaOrdering.estimatePriceOfCrust(0));
    }

    @Test
    public void givenToppingsChoiceEstimatePrice() {
        assertEquals(80,pizzaOrdering.estimatePriceOfToppings(1));
        assertEquals(120,pizzaOrdering.estimatePriceOfToppings(2));
        assertEquals(0,pizzaOrdering.estimatePriceOfToppings(-1));
        assertEquals(0,pizzaOrdering.estimatePriceOfToppings(0));

    }

    @Test
    public void givenCrustAndToppingsCostCalculateTotalBill() {
        assertEquals(540,pizzaOrdering.calculateBillWithCrustAndToppings(400,60,80));
        assertEquals(700,pizzaOrdering.calculateBillWithCrustAndToppings(500,80,120));
        assertEquals(315,pizzaOrdering.calculateBillWithCrustAndToppings(175,60,80));
        assertEquals(555,pizzaOrdering.calculateBillWithCrustAndToppings(375,60,120));
    }

    @Test
    public void givenBreadChoiceCalculateTotalBill() {
        assertEquals(90,pizzaOrdering.calculateBillBasedOnChoiceOfBread(1,0));
        assertEquals(80,pizzaOrdering.calculateBillBasedOnChoiceOfBread(2,0));
        assertEquals(0,pizzaOrdering.calculateBillBasedOnChoiceOfBread(0,0));
        assertEquals(0,pizzaOrdering.calculateBillBasedOnChoiceOfBread(-1,0));
    }

    @Test
    public void givenDrinksChoiceCalculateTotalBill() {
        assertEquals(60,pizzaOrdering.calculateBillBasedOnDrinksChoice(1,0));
        assertEquals(60,pizzaOrdering.calculateBillBasedOnDrinksChoice(2,0));
        assertEquals(0,pizzaOrdering.calculateBillBasedOnDrinksChoice(0,0));
        assertEquals(0,pizzaOrdering.calculateBillBasedOnDrinksChoice(9,0));
    }

    @Test
    public void givenTotalBillEstimateDiscountAmount() {
        assertEquals(40,pizzaOrdering.estimateDiscountAmount(800));
        assertEquals(0,pizzaOrdering.estimateDiscountAmount(400));
        assertEquals(110,pizzaOrdering.estimateDiscountAmount(1100));
        assertEquals(0,pizzaOrdering.estimateDiscountAmount(300));
    }

    @Test
    public void givenDeliveryAndTipChargeCalculateFinalBill() {
        assertEquals(600,pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(100,100,400));
        assertEquals(710,pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(100,10,600));
        assertEquals(1290,pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(100,90,1100));
        assertEquals(400,pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(0,0,400));
    }

}
