import entity.Country;
import entity.Hotel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppTest {
    private EntityManager em;

    @Before
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("App");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @Test
    public void shouldPersistenceCountry() {
        Country country = new Country();
        country.setCountry("BLR");
        em.persist(country);
    }

    @Test
    public void shouldFindCountry() {
        Country country = em.find(Country.class, 1L);
        Hotel hotel = new Hotel();
        hotel.setCountry(country);
        em.persist(hotel);
    }

    @After
    public void close() {
        if(em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
        em.getEntityManagerFactory().close();
        em.close();
    }
}
