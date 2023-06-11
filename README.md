# contact-management-api

* Auther: Knoldus
*  Swagger: http://localhost:8080/swagger-ui/index.html


| Framework   | Version |
|-------------|---------|
| Maven       | 4.0.0   |
| Java        | 1.8      |
| Spring Boot | 2.7.12  |


# *API are secured by a API key*
 * username - apiKey
 * password - secret

# **Steps to set up the feed service**
<details><summary></summary>
</details>

* **Clone the project from the given repository**
    * **Command:** git clone (https://github.com/AnuradhaKumari201/contact-management-api.git)
* **Import the customer-management service into the ide**

* **Build the Application**
   * **Command:** mvn clean install

* **Run the Application**  

### Endpoints:
 -Get all customer
```
curl --location 'http://localhost:8080/api/v1/contact/' \
--header 'Content-Type: application/json' \
--header 'apiKey: secret' \
--data-raw '{
  "first_name": "Anuradha",
  "last_name":"Jha",
  "phone_number":"6289809557",
  "email":"anuradha.kumari@knoldus.com"
}
```
-Get all customer by ID
```
curl --location --request GET 'http://localhost:8080/api/v1/contact/1' \
--header 'Content-Type: application/json' \
--header 'apiKey: secret' \
--data-raw '{
  "first_name": "Anuradha",
  "last_name":"Jha",
  "phone_number":"6289809557",
  "email":"anuradha.kumari@knoldus.com"
}'
```
-Add the customer details
```
curl --location 'http://localhost:8080/api/v1/contact/' \
--header 'Content-Type: application/json' \
--header 'apiKey: secret' \
--data-raw '{
  "first_name": "Anupriya",
  "last_name":"Mishra",
  "phone_number":"6289809557",
  "email":"anuradha.kumari@knoldus.com"
}'
```
-update a existing record by ID

```
curl --location --request PUT 'http://localhost:8080/api/v1/contact/save/1' \
--header 'Content-Type: application/json' \
--header 'apiKey: secret' \
--data-raw '{
  "first_name": "Anupam",
  "last_name":"Mishra",
  "phone_number":"6289809557",
  "email":"anuradha.kumari@knoldus.com"
}'
```
-Get the customer record by firstName

```
curl --location --request GET 'http://localhost:8080/api/v1/contact/firstName?firstName=Anu' \
--header 'Content-Type: application/json' \
--header 'apiKey: secret' \
--data-raw '{
  "first_name": "Anupam",
  "last_name":"Mishra",
  "phone_number":"6289809557",
  "email":"anuradha.kumari@knoldus.com"
}'
```
-Delete the customer record by lastName

```
curl --location --request GET 'http://localhost:8080/api/v1/contact/lastName?lastName=jha' \
--header 'Content-Type: application/json' \
--header 'apiKey: secret' \
--data-raw '{
  "first_name": "Anupam",
  "last_name":"Mishra",
  "phone_number":"6289809557",
  "email":"anuradha.kumari@knoldus.com"
}'
```
-Delete the customer record by email

```
curl --location --request GET 'http://localhost:8080/api/v1/contact/email?email=anu.jha%40gmail.com' \
--header 'Content-Type: application/json' \
--header 'apiKey: secret' \
--data-raw '{
  "first_name": "Anupam",
  "last_name":"Mishra",
  "phone_number":"6289809557",
  "email":"anuradha.kumari@knoldus.com"
}'
```



