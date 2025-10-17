import java.util.*;

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
}