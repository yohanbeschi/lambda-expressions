#lambda-expressions 
Exploration of the [JSR-335](http://jcp.org/aboutJava/communityprocess/edr/jsr335/index2.html "See JSR-335").

This project is the illustration of the following articles (in french):

+ [http://blog.soat.fr/2012/11/java-8-jsr-335-13-expressions-lambda/](http://blog.soat.fr/2012/11/java-8-jsr-335-13-expressions-lambda/)
+ [http://blog.soat.fr/2012/11/java-8-jsr-335-23-references-et-defenders/](http://blog.soat.fr/2012/11/java-8-jsr-335-23-references-et-defenders/)
+ [http://blog.soat.fr/2012/12/java-8-jsr-335-33-impacts-sur-lapi-collection-et-utilisation-de-la-jdk-8-early-access/](http://blog.soat.fr/2012/12/java-8-jsr-335-33-impacts-sur-lapi-collection-et-utilisation-de-la-jdk-8-early-access/)

Note: The master branch contains code that compiles with the last current version of the [JDK 8 with Lambda Support](http://jdk8.java.net/lambda).  
Other branches compile with the version specified in the name of the branch. For example: "jdk8-lambda-b64"
***
## Documentation
[JSR-335](http://jcp.org/aboutJava/communityprocess/edr/jsr335/index2.html "See JSR-335")  
[Project Lambda](http://openjdk.java.net/projects/lambda/)  
[State of the Lambda v4](http://cr.openjdk.java.net/~briangoetz/lambda/lambda-state-4.html)  
[Defender methods v4](http://cr.openjdk.java.net/~briangoetz/lambda/Defender%20Methods%20v4.pdf)  
[State of the Lambda: Libraries Edition](http://cr.openjdk.java.net/~briangoetz/lambda/sotc3.html)  
[Frequently Asked Questions](http://www.lambdafaq.org/)  
***


##Packages description (in order of the articles)
Each package/subpackage as its own test class.  
Comments are most likely to be present in test classes, where new things are introduced.

### Part 1
- org.isk.gettingstarted: Getting started with functional interfaces and lambda expressions
- org.isk.generics: Using generics with lambda expressions
- org.isk.currying: Lambda expressions and currying
- org.isk.pipelining: In-lining lambda expressions definitions
- org.isk.scope: Scope of variables used in lambda expressions
- org.isk.mutables: Using mutables objetcs in lambda expressions

### Part 2
- org.isk.references: Method and Constructor references
- org.isk.references.part1: Method reference of a static method and constructor reference
- org.isk.references.part2: Method reference of an instance method of a particular object
- org.isk.references.part3: Method reference of an instance method of an arbitrary object of a particular type
- org.isk.defenders: Defenders method
- org.isk.defenders.intro: Presentation of defenders method
- org.isk.defenders.inheritance: Inheritance of defenders method
- org.isk.defenders.override: Overriding defenders method

### Part 3
- org.isk.collections: Modification of the Collection API
- org.isk.collections.sorting: New ways of sorting
- org.isk.collections.stream: Using filter(), map(), reduce(), etc.