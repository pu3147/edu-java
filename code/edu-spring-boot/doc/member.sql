create database db_demo;
CREATE USER 'demo'@'%' IDENTIFIED BY '111111';

GRANT ALL PRIVILEGES ON db_demo.* TO 'demo'@'%' WITH GRANT OPTION;
flush privileges;

CREATE TABLE t_mem_user (
	id INT (10) PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
	NAME VARCHAR (64) COMMENT '姓名',
	sel_des VARCHAR (64) COMMENT '自我描述',
	age INT(3) COMMENT '年级'
) comment '用户表';