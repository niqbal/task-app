package com.force.service;

import com.force.model.Project;
import com.force.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: niqbal
 * Date: 6/20/11
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseService {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("badname");

    public static Logger logger = Logger.getLogger("com.force.service.DatabaseService");

    private static String SEARCH_ALL = "Select o FROM %s o";

    public static List<Task> getList(String clazz) {
        EntityManager em = emf.createEntityManager();
        List l = em.createQuery(String.format(SEARCH_ALL, clazz)).getResultList();
        return l;
    }

    public static Task getTask(String id) {
        EntityManager em = emf.createEntityManager();
        Task t = em.find(Task.class, id);
        logger.info("Fected task: " + t.toString());
        logger.info("Parent project: " + (t.getProject() != null ? t.getProject().toString() : ""));
        return t;
    }

    public static Project getProject(String id) {
        EntityManager em = emf.createEntityManager();
        Project p = em.find(Project.class, id);
        logger.info("Fetched project: " + p.toString());
        return p;
    }

    public static void saveProject(Project p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (p.getId() !=  null && !"".equals(p.getId())) {
            Project p0 = em.find(Project.class, p.getId());
            p0.setName(p.getName());
            p0.setDesc(p.getDesc());
            em.persist(p0);
        }
        else {
            em.persist(p);
        }
        tx.commit();
    }


    public static void saveTask(Task t) {
        EntityManager em = emf.createEntityManager();
        logger.info("Saving: " + t.toString());
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (t.getId() !=  null && !"".equals(t.getId())) {
            Task t0 = em.find(Task.class, t.getId());
            t0.setName(t.getName());
            t0.setDesc(t.getDesc());
            em.persist(t0);
        }
        else {
            em.persist(t);
        }

        tx.commit();
    }

    public static void saveTask(String projectId, Task t) {
        logger.info("projectId: " + projectId);
        logger.info("Saving: " + t.toString());

        if(projectId != null) {
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Project p = em.find(Project.class, projectId);


            if (t.getId() != null && !"".equals(t.getId())) {
                for(Task t0: p.getTasks()) {
                    if (t0.getId().equals(t.getId())) {
                        t0.setName(t.getName());
                        t0.setDesc(t.getDesc());
                        t0.setProject(p);
                        em.persist(t0);
                    }
                }
            }
            else {
                p.getTasks().add(t);
                t.setProject(p);
                em.persist(t);
            }

            // ?
            for(Task t0: p.getTasks()) {
                t0.setProject(p);
            }

            em.persist(p);
            tx.commit();
        }
        else {
            saveTask(t);
        }
    }
}
