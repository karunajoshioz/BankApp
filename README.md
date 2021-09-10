Requirements:
	● Deposit, withdraw and maintain a balance for multiple customers
	● Return a customer’s balance and the bank’s total balance
	● Prevent customers from withdrawing more money than they have in their account

An example test scenario
	When Alice deposits $30 and withdraws $20
	Then Alice’s balance will be $10 and the bank’s balance will be $10
	And Alice will be prevented from withdrawing $11 to prevent her balance going negative
	
# CashApp Coding Challenge
This is simple microservice built that will deposit amount to an account and withdraw the amounts  for a given customer.
It will check if the amount is greater than the users current balance else it will throw an user friendly message.

#Technologies Used:

Java
Spring Boot
In-memory H2 Database
Junit Test Cases

#Endpoints Used:

Deposit Endpoint: http://localhost:8080/deposit?name=Jane&amount=30(POST Request)
Withdrawal Endpoint: http://localhost:8080/withdraw?name=Jane&amount=20 (POST Request)
Balance Endpoint: http://localhost:8080/balance?name=Jane (GET Request)

In order to have negative balance, withdrawal endpoint to be executed twice with different amounts


#Tradeoffs:
 As this is a simple application, following checks are not considered
 	1. Authentication & Authorization
 	2. Entitlement Checks
 	3. Account Management
 	4. Logging & Proper Error management
 	
 	