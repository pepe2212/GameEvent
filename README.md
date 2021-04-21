# GameEvent

To have this project up and runnig, follow the next steps:

1)First, set up Kafka before running the app

	1.1) Go to official site at https://kafka.apache.org/downloads and download the Kafka 2.8 version, in case you don't want to go there, the source is here in this project, in  the folder called Kafka. 
	
	@Consider:
	A)In case you have downloaded it from the site, unzip the folder and rename the folder to a shorter name, this is to avoid to get an error due to the longer name of the folder.
	B)In case you use the Kakfa folder provided in this repository, you don't need to unzip and rename the name of the folder.

	1.2)Then, access to the bin/windows folder and run the next commands to start the next instances:
Zookeper:
zookeeper-server-start.bat ..\..\config\zookeeper.properties
![image](https://user-images.githubusercontent.com/78396172/115475476-4fa9db00-a205-11eb-9c63-a7431bf934cc.png)

Kafka:
kafka-server-start.bat ..\..\config\server.properties
![image](https://user-images.githubusercontent.com/78396172/115476060-a237c700-a206-11eb-90f7-2742f1bdb0f2.png)

	1.3)Then, use this command to create a topic called "novice-players"
kafka-topics.bat --create --topic novice-players --bootstrap-server localhost:9092	
![image](https://user-images.githubusercontent.com/78396172/115476209-065a8b00-a207-11eb-9c24-91187ea87d70.png)
	
	1.4)And Finally, make sure the application.properties file have the following properties, once you have imported the project:
	spring.kafka.producer.bootstrap-servers=localhost:9092
	spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
	spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer

	
 2)Second, Set up H2 before running the app
 
	2.1)Once you have imported the project, go to application.properties file and make sure the key and values are as follows:
	spring.datasource.url=jdbc:h2:mem:testdb
	spring.datasource.driverClassName=org.h2.Driver
	spring.datasource.username=sa
	spring.datasource.password=

3)Import the Maven Project, which will load all dependencies defined in the POM.xml file in the project(In my case I'm using STS)

![image](https://user-images.githubusercontent.com/78396172/115479181-7e2bb400-a20d-11eb-91d8-397fbd1f46f8.png)
 


4)Start the app by running the main Class PlayersProjectApplication.java that is annotated with @SpringBootApplication

5)Finally hit the http://localhost:8282/api/v1/players endpoint(this endpoint is defined in the RestController Class) by using any HTTP Client tool(in this case I will use Postman) 
![image](https://user-images.githubusercontent.com/78396172/115480516-3fe3c400-a210-11eb-958c-40e00f10becf.png)

6)You will see the result like this
![image](https://user-images.githubusercontent.com/78396172/115480910-19725880-a211-11eb-9ff5-73e0254567e2.png)


