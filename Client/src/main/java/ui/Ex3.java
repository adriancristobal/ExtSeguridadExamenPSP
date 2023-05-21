package ui;

import dao.impl.DaoRatones;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.Raton;

public class Ex3 {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();
        DaoRatones dao = container.select(DaoRatones.class).get();
        Ex3 example = new Ex3();
        example.exercise(dao, container);
    }

    private void exercise(DaoRatones dao, SeContainer container) {
        Ex1 ex = new Ex1();
        ex.exercise(container);
        dao.addRaton(new Raton(20, "ratonAdded", 2)).blockingSubscribe(resultado ->
                resultado.peek(raton -> System.out.println(raton.getNombre() + raton.getEdad()))
                        .peekLeft(System.out::println));
    }
}
