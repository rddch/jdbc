package service;

import entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserImpTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUserId(1);
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void read() {
        assertEquals(1, user.getUserId());
    }
}