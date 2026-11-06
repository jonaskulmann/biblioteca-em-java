public class Main {
    public static void main(String[] args) {
        ItemBiblioteca[] itens = {
                new Livro(1, "Dom Casmurro"),
                new Revista(2, "Superinteressante")
        };
        Usuario[] usuarios = {
                new Aluno("Ana"),
                new Professor("Prof. Paulo")
        };

        System.out.println("=== Itens ===");
        for (ItemBiblioteca item : itens) {
            System.out.println(item);
            System.out.printf("  multa por 4 dias de atraso: R$ %.2f%n", item.calcularMulta(4));
        }

        System.out.println("\n=== Usuários ===");
        for (Usuario u : usuarios) {
            System.out.println(u + " -> limite: " + u.getLimiteItens());
        }
    }
}