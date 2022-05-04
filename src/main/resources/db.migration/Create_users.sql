CREATE TABLE if not exists portal_users
(
   id          BIGINT AUTO_INCREMENT         NOT NULL,
   username    VARCHAR(100)                  NULL,
   full_name   VARCHAR(255)                  NULL,
   password    VARCHAR(255)                  NULL,
   email       VARCHAR(30)                   NULL,
   phone_no    VARCHAR(20)                   NULL,
   Deleted     VARCHAR(5) DEFAULT 'NO'       NULL,
   CONSTRAINT  pk_portal_users  PRIMARY KEY (id),
   CONSTRAINT  email_cx   UNIQUE (email),
   CONSTRAINT  phone_no_cx  UNIQUE (phone_no),
   CONSTRAINT  username_cx  UNIQUE (username),
);

CREATE TABLE IF NOT EXISTS user_roles
(
    id          BIGINT AUTO_INCREMENT  NOT NULL,
    role_name   VARCHAR(200)           NULL,
    CONSTRAINT  pk_user_roles PRIMARY KEY (id),
    CONSTRAINT  name_cx       UNIQUE(role_name)
);

CREATE TABLE IF NOT EXISTS portal_user_userrols
(
    role_id     BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (role_id)   REFERENCES user_roles(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id)   REFERENCES portal_users(id) ON DELETE CASCADE,
    CONSTRAINT   user_to_role_cx UNIQUE (role_id, user_roles)
);