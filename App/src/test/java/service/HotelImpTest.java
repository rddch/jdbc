package service;

import entity.Hotel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelImpTest {

    Hotel hotel;

    @Before
    public void setUp() throws Exception {
        hotel = new Hotel();
        hotel.setHotelId(1);
    }

    @After
    public void tearDown() throws Exception {
        hotel = null;
    }

    @Test
    public void read() {
        assertEquals(1, hotel.getHotelId());
    }
}