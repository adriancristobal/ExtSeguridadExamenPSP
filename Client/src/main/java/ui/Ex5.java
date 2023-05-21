package ui;

import dao.impl.DaoInformes;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Ex5 {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();
        DaoInformes dao = container.select(DaoInformes.class).get();
        Ex5 example = new Ex5();
        example.exercise(dao, container);
    }

    private void exercise(DaoInformes dao, SeContainer container) {
        Ex1 ex = new Ex1();
        ex.exercise(container);
        dao.getInforme(5).blockingSubscribe(resultado ->
                resultado.peek(informe -> System.out.println(informe.getNombre()))
                        .peekLeft(System.out::println));
    }
}
