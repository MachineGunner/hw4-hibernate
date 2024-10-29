package com.olhab.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.olhab.model.User;
import com.olhab.repository.UserRepository;
import com.olhab.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public User create(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return user;
    }

    @Override
    public User update(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(sessionFactory.openSession().find(User.class, id));
    }
}
