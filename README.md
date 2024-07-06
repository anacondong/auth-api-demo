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

Test Access
-------------------------------

```shell
curl -X POST http://localhost:8180/realms/quickstart/protocol/openid-connect/token -H 'content-type: application/x-www-form-urlencoded' -d 'client_id=authz-servlet&client_secret=secret' -d 'username=jdoe&password=jdoe&grant_type=password'
```

```shell
curl -X POST http://localhost:8180/realms/quickstart/protocol/openid-connect/token -H 'content-type: application/x-www-form-urlencoded' -d 'client_id=authz-servlet&client_secret=secret' -d 'username=alice&password=alice&grant_type=password'
```

You should be able to obtain tokens for any of these users:

| Username | Password | Roles        |
|----------|----------|--------------|
| jdoe     | jdoe     | user_premium |
| alice    | alice    | user         |


Verify Access
-------------------------------

```shell
-----curl --location --request GET 'http://localhost:8080/' \
--header Authorization: Bearer xxxxxxx
```

```shell
-----curl --location --request GET 'http://localhost:8080/protected/premium' \
--header Authorization: Bearer xxxxxxx
```

References
--------------------
* [Spring OAuth 2.0 Resource Server JWT](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)
* [Keycloak Authorization Services](https://www.keycloak.org/docs/latest/authorization_services/)
* [Keycloak Documentation](https://www.keycloak.org/documentation)