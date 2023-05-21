package ui;

import dao.impl.DaoInformes;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.Informe;

import java.time.LocalDate;
import java.util.List;

public class Ex6 {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();
        DaoInformes dao = container.select(DaoInformes.class).get();
        Ex6 example = new Ex6();
        example.exercise(dao, container);
    }

    private void exercise(DaoInformes dao, SeContainer container) {
        Ex1 ex = new Ex1();
        ex.exercise(container);
        dao.addInforme(new Informe(99, "informeAdded", LocalDate.now(), List.of("informe", "nivel1"))).blockingSubscribe(resultado ->
                resultado.peek(informe -> System.out.println(informe.getNombre()))
                        .peekLeft(System.out::println));
    }
}
