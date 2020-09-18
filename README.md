Coverage: 34%
# Project Title

This Maven project will create an IMS database within mysql via a java based interface. the database is seperated into 4 seperate tables: customers, items, orders and orderitems.Customers, items and orders each have their own controller, class and DAO in order to interact with their designated tables. orderitems is used in order to relate the order table with that of items table in a many to many relationship, allowing the update command within orders to have the additional functionality to add and remove items from an order.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

mySQL 5.7 or newer
Java
A java IDE such as Eclipse

```
```

## Running the tests

All tests can be run in one go with the use of Junit. These tests will run CRUD tests for each of the seperate tables (orders, items, and customers) for the DAO and controller

### Unit Tests 

Explain what these tests test, why and how to run them

```
These tests and to test the CRUD functionality of each of the items, customers and orders to a standard of 60%
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Not implimented for this project.
```

### And coding style tests

Explain what these tests test and why

```
Not implimented for this project.
```

## Deployment

Maven will build and package this project for you and will simply need to be deployed to your chosen system (ie github)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Luke Edwards** - *Following work* [LukeEdwards](https://github.com/LukeEdwards1261)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Massive thank you to Nick for all his help and harkwork in helping me with this project <3
