--liquibase formatted sql
--changeset olhab:create-user-table
CREATE TABLE users (id BIGINT NOT NULL AUTO_INCREMENT, email VARCHAR(255), name VARCHAR(255), phone VARCHAR(255), PRIMARY KEY (id)) ENGINE=InnoDB;

--rollback DROP TABLE users;
