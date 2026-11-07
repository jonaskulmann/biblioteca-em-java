public class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca(10);

        Livro l1 = new Livro(1, "Dom Casmurro");
        Livro l2 = new Livro(2, "Memórias Póstumas");
        Revista r1 = new Revista(3, "Superinteressante");
        Revista r2 = new Revista(4, "Veja");
        Dvd d1 = new Dvd(5, "Cidade de Deus");
        for (ItemBiblioteca it : new ItemBiblioteca[]{l1, l2, r1, r2, d1}) bib.adicionarItem(it);

        Aluno gustavo = new Aluno("Gustavo");
        Professor jacques = new Professor("Professor Jacques");

        System.out.println("=== Acervo inicial ===");
        bib.listarAcervo();

        System.out.println("\n=== Empréstimos ===");
        bib.emprestar(gustavo, l1);
        bib.emprestar(gustavo, l2);
        bib.emprestar(gustavo, r1);
        bib.emprestar(gustavo, r2);
        bib.emprestar(jacques, d1);

        System.out.println("\n=== Devoluções ===");
        bib.devolver(gustavo, l1, 20);
        bib.devolver(gustavo, r1, 5);
        bib.devolver(jacques, d1, 5);

        System.out.println("\n=== Acervo final ===");
        bib.listarAcervo();
    }
}