# Quarkus API for User and Property Management

This Quarkus-based API project provides functionality for user management, role-based access control, token authentication, and property management. The project is built using Quarkus, MySQL, and Java, and it includes well-tested unit tests.

## Features

### User Management

- **Create User:**
  - Securely create a user with hashed passwords.

- **User Roles:**
  - Users have roles for fine-grained access control.

- **Update Password:**
  - Users can securely update their passwords.

- **Add User Role:**
  - Assign roles to users for access control.

- **Add Users to User Group:**
  - Organize users into user groups.

- **Generate Login Token:**
  - Generate a login token for authentication.

- **Build Access Token:**
  - Build access tokens for authorized requests.

- **Logout:**
  - Log users out of the system.

### Admin Features

- **Create Tenant:**
  - Admins can create tenants for property management.

- **Update Tenant:**
  - Modify tenant details.

- **Delete Tenant:**
  - Remove a tenant from the system.

- **Find One Tenant:**
  - Retrieve details of a specific tenant.

- **See All Tenants:**
  - Fetch a list of all tenants.

- **Get Tenant by Plot:**
  - Retrieve tenant information based on the assigned plot.

- **Create Plots:**
  - Admins can create plots for property management.

- **Update Plots:**
  - Modify plot details.

- **See Plots and Vacant Rooms:**
  - Retrieve a list of all plots and vacant rooms.

## Technologies Used

- [Quarkus](https://quarkus.io/) - A Kubernetes Native Java framework.
- [MySQL](https://www.mysql.com/) - A relational database management system.
- [JUnit](https://junit.org/) - A popular unit testing framework for Java.

## Getting Started

1. Clone the repository.
2. Set up the MySQL database and update the connection details in the application.
3. Build and run the Quarkus application.

## Running the Tests

Well-tested unit tests ensure the reliability of the API endpoints. To run the tests, use the following command:

```bash
./mvnw test

Contributions are welcome
