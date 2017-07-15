Feature: CURD for property
  Scenario: Create property successful
    Given property name: "液晶顯示幕 ", number: "3140307-03 -010913 ", type: "screen", model: "VIEWSONIS VA912 ", value: "10341", custodian: "Professor Y.C.", user: "James", area: "lab1321", location: "James table"
    When create property with these data
    Then it should create a property

  Scenario Outline: Create property failure because without some necessary data
    Given property name: "液晶顯示幕 ", number: "3140307-03 -010913 ", type: "screen", model: "VIEWSONIS VA912 ", value: "10341", custodian: "Professor Y.C.", user: "James", area: "lab1321", location: "James table"
    When create the property without "<some necessary data>"
    Then it should create fail
    Examples:
      | some necessary data |
      | name                |
      | type                |
      | model               |

  Scenario: Add property into container
    Given a new property container
    And property name: "液晶顯示幕 ", number: "3140307-03 -010913 ", type: "screen", model: "VIEWSONIS VA912 ", value: "10341", custodian: "Professor Y.C.", user: "James", area: "lab1321", location: "James table"
    And create property with these data
    When add property into container
    Then it should add the property successful

  Scenario: Get property from container
    Given a new property container
    And property name: "液晶顯示幕 ", number: "3140307-03 -010913 ", type: "screen", model: "VIEWSONIS VA912 ", value: "10341", custodian: "Professor Y.C.", user: "James", area: "lab1321", location: "James table"
    And create property with these data
    And add property into container
    When get property by the correct number
    Then it should return the correct property

  Scenario: Get property that does not exist from container
    Given a new property container
    And property name: "液晶顯示幕 ", number: "3140307-03 -010913 ", type: "screen", model: "VIEWSONIS VA912 ", value: "10341", custodian: "Professor Y.C.", user: "James", area: "lab1321", location: "James table"
    And create property with these data
    And add property into container
    When get property from container by a wrong number
    Then it should get property fail because of the number does not exist

  Scenario: Cannot put some property which own same data into container
    Given a new property container
    And property name: "液晶顯示幕 ", number: "3140307-03 -010913 ", type: "screen", model: "VIEWSONIS VA912 ", value: "10341", custodian: "Professor Y.C.", user: "James", area: "lab1321", location: "James table"
    And create property with these data
    And add property into container
    When create another property which has same data
    And add another property into container
    Then it should add the property fail
