# SpringDemo

Eclipse project demonstrating SpringBoot with Hibernate and SpringSecurity using MySql DB. 

Developer with:

Spring Tool Suite 4 <br />
Version: 4.7.0.RELEASE<br />
Build Id: 202006181331<br />
OS: Windows 10, v.10.0, x86_64 / win32<br />
Java version: 1.8.0_251<br />


The application has the following features:
-----------
- **a**: SpringBoot REST API
- **b**: SpringBoot security
- **c**: Example of Db normalization
- **d**: ORD (JPA - Hibernate)
- **e**: Simple UI
- **f**: Unit tests with Mockito


Project SetUp:
-----------
* open Eclipse STS and import maven project (the root dir)
* open application.properties and set your MySql field for userName and password
* in the application.properties also set your DB name (eg: jdbc:mysql://localhost:3306/world) - change world to the name of your DB
* also you can customize the port app is running on. The default one is 9091.


Application Usage:
-----------
* Right click on project spring-boot-demo -> run as -> spring boot app or java app
* Open the browser and goTo http://localhost:9091/
* You will be promted with a login screen

- predifend users and pass:
 - username: user1  password: 1234
 - username: user2  password: 1234
 - username: user3  password: 1234