# Connecting PgAdmin to PostgreSQL Container

This guide explains how to access the PgAdmin interface and connect it to your PostgreSQL database container.

## 1. Access PgAdmin

1.  Open your browser.
2.  Go to: [http://localhost:5050](http://localhost:5050)
3.  **Login Credentials**:
    *   **Email**: `admin@training.com`
    *   **Password**: `pgadmin_secure_2026`

## 2. Register Server

Once logged in, follow these steps to add the server:

1.  Click on **Add New Server** (or right-click "Servers" -> Register -> Server).
2.  **General Tab**:
    *   **Name**: `Training Platform DB` (or any name you prefer).

3.  **Connection Tab**:
    *   **Host name/address**: `postgres`
        *   *Note: We use the container service name because PgAdmin is running within the same Docker network.*
    *   **Port**: `5432`
    *   **Maintenance database**: `postgres`
    *   **Username**: `postgres`
    *   **Password**: `root-postgres-password`
    *   **Save Password**: Toggle this **ON**.

4.  Click **Save**.

## 3. Verify Connection

1.  Expand the newly created server in the browser tree on the left.
2.  Navigate to **Databases** -> **training_platform**.
3.  You should see the schemas (`user_schema`, `course_schema`, etc.) under **Schemas**.
