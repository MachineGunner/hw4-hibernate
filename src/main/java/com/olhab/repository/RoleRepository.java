package com.olhab.repository;

import com.olhab.model.Role;

import java.util.Optional;

public interface RoleRepository {
    Role create(Role role);

    Optional<Role> findById(Long id);
}
