package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import model.UserList;
import schema.User;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by JianFa on 2017/7/15.
 */
public class UserListStepdefs implements En {

    private String userName;
    private String userId;
    private User user;
    private UserList userList ;
    private Exception exception;

    public UserListStepdefs() {

        Given("^user name: \"([^\"]*)\"$", (String name) -> {
            userName = name;
        });

        Given("^a new user list$", () -> {
            userList = new UserList();
        });

        And("^user id: \"([^\"]*)\"$", (String id) -> {
            userId = id;
        });

        When("^create a user$", () -> {
            user = new User(userName, userId);
        });

        Then("^it should create the new user successful$", () -> {
            assertThat(user.getName()).isEqualTo(userName);
            assertThat(user.getId()).isEqualTo(userId);
        });

        Then("^it should register new user successful$", () -> {
            try {
                userList.register(user);
            } catch (IOException e) {
                e.printStackTrace();
                fail();
            }
        });

        And("^register user to the list$", () -> {
            try {
                userList.register(user);
            } catch (IOException ignored) {
            }
        });

        When("^create another new user with the same id$", () -> {
            user = new User(userName, userId);
        });

        Then("^it should register new user fail$", () -> {
            try {
                userList.register(user);
            } catch (IOException e) {
                assertThat(e.getMessage()).isEqualTo("There is already a user that has same id.");
            }
        });

        When("^create another new user with the same name but different id$", () -> {
            user = new User(userName, "105598000");
        });

        When("^get user by the correct id$", () -> {
            user = userList.getUserById(userId);
        });

        Then("^it should return the correct user$", () -> {
            assertThat(user.getName()).isEqualTo(userName);
            assertThat(user.getId()).isEqualTo(userId);
        });

        When("^get user from list by a wrong id$", () -> {
            try {
                user = userList.getUserById("wrongId");
                fail("it should throw NoSuchElementException because of wrong id.");
            } catch (NoSuchElementException e) {
                exception = e;
            }
        });

        Then("^it should get user fail because of user id does not exist$", () -> {
            assertThat(exception.getMessage()).isEqualTo("User id is incorrect.");
        });


    }
}

