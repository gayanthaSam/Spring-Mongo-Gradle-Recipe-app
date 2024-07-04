-- Use to run mysql db docker image
-----------------------------------
-- docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

-- connect to mysql and run as root user

--Create Databases
CREATE DATABASE gaya_dev;
CREATE DATABASE gaya_prod;

--Create database service accounts
CREATE USER 'gaya_dev_user'@'%' IDENTIFIED BY 'gaya';
CREATE USER 'gaya_prod_user'@'%' IDENTIFIED BY 'gaya';

--Database grants
GRANT SELECT ON gaya_dev.* to 'gaya_dev_user'@'%';
GRANT INSERT ON gaya_dev.* to 'gaya_dev_user'@'%';
GRANT DELETE ON gaya_dev.* to 'gaya_dev_user'@'%';
GRANT UPDATE ON gaya_dev.* to 'gaya_dev_user'@'%';
GRANT SELECT ON gaya_prod.* to 'gaya_prod_user'@'%';
GRANT INSERT ON gaya_prod.* to 'gaya_prod_user'@'%';
GRANT DELETE ON gaya_prod.* to 'gaya_prod_user'@'%';
GRANT UPDATE ON gaya_prod.* to 'gaya_prod_user'@'%';