package com.olhab.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.olhab.model.Role;
import com.olhab.repository.RoleRepository;
import com.olhab.util.HibernateUtil;

import java.util.Optional;

public class RoleRepositoryImpl implements RoleRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Role create(Role role) {
        try (Session session = sessionFactory.openSession()) {
            session.save(role);
        }
        return role;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.ofNullable(sessionFactory.openSession().find(Role.class, id));
    }
}
