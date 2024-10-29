package com.olhab;

import com.olhab.model.Role;
import com.olhab.model.User;
import com.olhab.repository.impl.RoleRepositoryImpl;
import com.olhab.repository.impl.UserRepositoryImpl;
import com.olhab.util.HibernateUtil;

import java.util.List;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        RoleRepositoryImpl roleRepository = new RoleRepositoryImpl();

        Role admin = roleRepository.create(new Role("Admin"));
        System.out.println(admin);
        Role owner = roleRepository.create(new Role("Business owner"));
        Role manager = roleRepository.create(new Role("Manager"));
        Role instructor = roleRepository.create(new Role("Instructor"));

        User user = new User();
        user.setName("One Test");
        user.setEmail("one@example.com");
        user.setPhoneNumber("+1234567890");
        user.setRoles(List.of(admin, owner, manager, instructor));

        User userOne = userRepository.create(user);
        System.out.println(userOne);
        User userTwo = userRepository.create(new User("Two Test", "two@example.com", "+9999999999"));
        System.out.println(userTwo);

        System.out.println(userRepository.findById(userOne.getId()));
        System.out.println(roleRepository.findById(admin.getId()));

        userTwo.setRoles(List.of(owner, manager));
        System.out.println(userRepository.update(userTwo));

        HibernateUtil.getSessionFactory().close();
    }
}
