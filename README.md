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

===========

Day 2:
```
   Mobile m =  new Mobile(); //valid

   Is this Valid?
   Product p = new Mobile(); //upcasting
   Object o = new Mobile(); // upcasting

    Mobile m = new Product(); // invalid, Not all products are mobiles

```

How Constructors Behave in inheritance:

```
    class Product {
        Product() {
            sop("P1");
        }

        Product(int id, String name){
            sop("P2");
        }
    }


    class Mobile extends Product {
        Mobile(){
            sop("M1");
        }

        Mobile(int id, String name, String connectivity) {
            sop("M2");
        }
    }

    new Mobile(); // P1, M1

    new Mobile(63,"MotoG", "5G"); // P1, M2
```

Second run:

```
    class Product {
        Product() {
            sop("P1");
        }

        Product(int id, String name){
            sop("P2");
        }
    }


    class Mobile extends Product {
        Mobile(){
            sop("M1");
        }

        Mobile(int id, String name, String connectivity) {
            super(id, name); // way to explicitly chain to base class constructor
            sop("M2");
        }
    }

    new Mobile(); // P1, M1

    new Mobile(63,"MotoG", "5G"); // P2, M2
```

Chaining to itself:

```

    class Mobile extends Product {
        Mobile(){
            sop("M1");
        }

        Mobile(int id, String name, String connectivity) {
            this(); // way to chain  to different constructor of same class
            sop("M2");
        }
    }

     new Mobile(63,"MotoG", "5G"); //  P1, M1, M2

```
=========

How methods behave in inheritance?

```
class Product {
        double getPrice() {
            return 100;
        }

        String getName(){
            return "iPhone 17";
        }
    }


    class Mobile extends Product {
        String getConnectivity() {
            return "5G";
        }

        // override
        double getPrice() {
            return 900;
        }
    }

    Mobile m = new Mobile();
    m.getName(); // valid? YES
    m.getPrice(); // valid? 900

    Product p = new Mobile();
    p.getName(); //valid
    p.getPrice(); // valid == 900, In Java all instance methods are virtual by default, dynamic binding
    p.getConnectivity();

```

Rules of Overriding:
1) method name has to be same
2) parameters has to be same
3) return type has to be same or sub-type
```
    class Account {
        Account getAccount() {
            ...
        }
    }

    class SavingsAccount extends Account {
        // valid overriding
        SavingsAccount getAccount() {
            ...
        }
    }
```
4) visibility: same or enhances; can't weaken the visibility
default method can be made public
protected method can be made public

can we make private method public and override? : NO

=======================

```

Product p = new Mobile();
(p instanceof Mobile) ==> true
(p instanceof Product) ===> true
(p instanceof Object) ===> true
(p instanceof Tv) ==> false

(p.getClass() == Mobile.class) ==> true
(p.getClass() == Product.class) ==> false
(p.getClass() == Object.class) ==> false
(p.getClass() == Tv.class) ==> false

====

context.method(arguments);
p.getConnectivity(); // know the method name, p is implicit this

m.invoke(p); // p is explicit this

====
Web Based:
```
  private static void printDetailsOCP(Product[] products) {
        PrintWriter out = response.getWriter();
        System.out.println("OCP:");
        for(Product p : products) {
           Method[] methods =  p.getClass().getMethods();
           for(Method m : methods) {
               if(m.getName().startsWith("get")) {
                   try {
                       Object ret = m.invoke(p); // explicitly pass the context
                       out.print("<tr>");
                       out.println("<td>" + m.getName().substring(3).toUpperCase() + " </td> <td>" + ret + "</td>);
                       out.print("</tr>")
                   } catch (Exception ex) {
                       ex.printStackTrace();
                   }
               }
           }
        }
    }
```

==================

Keyword: abstract class and methods

keyword: final
```
1) constant
public static final double PI = 3.14159;

2) prevents inheritance
final class can't be inherited

3) prevents overiding

4) const pointer

final int[] data = {5,2,7,21};
data[0] = 99; // valid
data = new int[6]; // invalid

public void validateCustomer(final Customer c) {
    c.setEmail(...); // valid
    c = new Customer(); // invalid
}
```

Exception Handling:

Any abnormal condition that arises during program execution is an exception.

exceptions can be classified as "Exception" or "Error"

```
    OutOfMemoryError; solution is increase memory or increase Heap size on re-rerun
    StackOverFlowError: recursion whithou proper exit condition [ by default stack is 64kb]
```

Exception can be classfied as Checked and Unchecked Type of exceptions:
```
    Unchecked type of exceptions:
    1) NullPointerException
    2) ArrayIndexOutOfBoundsException
    3) ClassCastException
    4) ArithmeticException

    if(x != 0) {
        result = y / x;
    }

    if(emp != null) {
        em.getSalary();
    }
    CheckedException:
    1) IOException
    2) FileNotFoundException
    3) SocketException
    4) SQLException
    5) ClassNotFoundException


    Syntax:
    try {
        // statements
    } catch(ExceptionType1 ex) {

    } catch(ExceptionType2 ex) {

    }
    ...
    finally {
        // optional
    }

    Example:
    try {
        open file 1
        read file 1
        open DB connection
        write to DB
    } catch(SQLException ex) {

    } catch(IOException ex) {

    } finally {
        close DB connection
        close file connection
    }

    finally block is a compulsory execute code; gets called irreseoective of exception occurs or not

    int getCount() {
        try {
            int x = 10;
            int y = 2;
            if( x > 0) {
                return x /y;
            }
         } finally {
            return 100;
        }
    }
    
    Keywords:
    try, catch, finally, throw and throws

// Valid
     try {
        open file 1
        read file 1
        open DB connection
        write to DB
    } catch(FileNotFoundException ex) {

    } catch(IOException ex) {

    } finally {
        close DB connection
        close file connection
    }

// invalid code
 try {
        open file 1
        read file 1
        open DB connection
        write to DB
    } catch(IOException ex) {

    } catch(FileNotFoundException ex) {
            // unreachable code
    } finally {
        close DB connection
        close file connection
    }

```

Exception object:
1) What went wrong?
2) Why?
3) Where?

Exceptions are pushed up the call stack;

main () --> a() --> b() --- c();
if exception occurs in c() and not handled excetion is propagated to b(); similarly in b() if not handled it is passed on to a() ...

In case of checked exceptions we need to use "throws" to push the exception up the call stack.

=====

Realization relationship.

A Component/object will realize the behiour specified by other in order to communicate.

Program to Contract.

In Java we use interface for this.

Syntax:
```
    interface interfaceName {
        constants
        abstract methods
        can also have default methods [ from Java 5 ]
    }

    Simmilar to abstract class it can't be instantiated

```

Why program to interface?
1) DESIGN
2) iMPLEMENATION
3) INTEGRATION
4) TESTING
5) OCP

public void register(User user);
public Products[] getProducts();
public User login(String username, String password);


```
    Client:

    try {
        User user = new User(....);
        UserDao userDao = new UserDaoSqlImplementation();
        userDao.register(user);
    } catch(PersistenceException ex) {
        message
    }

    // by default all methods are abstract and public
    public interface UserDao {
        void register(User user) throws PersistenceException;
    }


    // realization
    public class UserDaoSqlImplementation implements UserDao {
        public  void register(User user) throws PersistenceException{
            try {
            // logic
            } catch(SQLException ex) {
                if(ex.getErrorCode() == 1521){
                   throw new PersistenceException("User already exists : " + user.getEmail());
                } else if(ex.getErrorCode() == 9001) {
                    ..
                }
            }
        }
    }

      public class UserDaoMongoDbImplementation implements UserDao {
        public  void register(User user) throws PersistenceException{
            try {
            // logic
            } catch(MongoException ex) {
                if(ex.getErrorCode() == 9234){
                   throw new PersistenceException("User already exists : " + user.getEmail());
                } else if(ex.getErrorCode() == 155) {
                    ..
                }
            }
        }
    }

```

Abstract classes vs interfaces

Abstract classes can have instance variables / state;  interfaces only have static constants.
Abstract classes usually has partial implmentation; example Product; interface are complete abstract
Abstract classes for Specialization relationship
interfaces are for realization relationship.

======================================

Day 3

````

class Base {
    public static void test() {
        sop("B1");
    }
}

class Sub extends Base {
     public static void test() {
        sop("S1");
    }
}

Base b = new Sub();
b.test(); // B1

```

Important methods inherited from java.lang.Object
1) String toString()
2) boolean equals(Object other);
Object equality ==> meant to compare contents of object
```
    Recatangle r1 = new Rectangle(4,5);
    Rectangle r2 = new Rectangle(4,5);
    if(r1 == r2) {
        ...
    }
    if (r1.equals(r2)) { //evaluates to false if Rectangle doesn't override
        ...
    }


    String s1 = "Hello";
    String s2 = "Hello";

    if(s1 == s2) {
        sop("1");
    }
    if(s1.equals(s2)) {
        sop("2")
    }
```
3) int hashCode()
4) Class getClass()
5) wait()
6) wait(long ms)
7) notify()
8) notifyAll()

===========================

Anonymous class: class without a name; can create from abstract class or interfaces.

```
    interface Flyable {
        void fly();
    }

    class Bird implements Flyable {
        // name
        // age
        // behaviour
        public void fly() {

        }
    }

    Bird b = new Bird(); // valid
    b.fly();

    Flyable f = new Bird();
    f.fly();

    Flyable f = new Flyable(); // invalid

    Flyable f = new Flyable() {
        public void fly() {
            sop("Jump with wings!!!");
        }
    };

    FunctionalInterface is an interface where only one method has to implmented; Lambda expression can be used instead of anonymous class for FunctionalInterface.

```

Generics like C++ templates but different

```
    class Rectangle<T extends Number> {
        T width;
        T breadth;


    }

    Rectangle<Integer> r1 = new Rectangle<>(4,5);
    Rectangle<Double> r2 = new Rectangle<>(6.7, 2.4);
    Rectangle<String> r3 = new Rectangle<>("A", "B"); / /error

    Type Wrapper classes: Byte, Short, Integer, Long, Double, Float, ...

    int x = 10;
    Integer iX = x; // boxing or wrapping
    int y = iX; // unboxing or unwrapping

```

Java Collection Framework:
Data Containers
Array is a data container and has to be the first choice for storing data.
Limitations: Size is fixed, can't grow nor shrink; adding / removing from arbitrary position need O(n) operations

JCF: 
1) interfaces
2) implementation classes
3) Utility / algorithm classes : max, min, binarySearch, sort, shuffle, reverse, ...

Collections

```
List                                            Set
1) supports duplicate                           unique
2) supports index based operation               won't
remove(3);
get(5);
3) ordered                                      Not ordered
4) can be re-ordered                            can't

```


List is an interface;
ArrayList, LinkedList are implmentations of List interface
Vector also implements List [Legacy, not advised to be used because of Locking mechansim and allowing only one thread at a time]
3rd Party implmentations are also availble for List interface like Apache Collections and VAVR collections

Different ways of using List implementation
```
ArrayList list = new ArrayList(); // avoid, program to interface

// supports heterogenous data, containers should be homogenoius -- Type Safety
List list = new ArrayList(); // avoid this, use generics

List<Product> products = new ArrayList<>(); // prefered

```