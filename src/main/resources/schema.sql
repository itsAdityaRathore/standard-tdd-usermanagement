--Drop Existing Sequence AND Create a new sequence
DROP Sequence IF EXISTS user_seq;
CREATE SEQUENCE IF NOT EXISTS public.user_seq
    INCREMENT 1
    START 1001
    MINVALUE 1001;

--Drop Existing Table and Create a new Table ROLE
DROP TABLE IF EXISTS roles CASCADE;
CREATE TABLE IF NOT EXISTS public."roles"
(
    role_id int NOT NULL,
    role_name text,
    PRIMARY KEY (role_id)
);

--Drop Existing Table and Create a new Table USERS
DROP TABLE IF EXISTS public."users";
CREATE TABLE IF NOT EXISTS public."users"
(
    uid int NOT NULL,
    uname text,
    uaddress text,
    uphone text,
    umanager text,
    urole int REFERENCES roles(role_id),
    PRIMARY KEY (uid)
);
