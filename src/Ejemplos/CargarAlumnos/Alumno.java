package Ejemplos.CargarAlumnos;

public class Alumno {
    private String apellidos;
    private String name;
    private int edad;

    public Alumno() {
    }

    public Alumno(String apellidos, String name, int edad) {
        this.apellidos = apellidos;
        this.name = name;
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
