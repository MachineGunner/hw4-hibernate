--liquibase formatted sql
--changeset olhab:create-users-roles-table
CREATE TABLE users_roles (user_id BIGINT NOT NULL, role_id BIGINT NOT NULL, foreign key (role_id) references roles (id), foreign key (user_id) references users (id)) ENGINE=InnoDB;

--rollback DROP TABLE users_roles;
