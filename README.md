# auth-api-demo
auth-api-demo

System Requirements
-------------------

To compile and run this quickstart you will need:

* JDK 17
* Apache Maven 3.8.6
* Spring Boot 3.0.6
* Keycloak 21+
* Docker 20+

Starting and Configuring the Keycloak Server
-------------------

```shell
docker run --name keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin --network=host quay.io/keycloak/keycloak:21.0.0 start-dev --http-port=8180
```

You should be able to access your Keycloak Server at http://localhost:8180.

Log in as the admin user to access the Keycloak Administration Console. Username should be `admin` and password `admin`.

Import the [realm configuration file](config/realm-import.json) to create a new realm called `quickstart`.
For more details, see the Keycloak documentation about how to [create a new realm](https://www.keycloak.org/docs/latest/server_admin/index.html#_create-realm).

Build and Run the Quickstart
-------------------------------

   ````
   mvn spring-boot:run

   ````