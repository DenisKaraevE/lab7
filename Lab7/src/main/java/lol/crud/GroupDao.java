package lol.crud;

import lol.entities.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GroupDao implements CrudDao<Group, Long> {
    private final SessionFactory sessionFactory;

    public GroupDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Group findById(Long id) {
        Session session= sessionFactory.openSession();
        Group entity = session.get(Group.class, id);
        return entity;
    }

    public void save(Group entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public void update(Group entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public void delete(Group entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public List<Group> findAll() {
        Session session = sessionFactory.openSession();
        List<Group> entities = (List<Group>)  session.createQuery("from Group ").list();
        return entities;
    }

}
