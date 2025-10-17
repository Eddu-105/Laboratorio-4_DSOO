class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    //-----CONSTRUCTOR-----//
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }

    //-----CONSTRUCTOR SOBRECARGADO-----//
    public Libro(String titulo, String autor) {
    this.titulo = titulo;
    this.autor = autor; 
    this.isbn= "SIN-ISBN"; 
}

    //-----GETTERS-----//
    public String getTitulo() { return titulo; }  
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public boolean estaDisponible() { return disponible; }
    //-----SETTERS-----//
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    
    //-----TO STRING-----//
    @Override
    public String toString() {
        return "Libro: "+titulo+"\nAutor: "+autor+"\nISBN: "+isbn+"\nDisponible: "+disponible;
    }
}