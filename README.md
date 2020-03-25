###### Java11

# phvalidator
My webservice for CPF and CNPJ validation

Steps to start the webservice:
- Need MySQL installed
- Clone repository
- Import the folder into your workspace as a "Existing Maven Project"
- Download the dependencies if your IDE don't download it.
- Add the `application.properties` in you `src\main\resource` folder with the credentials
- Open the project folder in your terminal and run: `$ ./mvnw spring-boot:run `
- Done!! :grin:

`application.properties` file example:
```
#MySQL info
spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3307/phvalidator?createDatabaseIfNotExist=true&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=admin
#JWT info
jwt.secret=3ac9cdb4ca8688c34cedc1772ef24290
```


Routes:
- Post json to register a new user: `http://localhost:8080/register`

  ex.: 
    `{"username": "phfedev", "password": "123456"}`
    ![Register request image](http://phfedev.com.br/gitimages/register.png)
  

- Post json to login `http://localhost:8080/authenticate`
  
  ex.: `{ "username": "phfedev", "password": "123456" }`
  ![Login request image](http://phfedev.com.br/gitimages/login.png)
  Return your JWT to access the other routes

- Post json CPF `http://localhost:8080/cpf`
  
  ex.: `{ "cpf": "03642048290" }`
  ![Cpf Bearer token request image](http://phfedev.com.br/gitimages/validcpftoken.png)
  ![Cpf Bearer token request image](http://phfedev.com.br/gitimages/validcpfjson.png)
  
- Post json CNPJ `http://localhost:8080/cnpj`
  
  ex.: `{ "cnpj": "12372457000185" }`
  ![Cpf Bearer token request image](http://phfedev.com.br/gitimages/validcnpj.png)
  

  
