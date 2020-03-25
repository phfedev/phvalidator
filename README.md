# phvalidator
My webservice for CPF and CNPJ validation

Steps to start the webservice:
- Clone repository
- Import the folder into your workspace as a "Existing Maven Project"
- Download the dependencies if your IDE don't download it.
- Open the project folder in your terminal and run: `$ ./mvnw spring-boot:run `
- Done!! :D

Routes:
- Post json to login `http://localhost:8080/authenticate`
  
  ex.: `{ "username": "springuser", "password": "password" }`
  Return your JWT to access the other routes

- Post json CPF `http://localhost:8080/cpf`
  
  ex.: `{ "cpf": "03642048290" }`
  
- Post json CNPJ `http://localhost:8080/cnpj`
  
  ex.: `{ "cnpj": "12372457000185" }`
