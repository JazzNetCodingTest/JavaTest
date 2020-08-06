# JavaTest  
Java Coding Test for the JazzNetworks Cloud Engineer Position for Premdass



![GitHub Workflow Status (branch)](https://img.shields.io/github/workflow/status/JazzNetCodingTest/JavaTest/Java%20CI%20with%20Maven/master) 
[![codecov](https://codecov.io/gh/JazzNetCodingTest/JavaTest/branch/master/graph/badge.svg)](https://codecov.io/gh/JazzNetCodingTest/JavaTest)


# Question 1
##### Implement (from scratch, without using Java library components) a doubly linked list (of integers) class which allows new integers to be added to either end of the list, any referenced node to be removed, and the first and last integers to be read quickly

An Implementation of Doubly Linkedist can be found at [DoublyLinkedList.java](src/main/java/com/jazz/interview/DoublyLinkedList.java) without using any libraries. Iterator has not been implemented, since it has not been asked for, and the corresponding JUnit5 tests can be also found in the tests folder. [DoublyLinkedListTest.java](src/test/java/com/jazz/interview/DoublyLinkedListTest.java)

# Question 2
##### Write a Java function which, when passed a string containing a mixture of bracket characters -  i.e. ‘{‘, ‘}’, ‘[‘, ‘]’, ‘(‘ and ‘)’, returns true if the brackets in the string are correctly balanced, and false otherwise. E.g. when called with “{[(())]()}” it should return true, but “{[(()])()}” should return false. Non-bracket characters in the string should be ignored.

A Simple Bracket validator can be found at [BracketValidator.java](src/main/java/com/jazz/interview/BracketValidator.java) using Hashmap and Stack , with Junit tests at [BracketValidatorTest.java](src/test/java/com/jazz/interview/BracketValidatorTest.java)


# Build and Code coverage
Codecoverage is obtained using Jacoco using maven during build, while build is done by Github Actions on push to master.
