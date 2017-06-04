# My-Retail-RESTFul-Service
This is a RESTful service that provides API to get the product details from an external API and get the price details from the database and provide integrated results to the users.
It also provides API to change the price of the product.

Technologies used:
	•	Spring boot (v1.5.3.RELEASE)
	•	Cassandra 3.9.0 (Datastax community edition)
	•	JUnit 4.12
	•	Spring Tool Suit 3.8.4.RELEASE
Prerequisites:
	•	Java 8
	•	Datastax DDC Server 3.9.0
	•	Postman
Execution Procedure:
	•	Run the following command in command prompt
		o	java -jar target\myretailservice-0.0.1-SNAPSHOT.jar
	•	Enter the following urls in the address bar of a web browser to get the product details.
		o	https://localhost:8085/product/13860428
	•	To access the get method open Postman enter the url in the address bar and select method PUT.
		o	https://localhost:8085/product/13860428
	•	The request to the PUT method must be sent in JSON format in message body.
		o	{"currentPrice":{"price":99.9,"currency":"USD"}}
