package com.force;


import com.force.model.Task;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class BasicCRUD {

    @Test
    public void testCRUD() {
        System.setProperty("force.forceDatabase.url","force://vmf01.t.salesforce.com;user=n@vmf01.com;password=test1234;oauth_key=3MVG9lKcPoNINVBJODzn4ACM0KkhPOusO7d_Cgj1DtVenib5TofzP7v1sZwpcwT8CJH4jLXbP5dBQLtUcstdq;oauth_secret=6275589123086961927");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("forceDatabase");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Task t = new Task("", "t1", "one");
        em.persist(t);
        Task t2 = new Task("", "t2", "two");
        em.persist(t2);
        tx.commit();

        System.out.print("Hello world");
        List l = em.createQuery("Select o FROM Task o").getResultList();


        System.out.println(l.size());
        System.out.print("Hello world");
    }
}
