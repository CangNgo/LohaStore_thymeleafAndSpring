package com.cangngo.lohastore_java5_spring;


import org.testng.Assert;
import org.testng.annotations.Test;

public class FristTestNGFile {

    @Test
    public void test(){
        System.out.println("hello");
    }

    @Test
    public void testGetVatONnAmount(){
VatCalculator vat  = new VatCalculator();
        double expected = 10;
        Assert.assertEquals(vat.Vatcalculator(100), expected);
        Assert.assertNotEquals(vat.Vatcalculator(120), expected);
    }
}
