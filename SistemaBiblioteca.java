import java.util.*;
class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }
    public String getTitulo() {
        return titulo;
    }
    public String setTitulo(String titulo) {
        this.titulo = titulo;
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String setAutor(String autor) {
        this.autor = autor;
        return autor;
    }
    public String getIsbn() {
        return isbn;
    }
    public String setIsbn(String isbn) {
        this.isbn = isbn;
        return isbn;
    }
    public boolean estaDisponible() {
        return disponible;
    }
    public void setestaDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    @Override
    public String toString() {
        return "Libro: "+titulo+"\nAutor: "+autor+"\nISBN: "+isbn+"\nDisponible: "+disponible;
    }
}
class Usuario {
    private String nombre;
    private String codigo;
    private ArrayList<Libro> librosPrestados;
    private ArrayList<Libro> librosDevueltos;
    public Usuario(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.librosPrestados = new ArrayList<>();
        this.librosDevueltos = new ArrayList<>();
    }
    public boolean prestarLibro(Libro libro) {
        if (libro.estaDisponible()) {
            libro.setestaDisponible(false);
            librosPrestados.add(libro);
            return true;
        }
        return false;
    }
    public void mostrarPrestado() {
        if (librosPrestados.isEmpty()) {
            System.out.println("No tiene libros prestados");
        } else {
            System.out.println("Libros prestados por "+nombre+": ");
            for (Libro libro : librosPrestados) {
                System.out.println(libro);
            }
        }
    }
    public boolean devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            libro.setestaDisponible(true);
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
            System.out.println("Libros devueltos por "+nombre+": ");
            for (Libro libro : librosDevueltos) {
                System.out.println(libro);
            }
        }
    }
    public boolean verificarDisponibilidad(Libro libro) {
        return libro.estaDisponible() && !librosPrestados.contains(libro);
    }
    @Override
    public String toString() {
        return "Usuario: "+nombre+"\nCodigo: "+codigo+"\nLibros Prestados: "+librosPrestados.size();
    }
}
public class SistemaBiblioteca {
    public static void listadeBiblioteca(ArrayList<Libro> libros) {
        System.out.println("Libros en la biblioteca:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
    public static void listadeUsuarios(ArrayList<Usuario> usuarios) {
        System.out.println("Usuarios registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
    public static void prestamos(ArrayList<Usuario> usuarios, ArrayList<Libro> libros) {
        System.out.println("Mostrar Prestado");
        usuarios.get(0).prestarLibro(libros.get(0));
        usuarios.get(0).mostrarPrestado();
    }
    public static void devoluciones(ArrayList<Usuario> usuarios, ArrayList<Libro> libros) {
        System.out.println("Mostrar Devueltos");
        usuarios.get(0).devolverLibro(libros.get(0));
        usuarios.get(0).mostrarDevueltos();
    }
    public static void estado(ArrayList<Libro> libros) {
        System.out.println("Estado final de libros:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        libros.add(new Libro("1984", "George Orwell", "123456789"));
        libros.add(new Libro("To Kill a Mockingbird", "Harper Lee", "987654321"));
        usuarios.add(new Usuario("Alice", "U001"));
        usuarios.add(new Usuario("Bob", "U002"));
        listadeBiblioteca(libros);
        listadeUsuarios(usuarios);
        prestamos(usuarios, libros);
        System.out.println("--Estado despues del prestamo--");
        estado(libros);
        devoluciones(usuarios, libros);
        System.out.println("--Estado depues de la devolucion--");
        estado(libros);
    }
}