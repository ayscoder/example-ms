#Creates the new database
create database ays_db;

#Creates the user
create user 'ays'@'%' identified by 'ays';

#Gives all privileges to the new user on the newly created database
grant all on ays_db.* to 'ays'@'%';

Testing via curl
---------------------------
Create
curl -H 'Content-Type: application/json' -X POST 'http://localhost:8080/v1/users' -d '{"name":"name-3","email":"email-3@gmail.com"}' -s

Find
curl -H 'Content-Type: application/json' 'http://localhost:8080/v1/users' -s

Make Some Security Changes
---------------------------
When you are on a production environment, you may be exposed to SQL injection attacks.
A hacker may inject DROP TABLE or any other destructive SQL commands.
So, as a security practice, you should make some changes to your database before you expose the application to your users.
The following command revokes all the privileges from the user associated with the Spring application:
mysql> revoke all on db_example.* from 'ays'@'%';

Now the Spring application cannot do anything in the database.
The application must have some privileges, so use the following command to grant the minimum privileges the application needs:
mysql> grant select, insert, delete, update on db_example.* to 'ays'@'%';

Removing all privileges and granting some privileges gives your Spring application the privileges necessary to make changes to only the data of
the database and not the structure (schema). When you want to make changes to the database:
Re grant permissions.
Change the spring.jpa.hibernate.ddl-auto to update.
Re-run your applications.
