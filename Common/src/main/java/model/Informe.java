package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Informe {

    private int id;

    private String nombre;

    private LocalDate fecha;

    private List<String> roles;

    public Informe(String nombre, LocalDate fecha, List<String> roles) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.roles = roles;
    }
}
