package ui;

import dao.impl.DaoRatones;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Ex2 {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();
        DaoRatones dao = container.select(DaoRatones.class).get();
        Ex2 example = new Ex2();
        example.exercise(dao, container);
    }

    private void exercise(DaoRatones dao, SeContainer container) {
        Ex1 ex = new Ex1();
        ex.exercise(container);
        dao.getRatones().blockingSubscribe(resultado ->
                resultado.peek(list ->
                                list.forEach(raton -> System.out.println(raton.getNombre() + raton.getEdad())))
                        .peekLeft(System.out::println));
    }
}
