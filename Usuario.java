import java.util.*;

class Usuario {
    private String nombre;
    private String codigo;
    private ArrayList<Libro> librosPrestados;
    private ArrayList<Libro> librosDevueltos;
    
    //-----CONSTRUCTOR-----
    public Usuario(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.librosPrestados = new ArrayList<>();
        this.librosDevueltos = new ArrayList<>();
    }
    
    //----CONSTRUCTOR SOBRECARGADO----
    public Usuario(String nombre) {
        this.nombre = nombre; 
        this.codigo = "SIN-ID";
    }

    //----GETTERS----
    public String getNombre() { return nombre; }
    public String getcodigo() { return codigo; }

    //----SETTERS----
    public void setNombre() { this.nombre = nombre; }
    public void setCodigo() { this.codigo = codigo; }

    //-----MÉTODOS AUXILIARES-----
    public boolean prestarLibro(Libro libro) {
        if (libro.estaDisponible()) {
            libro.setDisponible(false);
            librosPrestados.add(libro);
            return true;
        }
        return false;
    }
    public void mostrarPrestado() {
        if (librosPrestados.isEmpty()) {
            System.out.println("No tiene libros prestados.");
        } else {
            System.out.println("Libros prestados por: "+getNombre()+": ");
            for (Libro libro : librosPrestados) {
                System.out.println(libro);
            }
        }
    }
    public boolean devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            libro.setDisponible(true);
            librosPrestados.remove(libro);
            librosDevueltos.add(libro);
            return true;
        } else {
            return false;
        }
    }
    public void mostrarDevueltos() {
        if (librosDevueltos.isEmpty()) {
            System.out.println("No tiene libros devueltos");
        } else {
            System.out.println("Libros devueltos por "+getNombre()+": ");
            for (Libro libro : librosDevueltos) {
                System.out.println(libro);
            }
        }
    }
    public boolean verificarDisponibilidad(Libro libro) {
        return libro.estaDisponible() && !librosPrestados.contains(libro);
    }
    
    //----MÉTODO TO STRING----
    @Override
    public String toString() {
        return "Usuario: "+getNombre()+"\nCodigo: "+getcodigo()+"\nLibros Prestados: "+librosPrestados.size();
    }
}