USE trvl_assist;

CREATE TABLE IF NOT EXISTS trvl_assist.user(
    `id`         INT            NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(25)    NOT NULL,
    `password`   VARCHAR(256)   NOT NULL,
    `role`       VARCHAR(20)    NOT NULL,
    `first_name` VARCHAR(50)    NOT NULL,
    `last_name`  VARCHAR(50)    NOT NULL,
    `gender`     VARCHAR(20)    NOT NULL,
    `active`     BOOLEAN        NOT NULL,
    PRIMARY KEY (id)
);