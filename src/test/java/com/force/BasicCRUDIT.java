package com.force;


import com.force.model.Task;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BasicCRUDIT extends TestCase {

    @Test
    public void testCRUD() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("forceDatabase");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Task t = new Task();
        t.setName("tast 1");
        t.setDesc("task one");
        em.persist(t);
        tx.commit();

        Task fetched = em.find(Task.class, t.getId());
        Assert.assertEquals(t.getName(), fetched.getName());
        Assert.assertEquals(t.getDesc(), fetched.getDesc());
    }
}
