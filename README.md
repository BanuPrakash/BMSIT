# BMSIT: Java Fundamentals

```
Banu Prakash C
Full Stack Architect, Corporate Consultant and Trainer
Co-founder & Ex-CTO: Lucida Technologies Pvt Ltd.,
Email: 
banuprakash.cr@gmail.com;
banuprakashc@yahoo.co.in;  
https://www.linkedin.com/in/banu-prakash-50416019/
https://github.com/BanuPrakash/BMSIT
==============

Softwares Required:
1) JDK

openJDK 21 https://jdk.java.net/java-se-ri/21

FOR WINDOWS: ADD PATH to jdk/bin folder; ADD JAVA_HOME to jdk folder

For MAC:
Option 1: install and add path vi ~/.zshrc export JAVA_HOME=/Users/banuprakash/Desktop/jdk-21 export PATH="/Users/banuprakash/Desktop/jdk-21/bin:"$PATH
Option 2: [better]
USE SDKMAN to manage java
curl -s "https://get.sdkman.io" | bash
sdk install java 21.0.6-tem
sdk default java 21.0.6-tem

https://mydeveloperplanet.com/2022/04/05/how-to-manage-your-jdks-with-sdkman/#:~:text=Some%20time%20ago%2C%20a%20colleague%20of%20mine,maintain%20different%20versions%20of%20JDKs%2C%20Maven%2C%20etc.

2) IDE
IntelliJ Ultimate edition https://www.jetbrains.com/idea/download/?section=mac

3) Docker Desktop
```


OOP:
Object Oriented Paradigm:

Write programs which resemble real world
State and Behaviour / actions / messages

SOLID Design Principles:
S --> Single Responsibility
O --> OCP = Closed for Change, opem for extension
L -> Liskov Substitution Principle
I --> Interface segregation
D --> Dependency Injection (Inversion Of Control)

========================================

What is Java?

Technology --> Platform for executing bytecode.
How is bytecode generated?

Programming languages       --> Compiler. --->. bytecode
Kotlin                          kotlin compiler     --> bytecode
Java                            javac               ---> bytecode
Groovy                          groovy compiler     --> bytecode

============================================================

Data types in Java:
1) Primitive types (Stack)
    Signed Data types:
    byte        -- 1 byte (-128 to 127 range)
    short       -- 2 bytes 
    int --          4 bytes (-2^32 to 2^32-1)
    long --         8 bytes

    float   -- 4 bytes
    double  -- 8 bytes

    char -- 2 bytes (unsigned -- 65535 characters)

2) Reference types (Heap)

==============================================

Logically grouping of classes / object
1) Entity / Domain / Model
    Business data;
    Uber : Customer, Driver, Vehicle, Trip
    Amazon: Customer, Product, Seller, Category, Order

    Customer: id, firstName, lastName, email, Phone...

    Generally these classes won't have business logic;
    only accessors and mutators
    setPassword(pwd)
    getPassword()
2) DAO: Data Access Objects / DAL
    these classes contain CRUD operations
    CREATE READ UPDATE and DELETE statements
    these are one per database Table

3) Service Layer:
    Facade over DAO and business logic
    Generally these are one per actor

4) UI classes

5) Exception classes: To represent any abnormal condition in application
6) Utility classes : Helpers; sorting; DateConversion; Number formating;....

====================================
Organize : packages
folders for logically grouped classes.

========

Compile time enviroment: Development Kit like JDK / KDK or GroovyDK

javac Account.java ===> Account.class [Bytecode]
javac AccountClient.java ==> AccountClient.class [ByteCode]

ByteCode: Portable, independent of Platform or Acrchitecutre

Runtime Environment:
java edu.bmsit.prj.client.AccountClient

ClassLoader
    findLoadedClass()
    loadClass()
    findSystemClass()
    defineClass() --> OUTPUT is not portable

set CLASSSPATH=c:\temp;c:\prj\data;c:\customermodule;.;


Stack:
a) variables are word aligned; --> 4 bytes
byte and short are upgraded to int
long and double --> 2 words

b) index based storage

byte b = 100; // on stack it's 4 bytes

byte c = b + 10;  // error, int can't be assigned to byte

int c = b + 10 ; // valid

byte c = (byte) (b + 10); //valid

In OOP:
context.behaviour(arguments); ==> behaviour(context, arguments)

fan1.on(); 
bulb.on();



```
rahulAcc.deposit(2500); ==> deposit(rahulAcc, 2500);
public void deposit(double amt) {
        this.balance += amt;
}

translated to:

public void deposit(Account this, double amt) {
        this.balance += amt;
}

```

Initialization of Object: Constructor
Consutructor:
1) like a special method having Same name as that of class
2) No explicit return type; implicitly it returns created object
3) Called once when object is created; explicitly can't call it,
4) Compiler creates default constructor if no constructors are written
5) If we write custom constructor, it's our responsibility to write default also

=====

I need to track how many instances of Account is created.

In Java we create objects, we won't release memory [ like free / delete]

In Java Execution engine we have Garbage Collector [ low priorty System Thread] whose job is to clear un used objects.

Various GC are there like : G1GC, MSC, Epsilon GC, ZGC

=========================================================

Relationship between objects.
1) Generalization and Specialization [ inheritance] IS A
2) Realization
3) Association
4) Uses A








