package fr.inria.kata.smartfridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.BeforeEach;

public class SmartFridgeTest {

    private static final int N_ITERATIONS = 500;

    private SmartFridge smartFridge;

    @BeforeEach
    private void initSmartFridge() {
        smartFridge = new SmartFridge();
    }

    @RepeatedTest(N_ITERATIONS)
    public void testDefaultFreshnessUpdate() {
        Product truc = new Product("test", "truc");
        smartFridge.updateFreshness(truc);
        assertTrue(85 <= truc.getFreshness() && truc.getFreshness() <= 95);
        smartFridge.updateFreshness(truc);
        assertTrue(70 <= truc.getFreshness() && truc.getFreshness() <= 90);
        smartFridge.updateFreshness(truc);
        assertTrue(55 <= truc.getFreshness() && truc.getFreshness() <= 85);
        smartFridge.updateFreshness(truc);
        assertTrue(40 <= truc.getFreshness() && truc.getFreshness() <= 80);
    }

    @Test
    public void testEternalFreshnessUpdate() {
        Product eternal = new Product("test", "eternal");
        smartFridge.updateFreshness(eternal);
        assertEquals(100, eternal.getFreshness());
        smartFridge.updateFreshness(eternal);
        assertEquals(100, eternal.getFreshness());
        smartFridge.updateFreshness(eternal);
        assertEquals(100, eternal.getFreshness());
        smartFridge.updateFreshness(eternal);
        assertEquals(100, eternal.getFreshness());
    }

    @Test
    public void testYogourtFreshnessUpdate() {
        Product yogourt = new Product("test", "yogourt");
        smartFridge.updateFreshness(yogourt);
        assertEquals(95, yogourt.getFreshness());
        smartFridge.updateFreshness(yogourt);
        assertEquals(90, yogourt.getFreshness());
        smartFridge.updateFreshness(yogourt);
        assertEquals(85, yogourt.getFreshness());
        smartFridge.updateFreshness(yogourt);
        assertEquals(80, yogourt.getFreshness());
    }

    @RepeatedTest(N_ITERATIONS)
    public void testVegetableFreshnessUpdate() {
        Product vegetable = new Product("test", "vegetable");
        smartFridge.updateFreshness(vegetable);
        assertTrue(75 <= vegetable.getFreshness() && vegetable.getFreshness() <= 80);
        smartFridge.updateFreshness(vegetable);
        assertTrue(50 <= vegetable.getFreshness() && vegetable.getFreshness() <= 60);
        smartFridge.updateFreshness(vegetable);
        assertTrue(25 <= vegetable.getFreshness() && vegetable.getFreshness() <= 40);
        smartFridge.updateFreshness(vegetable);
        assertTrue(00 <= vegetable.getFreshness() && vegetable.getFreshness() <= 20);
    }

    @RepeatedTest(N_ITERATIONS)
    public void testMeatFreshnessUpdate() {
        Product meat = new Product("test", "meat");
        smartFridge.updateFreshness(meat);
        assertEquals(90, meat.getFreshness());
        smartFridge.updateFreshness(meat);
        assertEquals(80, meat.getFreshness());
        smartFridge.updateFreshness(meat);
        assertEquals(70, meat.getFreshness());
        if (smartFridge.memory.get(meat) == 0) {
            smartFridge.updateFreshness(meat);
            assertEquals(50, meat.getFreshness());
            smartFridge.updateFreshness(meat);
            assertEquals(30, meat.getFreshness());
            smartFridge.updateFreshness(meat);
            assertEquals(10, meat.getFreshness());
        } else {
            smartFridge.updateFreshness(meat);
            assertEquals(60, meat.getFreshness());
            if (smartFridge.memory.get(meat) == 0) {
                smartFridge.updateFreshness(meat);
                assertEquals(40, meat.getFreshness());
                smartFridge.updateFreshness(meat);
                assertEquals(20, meat.getFreshness());
                smartFridge.updateFreshness(meat);
                assertEquals(00, meat.getFreshness());
            } else {
                smartFridge.updateFreshness(meat);
                assertEquals(50, meat.getFreshness());
                if (smartFridge.memory.get(meat) == 0) {
                    smartFridge.updateFreshness(meat);
                    assertEquals(30, meat.getFreshness());
                    smartFridge.updateFreshness(meat);
                    assertEquals(10, meat.getFreshness());
                } else {
                    fail("Meat should not be durable for this long.");
                }
            }
        }
    }

    @Test
    public void testMushroomFreshnessUpdate() {
        Product mush = new Product("test", "mushroom");
        smartFridge.updateFreshness(mush);
        assertEquals(90, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(80, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(70, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(60, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(50, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(45, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(40, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(35, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(30, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(25, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(20, mush.getFreshness());
        smartFridge.updateFreshness(mush);
        assertEquals(15, mush.getFreshness());
    }

}
