package dao;

import model.Raton;

import java.util.ArrayList;
import java.util.List;

public class RatonDAO {

    private static List<Raton> ratones = new ArrayList<>();

    static {
        ratones.add(new Raton(1, "uno", 1));
        ratones.add(new Raton(2, "dos", 4));
        ratones.add(new Raton(3, "tres", 13));
        ratones.add(new Raton(4, "cuatro", 12));
        ratones.add(new Raton(5, "cinco", 9));
    }

    public List<Raton> getRatones(){
        return ratones;
    }

    public Raton addRaton(Raton raton){
        ratones.add(raton);
        return raton;
    }

    public Raton getRaton(int id){
        return ratones.stream().filter(raton -> raton.getId() == id).findFirst().orElse(null);
    }

    public Raton updateRaton(Raton raton){
        Raton raton1 = getRaton(raton.getId());
        raton1.setNombre(raton.getNombre());
        raton1.setEdad(raton.getEdad());
        return raton1;
    }

    public void deleteRaton(int id){
        ratones.removeIf(raton -> raton.getId() == id);
    }
}
