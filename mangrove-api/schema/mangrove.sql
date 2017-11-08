DROP DATABASE IF EXISTS mangrove;
CREATE DATABASE mangrove DEFAULT CHARACTER SET utf8;
USE mangrove;

##创建用户登录表
DROP TABLE IF EXISTS m_user_login;
CREATE TABLE m_user_login (
   user_login_id   VARCHAR(32)  PRIMARY KEY NOT NULL  COMMENT '登录id',
   user_id         VARCHAR (32) NOT NULL COMMENT '用户id',
   user_phone      VARCHAR(30)  NOT NULL COMMENT '电话号码',
   user_pwd        VARCHAR(32)  NOT NULL COMMENT '用户密码',
   login_time      DATETIME     NULL COMMENT '登陆时间',
   login_ip        VARCHAR(32)  NULL COMMENT '登录ip'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

##创建用户信息表
DROP TABLE IF EXISTS m_user;
CREATE TABLE m_user (
   user_id         VARCHAR(32)  PRIMARY KEY NOT NULL  COMMENT '用户id',
   nick_name       VARCHAR(32)  NOT NULL COMMENT '用户昵称',
   address         VARCHAR(200) NULL COMMENT '居住地址',
   sex             CHAR(1)      NULL COMMENT '用户性别',
   resume          VARCHAR(200) NULL COMMENT '个人简介'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


##创建用户登录日志表
DROP TABLE IF EXISTS m_login_log;
CREATE TABLE m_login_log (
   login_log_id  VARCHAR(32) PRIMARY KEY NOT NULL  COMMENT '日志id',
   user_id       VARCHAR(32)  NOT NULL COMMENT '用户昵id',
   login_ip      VARCHAR(32)  NULL COMMENT '登录ip',
   login_time    DATETIME     NULL COMMENT '登陆时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

##插入初始化数据
INSERT INTO m_user_login(user_login_id,user_id,user_phone,user_pwd)
             VALUES('1','UID0001','admin','123');

INSERT INTO m_user_login (user_login_id,user_id,user_phone,user_pwd)
             VALUES('ULID20171108XXXX','UID18664572521','18664572521','123456');
COMMIT;