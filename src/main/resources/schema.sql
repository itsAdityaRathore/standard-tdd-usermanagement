DROP Sequence IF EXISTS user_seq;

CREATE SEQUENCE IF NOT EXISTS public.user_seq
    INCREMENT 1
    START 1001
    MINVALUE 1001;

DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS public."users"
(
    uid integer NOT NULL,
    uname text,
    uaddress text,
    uphone text,
    umanager text,
    urole text,
    PRIMARY KEY (uid)
);