CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id key auto increment',
  `name` VARCHAR(128) NOT NULL  DEFAULT '',
  `age` int(10) DEFAULT -1,
  `sex` int(10) DEFAULT -1,
  `identityCard`  bigint(128) NOT NULL  ,
  `site`  bigint(128) NOT NULL ,

  `properties` VARCHAR (1024) DEFAULT NULL COMMENT 'properties',
  `db_create_time` TIMESTAMP NOT NULL DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),

  foreign key (identityCard) references identityCard (id) ON DELETE CASCADE,
  foreign key (site) references site(id) ON DELETE CASCADE
);
CREATE TABLE `site` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id key auto increment',
  `province` VARCHAR(128) NOT NULL  DEFAULT '',
  `city` VARCHAR(128) NOT NULL  DEFAULT '',
  `properties` VARCHAR (1024) DEFAULT NULL COMMENT 'properties',
  `db_create_time` TIMESTAMP NOT NULL DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TABLE `identityCard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id key auto increment',
  `department` VARCHAR(128) NOT NULL  DEFAULT '',
  `post` VARCHAR(128) NOT NULL  DEFAULT '',
  `properties` VARCHAR (1024) DEFAULT NULL COMMENT 'properties',
  `db_create_time` TIMESTAMP NOT NULL DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)