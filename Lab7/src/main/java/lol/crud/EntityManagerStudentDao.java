package lol.crud;


import lol.entities.Student;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EntityManagerStudentDao implements StudentDao {

    private final SessionFactory sessionFactory;

    public EntityManagerStudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student findById(Long id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        return entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        if(!transaction.isActive())
            transaction.begin();
        entityManager.persist(student);
        transaction.commit();
    }

    @Override
    public void update(Student student) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.persist(student);
    }

    @Override
    public void delete(Student student) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.remove(student);
    }

    @Override
    public List<Student> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        return entityManager.createQuery("select s from Student s",
                Student.class).getResultList();
    }
}
