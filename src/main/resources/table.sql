create database if not exists oa;
use oa;

drop table if exists oa_user;
drop table if exists oa_userinfo;
drop table if exists oa_sundry;

# 用户角色表
create table oa_user(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `user_id`         VARCHAR(128)  NOT NULL  COMMENT '用户id',
  `nickname`        VARCHAR(128)  NOT NULL  COMMENT '用户昵称',
  `status`        VARCHAR(128)  NOT NULL  COMMENT '用户所属身份',
  `department`      VARCHAR(128)  NOT NULL  COMMENT '用户所在部门',
  `state`          BIGINT(20)    NOT NULL  COMMENT '用户状态  在职0 离职1',
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
  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `userinfo_index` (`user_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='角色信息';


# 数据字典表
create table oa_sundry(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `sundry_id`       BIGINT(20)    NOT NULL  COMMENT '字典id',
  `sundry_key`             VARCHAR(128)  NOT NULL  COMMENT 'key',
  `sundry_value`           VARCHAR(128)  NOT NULL  COMMENT 'value',
  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `sundry_type` (`sundry_key`, `sundry_value`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='数据字典';

# 预留数据
insert into oa_user(user_id,nickname,status,department,state,db_create_time,db_update_time)
values(1,"123456","1","2","2",now(),now());

insert into oa_userinfo(user_id,user_pass,introduce,interest,telephone,db_create_time,db_update_time)
values(1,"123456","天下谁人不识君","羽毛球","15128888888",now(),now());

insert into oa_sundry(sundry_id,sundry_key,sundry_value,db_create_time,db_update_time)
values(1,"IDENTITY","管理员",now(),now());

insert into oa_sundry(sundry_id,sundry_key,sundry_value,db_create_time,db_update_time)
values(1,"DEPARTMENT","研发部",now(),now());