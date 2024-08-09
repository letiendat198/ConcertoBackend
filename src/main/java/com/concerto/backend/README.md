# Spring writeup

## Spring Framework

#### [A very good explanation by Macro Behler](https://www.marcobehler.com/guides/spring-framework)

- Basically, Spring Boot is built on top of Spring Framework, pre-configuring
a bunch of stuffs from components scanning, default properties file, 
setup database connection from properties, choose which JPA implementation to use,...
- Spring Framework is basically built on the idea of Dependency Injection. Instead of
objects knowing how to create dependencies or where to find them, spring objects can just scream
for a dependency and **ApplicationContext** (Dependency Injection Container) will spoon-feed them with such dependency 
(Provided that Spring knows how to construct such dependency)
- Normally you need a **Configuration** class where you define the **Beans** (Spring managed objects - Spring can create, 
inject, make a proxy wrapper around it,...) but that step can be cut with **ConponentScan** (looks like magic)
- **ComponentScan** will scan around for **@Component**, which will tell Spring that this class wants to be a **Bean**
and can be injected by Dependency Injection Container. It now available in **ApplicationContext** and other beans can 
ask **ApplicationContext** to inject it if needed
- There's also **Bean Scopes**: 
  - Singleton: A single instance is created. Then everytime it's needed, inject that existing instance
  - Prototype: Create a new instance everytime needed
  - Others: One per HttpSession, one per Request,..
- Also, Spring can wrap your **Bean** in a **proxy** that can: Do something before -> Delegate to your bean -> Do something
after (lifecycle)
- The code doesn't really look like normal OOP code at all. But it's still OOP, just that dependencies are injected
behind the scene

## Spring MVC

#### [Another helpful guide by Macro Behler](https://www.marcobehler.com/guides/spring-mvc#_how_to_write_xmljson_with_restcontrollers)

## Spring Data JPA

#### No guide :(

