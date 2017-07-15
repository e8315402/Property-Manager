package steps;

import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import model.PropertyBuilder;
import model.PropertyContainer;
import schema.Property;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by JianFa on 2017/7/11.
 */
public class PropertyStepdefs implements En {

    private Exception exception;
    private PropertyBuilder propertyBuilder;
    private PropertyContainer propertyContainer;
    private Property property;

    private String name;
    private String number;
    private String type;
    private String model;
    private int value;
    private String custodian;
    private String user;
    private String area;
    private String location;

    private String dataClass;

    public PropertyStepdefs() {

        Given("^property name: \"([^\"]*)\", number: \"([^\"]*)\", type: \"([^\"]*)\", model: \"([^\"]*)\", value: \"([^\"]*)\", custodian: \"([^\"]*)\", user: \"([^\"]*)\", area: \"([^\"]*)\", location: \"([^\"]*)\"$", (String name, String number, String type, String model, String value, String custodian, String user, String area, String location) -> {
            this.name = name;
            this.number = number;
            this.type = type;
            this.model = model;
            this.value = Integer.valueOf(value);
            this.custodian = custodian;
            this.user = user;
            this.area = area;
            this.location = location;

        });

        Given("^a new property container$", () -> {
            propertyContainer = new PropertyContainer();
        });

        When("^create property with these data$", () -> {
            property =  PropertyBuilder.newInstance()
                    .setName(this.name)
                    .setNumber(this.number)
                    .setType(this.type)
                    .setModel(this.model)
                    .setValue(this.value)
                    .setCustodian(this.custodian)
                    .setUser(this.user)
                    .setArea(this.area)
                    .setLocation(this.location)
                    .build();
        });

        Then("^it should create a property$", () -> {
            assertThat(property.getName()).isEqualTo("液晶顯示幕 ");
            assertThat(property.getNumber()).isEqualTo("3140307-03 -010913 ");
            assertThat(property.getType()).isEqualTo("screen");
            assertThat(property.getModel()).isEqualTo("VIEWSONIS VA912 ");
            assertThat(property.getValue()).isEqualTo(10341);
            assertThat(property.getCustodian()).isEqualTo("Professor Y.C.");
            assertThat(property.getUser()).isEqualTo("James");
            assertThat(property.getArea()).isEqualTo("lab1321");
            assertThat(property.getLocation()).isEqualTo("James table");
        });

        Then("^it should create fail$", () -> {
            try {
                property = propertyBuilder.build();
                fail("it should create fail and throw an IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                if(dataClass.equals("name")) {
                    assertThat(e.getMessage()).isEqualTo("Property name should not be empty.");
                }
                if(dataClass.equals("type")) {
                    assertThat(e.getMessage()).isEqualTo("Property type should not be empty.");
                }
                if(dataClass.equals("model")) {
                    assertThat(e.getMessage()).isEqualTo("Property model should not be empty.");
                }
            }
        });

        When("^create the property without \"([^\"]*)\"$", (String data) -> {
            this.dataClass = data;
            propertyBuilder = PropertyBuilder.newInstance()
                    .setName("液晶顯示幕 ")
                    .setNumber("3140307-03 -010913 ")
                    .setType("screen")
                    .setModel("VIEWSONIS VA912 ")
                    .setValue(10341)
                    .setCustodian("Professor Y.C.")
                    .setUser("James")
                    .setArea("lab1321")
                    .setLocation("James table");
            if(data.equals("name")) propertyBuilder.setName(null);
            if(data.equals("type")) propertyBuilder.setType(null);
            if(data.equals("model")) propertyBuilder.setModel(null);
        });

//        Given("^container already have a property$", () -> {
//
//            propertyContainer = new PropertyContainer();
//            Property pTemp = PropertyBuilder.newInstance()
//                            .setName("液晶顯示幕 ")
//                            .setNumber("3140307-03 -010913 ")
//                            .setType("screen")
//                            .setModel("VIEWSONIS VA912 ")
//                            .setValue(10341)
//                            .setCustodian("Professor Y.C.")
//                            .setUser("James")
//                            .setArea("lab1321")
//                            .setLocation("James table")
//                            .build();
//
//            try {
//                propertyContainer.add(pTemp);
//            } catch (IOException ignored) {
//            }
//
//        });

        When("^create another property which has same data$", () -> {
            property = PropertyBuilder.newInstance()
                    .setName("液晶顯示幕 ")
                    .setNumber("3140307-03 -010913 ")
                    .setType("screen")
                    .setModel("VIEWSONIS VA912 ")
                    .setValue(10341)
                    .setCustodian("Professor Y.C.")
                    .setUser("James")
                    .setArea("lab1321")
                    .setLocation("James table")
                    .build();
        });

        Then("^it should add the property successful$", () -> {

            Property pTemp = propertyContainer.getPropertyByNumber(this.number);
            assertThat(pTemp.getName()).isEqualTo(this.name);
            assertThat(pTemp.getNumber()).isEqualTo(this.number);
            assertThat(pTemp.getType()).isEqualTo(this.type);
            assertThat(pTemp.getModel()).isEqualTo(this.model);
            assertThat(pTemp.getValue()).isEqualTo(this.value);
            assertThat(pTemp.getCustodian()).isEqualTo(this.custodian);
            assertThat(pTemp.getUser()).isEqualTo(this.user);
            assertThat(pTemp.getArea()).isEqualTo(this.area);
            assertThat(pTemp.getLocation()).isEqualTo(this.location);

        });

        Then("^it should add the property fail$", () -> {
//            try {
//                propertyContainer.add(property);
//                fail("it should throw IOException because of adding same property.");
//            } catch (IOException e) {
            assertThat(exception.getMessage()).isEqualTo("Already has the same property.");
//            }
        });

        When("^get property by the correct number$", () -> {
            property = propertyContainer.getPropertyByNumber("3140307-03 -010913 ");
        });

        Then("^it should return the correct property$", () -> {
            assertThat(property.getName()).isEqualTo("液晶顯示幕 ");
        });

        Then("^it should get property fail because of the number does not exist$", () -> {

            assertThat(exception.getMessage()).isEqualTo("Property number is incorrect.");

        });

        When("^add property into container$", () -> {
            try {
                propertyContainer.add(property);
            } catch (IOException e) {
                e.printStackTrace();
                fail("it should not throw any exception.");
            }
        });

        When("^get property from container by a wrong number$", () -> {
            try {
                propertyContainer.getPropertyByNumber("wrongNumber");
                fail("it should throw NoSuchElementException because of wrong number.");
            } catch (NoSuchElementException e) {
                exception = e;
            }
        });

        And("^add another property into container$", () -> {
            try {
                propertyContainer.add(property);
                fail("it should throw IOException because of adding same property.");
            } catch (IOException e) {
                exception = e;
            }
        });


    }
}

