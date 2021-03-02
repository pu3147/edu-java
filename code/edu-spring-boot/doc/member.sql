create database db_demo;
CREATE USER 'demo'@'%' IDENTIFIED BY '111111';

GRANT ALL PRIVILEGES ON db_demo.* TO 'demo'@'%' WITH GRANT OPTION;
flush privileges;

DROP TABLE IF EXISTS t_mem_user;

CREATE TABLE t_mem_user (
	id INT (10) PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
	name VARCHAR (64) COMMENT '姓名',
	age INT (3) COMMENT '年级',
	self_desc VARCHAR (64) COMMENT '自我描述',
	birth_day DATETIME COMMENT '生日'
) COMMENT '用户表';