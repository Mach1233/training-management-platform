#!/bin/bash
set -e

# Read password from secret file and strip CRLF
password=$(cat /run/secrets/training_admin_password | tr -d '\r')

# Create Database
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE DATABASE training_platform;
EOSQL

# Connect to the new database and set up schemas/users
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "training_platform" <<-EOSQL
	-- Create all 6 schemas
	CREATE SCHEMA user_schema;
	CREATE SCHEMA course_schema;
	CREATE SCHEMA registration_schema;
	CREATE SCHEMA workflow_schema;
	CREATE SCHEMA certification_schema;
	CREATE SCHEMA analytics_schema;

	-- Create application user with password from secret
	CREATE USER training_admin WITH ENCRYPTED PASSWORD '$password';

	-- Allow user to use schemas including public
	GRANT USAGE ON SCHEMA 
	    user_schema, course_schema, registration_schema, 
	    workflow_schema, certification_schema, analytics_schema, public
	TO training_admin;
	
    -- Grant full access to public schema (required for Keycloak)
    GRANT ALL ON SCHEMA public TO training_admin;

	-- Give full rights on tables (now and future)
	ALTER DEFAULT PRIVILEGES IN SCHEMA user_schema GRANT ALL ON TABLES TO training_admin;
	ALTER DEFAULT PRIVILEGES IN SCHEMA course_schema GRANT ALL ON TABLES TO training_admin;
	ALTER DEFAULT PRIVILEGES IN SCHEMA registration_schema GRANT ALL ON TABLES TO training_admin;
	ALTER DEFAULT PRIVILEGES IN SCHEMA workflow_schema GRANT ALL ON TABLES TO training_admin;
	ALTER DEFAULT PRIVILEGES IN SCHEMA certification_schema GRANT ALL ON TABLES TO training_admin;
	ALTER DEFAULT PRIVILEGES IN SCHEMA analytics_schema GRANT ALL ON TABLES TO training_admin;

	-- Allow connection to database
	GRANT CONNECT ON DATABASE training_platform TO training_admin;
EOSQL
