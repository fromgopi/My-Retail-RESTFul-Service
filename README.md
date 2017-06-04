# My-Retail-RESTFul-Service
This is a RESTful service that provides API to get the product details from an external API and get the price details from the database and provide integrated results to the users. <br />
It also provides API to change the price of the product. <br />

*Technologies used:* 

	Spring boot (v1.5.3.RELEASE)
	Cassandra 3.9.0 (Datastax community edition) 
	Spring Tool Suit 3.8.4.RELEASE 
	JUnit 4.12 
*Prerequisites:* 

	Java 8 
	Datastax DDC Server 3.9.0
	Postman 
*Execution Procedure:*

		Run the following command in command prompt <br />
			java -jar target\myretailservice-0.0.1-SNAPSHOT.jar <br />
		Enter the following urls in the address bar of a web browser to get the product details. <br />
			https://localhost:8085/product/13860428 <br />
		To access the get method open Postman enter the url in the address bar and select method PUT. <br />
			https://localhost:8085/product/13860428 <br />
		The request to the PUT method must be sent in JSON format in message body. <br />
			{"currentPrice":{"price":99.9,"currency":"USD"}} <br />
