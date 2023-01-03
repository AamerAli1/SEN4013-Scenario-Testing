package DataHelper;

import models.User;

public class UserPool {

    public static User validUser() {
        return new User("aamer", "amr123", "aa@gmail.com");
        //Builder pattern
    }

    public static User failUser() {
        return new User("Asddasdaasd", "1234qwedas", "aa@gmail.com");
    }

    public static User newUser(){
        return new User("testing1","1231sda","test1@gmail.com");
    }

}
