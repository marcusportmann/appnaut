#!/bin/sh

# Execute the following command to allow the script to be executed on MacOS:
#   xattr -d com.apple.quarantine initialize_jta_test_postgresql_databases.sh

dropdb --if-exists db1
createdb  --template=template0 --encoding=UTF8 db1
psql --dbname=db1 --command="DROP ROLE IF EXISTS db1;"
psql --dbname=db1 --command="CREATE ROLE db1 WITH LOGIN PASSWORD 'db1';"
psql --dbname=db1 --command="GRANT ALL PRIVILEGES ON DATABASE db1 to db1;"
psql --dbname=db1 --command="ALTER USER db1 WITH SUPERUSER;"
psql --dbname=db1 --command="CREATE SCHEMA liquibase;"

liquibase --changeLogFile=../src/main/resources/db/demo.changelog.xml --username=db1 --password=db1 --url=jdbc:postgresql://localhost:5432/db1 --classpath=postgresql-42.2.14.jar --driver=org.postgresql.Driver --liquibaseSchemaName=liquibase update

dropdb --if-exists db2
createdb  --template=template0 --encoding=UTF8 db2
psql --dbname=db2 --command="DROP ROLE IF EXISTS db2;"
psql --dbname=db2 --command="CREATE ROLE db2 WITH LOGIN PASSWORD 'db2';"
psql --dbname=db2 --command="GRANT ALL PRIVILEGES ON DATABASE db2 to db2;"
psql --dbname=db2 --command="ALTER USER db2 WITH SUPERUSER;"
psql --dbname=db2 --command="CREATE SCHEMA liquibase;"

liquibase --changeLogFile=../src/main/resources/db/demo.changelog.xml --username=db2 --password=db2 --url=jdbc:postgresql://localhost:5432/db2 --classpath=postgresql-42.2.14.jar --driver=org.postgresql.Driver --liquibaseSchemaName=liquibase update


