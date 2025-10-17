import java.util.*;

public class Sistema{
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        SistemaBiblioteca sistBiblio = new SistemaBiblioteca();
        //---DATOS YA INICIALIZADOS---
        libros.add(new Libro("1984", "George Orwell", "123456789"));
        libros.add(new Libro("To Kill a Mockingbird", "Harper Lee", "987654321"));
        usuarios.add(new Usuario("Alice", "U001"));
        usuarios.add(new Usuario("Bob", "U002"));
        //MOSTRAR DATOS//
        sistBiblio.listadeBiblioteca(libros);
        sistBiblio.listadeUsuarios(usuarios);
        
        sistBiblio.prestamos(usuarios, libros);
        System.out.println("--Estado después del préstamo--");
        sistBiblio.estado(libros);

        sistBiblio.devoluciones(usuarios, libros);
        System.out.println("--Estado después de la devolución--");
        sistBiblio.estado(libros);
    }
}