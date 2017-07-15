Feature: User list
  Scenario: create new user
    Given user name: "james"
    And user id: "105598047"
    When create a user
    Then it should create the new user successful

  Scenario: register new user to the list
    Given a new user list
    And user name: "Aaron"
    And user id: "105597555"
    When create a user
    Then it should register new user successful

  Scenario: cannot register users which has same id to the user list
    Given a new user list
    And user name: "Aaron"
    And user id: "105597555"
    And create a user
    And register user to the list
    When create another new user with the same id
    Then it should register new user fail

  Scenario: can register users which has same name but different id to the user list
    Given a new user list
    And user name: "Aaron"
    And user id: "105597555"
    And create a user
    And register user to the list
    When create another new user with the same name but different id
    Then it should register new user successful

  Scenario: Get user from list by user id
    Given a new user list
    And user name: "Aaron"
    And user id: "105597555"
    And create a user
    And register user to the list
    When get user by the correct id
    Then it should return the correct user

  Scenario: Get user that does not exist from list
    Given a new user list
    And user name: "Aaron"
    And user id: "105597555"
    And create a user
    And register user to the list
    When get user from list by a wrong id
    Then it should get user fail because of user id does not exist