create database if not exists oa;
use oa;

drop table if exists oa_user;

# 用户角色表
create table oa_user(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `user_id`         VARCHAR(128)  NOT NULL  COMMENT '用户id',
  `nickname`        VARCHAR(128)  NOT NULL  COMMENT '用户昵称',
  `identity`        VARCHAR(128)  NOT NULL  COMMENT '用户所属身份',
  `department`      VARCHAR(128)  NOT NULL  COMMENT '用户所在部门',
  `status`          BIGINT(20)    NOT NULL  COMMENT '用户状态  在职0 离职1',
  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `user_index` (`user_id`),
  UNIQUE  KEY `username_index` (`nickname`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='角色';


# 用户信息表
create table oa_userinfo(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `user_id`         VARCHAR(128)  NOT NULL  COMMENT '角色id',
  `user_pass`       VARCHAR(128)  NOT NULL  COMMENT '角色密码',
  `introduce`       VARCHAR(128)  NOT NULL  COMMENT '自我介绍',
  `interest`        VARCHAR(128)  NOT NULL  COMMENT '兴趣爱好',
  `telephone`       VARCHAR(128)  NOT NULL  COMMENT '联系方式',
  `share`           BIGINT(20)    NOT NULL  COMMENT '私有1  分享2',
  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `user_index` (`user_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='角色信息';

