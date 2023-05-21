package dao;

import jakarta.ws.rs.ForbiddenException;
import model.Informe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InformeDAO {

    private static List<Informe> informes = new ArrayList<>();

    static {

        List<String> nivel1 = List.of("informe", "nivel1");
        List<String> nivel2 = List.of("informe", "nivel2");

        informes.add(new Informe(1, "uno", LocalDate.now(), nivel1));
        informes.add(new Informe(2, "dos", LocalDate.now(), nivel1));
        informes.add(new Informe(3, "tres", LocalDate.now(), nivel2));
        informes.add(new Informe(4, "cuatro", LocalDate.now(), nivel2));
        informes.add(new Informe(5, "cinco", LocalDate.now(), nivel2));
    }

    public List<Informe> getInformes(String rol) {
        List<Informe> informes1;
        if (rol.equalsIgnoreCase("nivel1")) {
            informes1 = informes.stream().filter(informe -> !informe.getRoles().contains("nivel2")).collect(Collectors.toList());
        } else {
            informes1 = informes;
        }
        return informes1;
    }

    public Informe getInforme(int id, String rol) {
        List<Informe> informes1;
        if (rol.equalsIgnoreCase("nivel1")) {
            informes1 = informes.stream().filter(informe -> !informe.getRoles().contains("nivel2")).collect(Collectors.toList());
        } else {
            informes1 = informes;
        }
        Informe encontrado = informes1.stream().filter(informe -> informe.getId() == id).findFirst().orElse(null);
        if (encontrado == null) {
            throw new ForbiddenException("No puedes leer este archivo");
        }
        return encontrado;
    }

    public Informe addInforme(Informe informe) {
        informes.add(informe);
        return informe;
    }

    public Informe getInforme(int id){
        Informe encontrado = informes.stream().filter(informe -> informe.getId() == id).findFirst().orElse(null);
        return encontrado;
    }

    public Informe updateInforme(Informe informe){
        Informe informe1 = getInforme(informe.getId());
        informe1.setNombre(informe.getNombre());
        informe1.setFecha(informe.getFecha());
        informe1.setRoles(informe.getRoles());
        return informe1;
    }

    public void deleteInforme(int id){
        informes.removeIf(informe -> informe.getId() == id);
    }

}
