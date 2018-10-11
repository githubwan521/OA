create database if not exists oa;
use oa;

drop table if exists oa_userinfo;
drop table if exists oa_business_card_holder;
drop table if exists oa_business_card;
drop table if exists oa_address_list;
drop table if exists oa_schedule;
drop table if exists oa_note;
drop table if exists oa_bbs;
drop table if exists oa_conference_room;
drop table if exists oa_conference_room_equipment;
drop table if exists oa_conference_room_reservation;
drop table if exists oa_sundry;
drop table if exists oa_user;
drop table if exists oa_bbs;


###-----------------------------个人办公
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

# 名片夹表
create table oa_business_card_holder(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `bch_id`          VARCHAR(20)   NOT NULL  COMMENT '名片夹id',
  `bch_name`        VARCHAR(128)  NOT NULL  COMMENT '名片夹名',
  `user_id`         VARCHAR(128)  NOT NULL  COMMENT '所属用户id',
  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `bch_id_index` (`bch_id`),
  UNIQUE  KEY `user_card` (`user_id`,`bch_id`),
  UNIQUE  KEY `bch_name` (`bch_name`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='名片夹分类';
#所有人都会有共享名片夹,不可删除,共享名片夹信息共享,用户可将自己的好友名片共享在此

# 个人名片表
create table oa_business_card(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `card_id`         VARCHAR(20)   NOT NULL  COMMENT '个人名片id',
  `bch_id`          VARCHAR(20)   NOT NULL  COMMENT '所在名片夹id',
  `owner_id`        VARCHAR(20)   NOT NULL  COMMENT '所属着id',
  `memoname`        VARCHAR(128)  NOT NULL  COMMENT '对好友的备注',
  `friend_id`       VARCHAR(20)   NOT NULL  COMMENT '好友角色id',

  `attribute`       BIGINT(20)    NOT NULL  COMMENT '个人名片属性,0私有  1公开  9在共享名片夹',
  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `card_id_index` (`card_id`),
  UNIQUE  KEY `business_card_status` (`owner_id`, `friend_id`,attribute)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='个人名片';

# 通讯录表
create table oa_address_list(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `al_id`           VARCHAR(20)   NOT NULL  COMMENT '通讯录id',
  `user_id`         VARCHAR(20)   NOT NULL  COMMENT '用户id',

  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `al_id_index` (`al_id`),
  UNIQUE  KEY `user_info_index` (`user_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='通讯录';

# 日程安排表
create table oa_schedule(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `schedule_id`     VARCHAR(20)   NOT NULL  COMMENT '日程id',
  `user_id`         VARCHAR(20)   NOT NULL  COMMENT '所属者',
  `readers_id`      VARCHAR(20)   NOT NULL  COMMENT '可看见的人id',
  `assign_id`       VARCHAR(20)   NOT NULL  COMMENT '指派人id  多个值以,分割',
  `title`           VARCHAR(20)   NOT NULL  COMMENT '日程标题',
  `content`         VARCHAR(20)   NOT NULL  COMMENT '日程内容',
  `start_time`      BIGINT(20)    NOT NULL  COMMENT '开始时间',
  `end_time`        BIGINT(20)    NOT NULL  COMMENT '结束时间',

  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `schedule_index` (`schedule_id`),
  UNIQUE  KEY `schedule` (`user_id`, `title`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='日程安排';

# 待办工作表
create table oa_note(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `note_id`         VARCHAR(20)   NOT NULL  COMMENT '笔记id',
  `user_id`         VARCHAR(20)   NOT NULL  COMMENT '所属者',
  `title`           VARCHAR(20)   NOT NULL  COMMENT '笔记标题',
  `content`         VARCHAR(20)   NOT NULL  COMMENT '笔记内容',

  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `note_index` (`note_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='代办工作';

# 在线信息表
create table oa_bbs(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `bbs_id`          VARCHAR(20)   NOT NULL  COMMENT '留言id',
  `user_id`         VARCHAR(20)   NOT NULL  COMMENT '所属者',
  `send_id`         VARCHAR(20)   NOT NULL  COMMENT '发送方',
  `recv_id`         VARCHAR(20)   NOT NULL  COMMENT '接收方--多个值以,分割',
  `title`           VARCHAR(20)   NOT NULL  COMMENT '留言标题',
  `content`         VARCHAR(20)   NOT NULL  COMMENT '留言内容',
  `status`          VARCHAR(20)   NOT NULL  COMMENT '留言状态  0草稿  1已发送 2未阅读  3已阅读',

  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `note_index` (`bbs_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='在线信息';




###---------------------------------会议管理
# 会议室表
create table oa_conference_room(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `cr_id`           VARCHAR(20)   NOT NULL  COMMENT '会议室id',
  `cr_name`         VARCHAR(20)   NOT NULL  COMMENT '会议室名',
  `cr_status`       VARCHAR(20)   NOT NULL  COMMENT '会议室状态  0未使用  1预约中 2使用中  9已删除',

  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `cr_index` (`cr_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='会议室';

# 会议室设备表
create table oa_conference_room_equipment(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `cre_id`          VARCHAR(20)   NOT NULL  COMMENT '会议室设备id',
  `cre_name`        VARCHAR(20)   NOT NULL  COMMENT '会议室设备名',
  `cre_info`        VARCHAR(20)   NOT NULL  COMMENT '会议室设备信息',
  `cre_status`      VARCHAR(20)   NOT NULL  COMMENT '会议室设备状态  0未使用  1预约中 2使用中  9已删除',

  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `cre_index` (`cre_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='会议室设备';

# 会议室预约记录表
create table oa_conference_room_reservation(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `crr_id`          VARCHAR(20)   NOT NULL  COMMENT '预约记录id',
  `applicant_id`    VARCHAR(20)   NOT NULL  COMMENT '申请人id',
  `cr_id`           VARCHAR(20)   NOT NULL  COMMENT '申请的会议室id',
  `cre_ids`         VARCHAR(20)   NOT NULL  COMMENT '申请的会议室设备id--多个值以,分割',
  `user_ids`        VARCHAR(20)   NOT NULL  COMMENT '参与人员id--多个值以,分割',

  `start_time`      BIGINT(20)    NOT NULL  COMMENT '会议开始时间',
  `end_time`        BIGINT(20)    NOT NULL  COMMENT '会议结束时间',

  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `crr_index` (`crr_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='会议室设备';




###----------------------------------系统管理
# 组织管理表
create table oa_sundry(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `sundry_id`       BIGINT(20)    NOT NULL  COMMENT '字典id',
  `sundry_key`      VARCHAR(128)  NOT NULL  COMMENT 'key',
  `sundry_value`    VARCHAR(128)  NOT NULL  COMMENT 'value',
  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `sundry_index` (`sundry_id`),
  UNIQUE  KEY `sundry_type` (`sundry_key`, `sundry_value`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='数据字典';

# 用户角色表
create table oa_user(
  `id`              BIGINT(20)    NOT NULL  AUTO_INCREMENT,
  `user_id`         VARCHAR(128)  NOT NULL  COMMENT '用户id',
  `nickname`        VARCHAR(128)  NOT NULL  COMMENT '用户昵称',
  `status`          VARCHAR(128)  NOT NULL  COMMENT '用户所属身份',
  `department`      VARCHAR(128)  NOT NULL  COMMENT '用户所在部门',
  `state`           BIGINT(20)    NOT NULL  COMMENT '用户状态  在职0 离职1',
  `db_create_time`  TIMESTAMP     NOT NULL  DEFAULT '2017-01-01 00:00:00' COMMENT 'create time of record, for db',
  `db_update_time`  TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (`id`),
  UNIQUE  KEY `user_index` (`user_id`),
  UNIQUE  KEY `username_index` (`nickname`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT='用户角色';



# 初始数据
# 身份类别
insert into oa_sundry(sundry_id,sundry_key,sundry_value,db_create_time,db_update_time)
values(1,"IDENTITY","普通员工",now(),now());

# 部门类别
insert into oa_sundry(sundry_id,sundry_key,sundry_value,db_create_time,db_update_time)
values(2,"DEPARTMENT","研发部",now(),now());

# 共享名片夹
insert into oa_business_card_holder(bch_id,user_id,bch_name,db_create_time,db_update_time)
values(1,"1","共享名片夹",now(),now());


# 用户
insert into oa_user(user_id,nickname,status,department,state,db_create_time,db_update_time)
values(1,"motian","1","2","0",now(),now());

# 管理员创建用户后    自动创建下列信息
## 用户的个人信息---默认填空
insert into oa_userinfo(user_id,user_pass,introduce,interest,telephone,db_create_time,db_update_time)
values(1,"123456","天下谁人不识君","羽毛球","15128888888",now(),now());
# 通讯录---添加至公司通讯录中
insert into oa_address_list(al_id,user_id,db_create_time,db_update_time)
values("1","1",now(),now());

# 用户2
insert into oa_user(user_id,nickname,status,department,state,db_create_time,db_update_time)
values(2,"tianmo","2","1","0",now(),now());
# 用户2信息
insert into oa_userinfo(user_id,user_pass,introduce,interest,telephone,db_create_time,db_update_time)
values(2,"123456","君识不人谁下天","乒乓求","18888888888",now(),now());

# 名片夹--包含share
insert into oa_business_card_holder(bch_id,user_id,bch_name,db_create_time,db_update_time)
values(2,"1","我的好友",now(),now());

# 好友名片
insert into oa_business_card(card_id,bch_id,owner_id,memoname,friend_id,attribute,db_create_time,db_update_time)
values("1","2","1","宫","2",1,now(),now());
insert into oa_business_card(card_id,bch_id,owner_id,memoname,friend_id,attribute,db_create_time,db_update_time)
values("2","1","1","宫","2",9,now(),now());#共享到共享名片夹中

# 日程安排
insert into oa_schedule(schedule_id,user_id,readers_id,assign_id,title,content,start_time,end_time,db_create_time,db_update_time)
values("1","1","2","2","出行","协调接口",1,1,now(),now());

# 待办工作
insert into oa_note(note_id,user_id,title,content,db_create_time,db_update_time)
values("1","1","未完","写数据库日志",now(),now());

# 留言
insert into oa_bbs(bbs_id,user_id,send_id,recv_id,title,content,status,db_create_time,db_update_time)
values("1","1","1","2","今日安排","放假",1,now(),now());
insert into oa_bbs(bbs_id,user_id,send_id,recv_id,title,content,status,db_create_time,db_update_time)
values("2","2","1","2","今日安排","放假",2,now(),now());

# 会议室设备
insert into oa_conference_room_equipment(cre_id,cre_name,cre_info,cre_status,db_create_time,db_update_time)
values("1","投影仪","小米","0",now(),now());

# 会议室
insert into oa_conference_room(cr_id,cr_name,cr_status,db_create_time,db_update_time)
values("1","F101","0",now(),now());

# 会议预约记录
insert into oa_conference_room_reservation(crr_id,applicant_id,cr_id,cre_ids,user_ids,start_time,end_time,db_create_time,db_update_time)
values("1","1","1","1","2","1","1",now(),now());
