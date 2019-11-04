use trash;

CREATE TABLE trash.trash_item
(
  id          int                                     NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name        varchar(255)  DEFAULT ''                NOT NULL,
  alias       varchar(512)  DEFAULT ''                NOT NULL,
  description      varchar(512)  DEFAULT ''                NOT NULL,
  type_id     int                                     NOT NULL,
  score       decimal(6, 2) DEFAULT 0                 NOT NULL,
  create_time TIMESTAMP     DEFAULT CURRENT_TIMESTAMP NOT NULL,
  update_time TIMESTAMP     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


CREATE TABLE trash.trash_type
(
  id          int                                    NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name        varchar(255) DEFAULT ''                NOT NULL,
  parent_id   int          DEFAULT 0                 NULL,
  create_time TIMESTAMP    DEFAULT CURRENT_TIMESTAMP NOT NULL,
  update_time TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
