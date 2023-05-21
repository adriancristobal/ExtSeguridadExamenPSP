package ui;

import dao.impl.DaoInformes;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Ex4 {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();
        DaoInformes dao = container.select(DaoInformes.class).get();
        Ex4 example = new Ex4();
        example.exercise(dao, container);
    }

    private void exercise(DaoInformes dao, SeContainer container) {
        Ex1 ex = new Ex1();
        ex.exercise(container);
        dao.getInformes().blockingSubscribe(resultado ->
                resultado.peek(list ->
                                list.forEach(informe -> System.out.println(informe.getNombre())))
                        .peekLeft(System.out::println));
    }
}
