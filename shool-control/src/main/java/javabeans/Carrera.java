package javabeans;

public class Carrera {
    private int id;
    private String nombre;

    public Carrera(){}
    public Carrera(int id, String nombre){
        setId(id);
        setNombre(nombre);
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
