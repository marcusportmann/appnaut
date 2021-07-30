#!/bin/sh

# Execute the following command to allow the script to be executed on MacOS:
#   xattr -d com.apple.quarantine initialize_demo_postgresql_database.sh

liquibase --changeLogFile=../src/main/resources/db/demo.changelog.xml --username=demo --password=demo --url=jdbc:postgresql://localhost:5432/demo --classpath=postgresql-42.2.14.jar --driver=org.postgresql.Driver --liquibaseSchemaName=liquibase update


