package service;

import entity.Country;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryImpTest {

    Country country;

    @Before
    public void setUp() throws Exception {
        country = new Country();
        country.setCountry("POL");
        country.setCountryId(1);
    }

    @After
    public void tearDown() throws Exception {
        country = null;
    }

    @Test
    public void read() {
        assertEquals(1, country.getCountryId());
    }

    @Test
    public void all() {
        assertEquals(1, country.getCountryId());
        assertEquals("POL", country.getCountry());
    }
}