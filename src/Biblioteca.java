public class Biblioteca {
    private final ItemBiblioteca[] acervo;
    private final Usuario[] portadores;
    private int totalItens = 0;

    public Biblioteca(int capacidade) {
        acervo = new ItemBiblioteca[capacidade];
        portadores = new Usuario[capacidade];
    }

    public boolean adicionarItem(ItemBiblioteca item) {
        if (totalItens == acervo.length) return false;
        acervo[totalItens++] = item;
        return true;
    }

    public boolean emprestar(Usuario usuario, ItemBiblioteca item) {
        int i = indiceDe(item);
        if (i < 0) {
            System.out.println("RECUSADO: item não pertence ao acervo.");
            return false;
        }
        if (!item.isDisponivel()) {
            System.out.println("RECUSADO: \"" + item.getTitulo() + "\" já está emprestado.");
            return false;
        }
        if (!usuario.podeEmprestar()) {
            System.out.println("RECUSADO: " + usuario.getNome() + " atingiu o limite de "
                    + usuario.getLimiteItens() + " itens.");
            return false;
        }
        item.marcarEmprestado();
        usuario.registrarEmprestimo();
        portadores[i] = usuario;
        System.out.println("OK: " + usuario.getNome() + " pegou \"" + item.getTitulo()
                + "\" (devolver em " + item.getPrazoDias() + " dias).");
        return true;
    }

    public double devolver(Usuario usuario, ItemBiblioteca item, int diasDeUso) {
        int i = indiceDe(item);
        if (i < 0 || portadores[i] != usuario) {
            System.out.println("RECUSADO: devolução inválida.");
            return 0.0;
        }
        double multa = item.calcularMulta(diasDeUso - item.getPrazoDias());
        item.marcarDevolvido();
        usuario.registrarDevolucao();
        portadores[i] = null;
        System.out.printf("OK: \"%s\" devolvido por %s. Multa: R$ %.2f%n",
                item.getTitulo(), usuario.getNome(), multa);
        return multa;
    }

    public void listarAcervo() {
        for (int i = 0; i < totalItens; i++) {
            System.out.println(acervo[i]);
        }
    }

    private int indiceDe(ItemBiblioteca item) {
        for (int i = 0; i < totalItens; i++) {
            if (acervo[i] == item) return i;
        }
        return -1;
    }
}