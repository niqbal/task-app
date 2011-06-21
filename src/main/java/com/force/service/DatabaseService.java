package com.force.service;

import com.force.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: niqbal
 * Date: 6/20/11
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseService {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("forceDatabase");

    private static String SEARCH_ALL = "Select o FROM %s o";

    public static List<Task> getList(String clazz) {
        EntityManager em = emf.createEntityManager();
        List l = em.createQuery(String.format(SEARCH_ALL, clazz)).getResultList();
        return l;
    }

    public static Task getTask(String id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Task.class, id);
    }

    public static void saveTask(Task t) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        em.persist(t);
        tx.begin();
    }

    public static Task updateTask(Task t) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Task oldTask = em.find(Task.class, t.getId());
        oldTask.setName(t.getName());
        oldTask.setDesc(t.getDesc());
        em.persist(oldTask);
        tx.commit();
        return oldTask;
    }


}
