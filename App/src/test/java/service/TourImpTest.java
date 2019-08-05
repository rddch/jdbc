package service;

import entity.Tour;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TourImpTest {

    Tour tour;

    @Before
    public void setUp() throws Exception {
        tour = new Tour();
        tour.setTourId(1);
    }

    @After
    public void tearDown() throws Exception {
        tour = null;
    }

    @Test
    public void read() {
        assertEquals(1, tour.getTourId());
    }
}