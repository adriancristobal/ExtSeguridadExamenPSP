package ui;

import dao.impl.DaoUser;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.User;

public class Ex1 {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();
        Ex1 example = new Ex1();
        example.exercise(container);
    }

    public void exercise(SeContainer container) {
        DaoUser dao = container.select(DaoUser.class).get();
//        User user = new User("uno", "uno");
        User user = new User("dos", "dos");
//        User user = new User("tres", "tres");
//        User user = new User("cuatro", "cuatro");
//        User user = new User("cinco", "cinco");
        dao.getValidatedUser(user).blockingSubscribe(resultado ->
                resultado.peek(user1 -> System.out.println("USUARIO: " + user1.getName()))
                        .peekLeft(System.out::println));
    }
}
