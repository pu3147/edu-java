create database db_demo;
CREATE USER 'demo'@'%' IDENTIFIED BY '111111';

GRANT ALL PRIVILEGES ON db_demo.* TO 'demo'@'%' WITH GRANT OPTION;
flush privileges;
