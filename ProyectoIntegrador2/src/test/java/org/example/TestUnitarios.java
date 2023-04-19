package org.example.ProyectoIntegrador2.src.test.java.org.example;

import junit.framework.Assert;
import org.example.ProyectoIntegrador2.src.main.java.org.example.App;
import org.testng.annotations.Test;

public class TestUnitarios {
    private Object test;

    @Test
    public void test1(){
        App app = new App();
        final var testUnitarios = new TestUnitarios();
        Assert.assertNull(test);
    }}
