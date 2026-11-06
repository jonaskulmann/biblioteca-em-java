public abstract class Usuario {
    private final String nome;
    private int quantidadeEmprestada = 0;

    protected Usuario(String nome) { this.nome = nome; }

    public abstract int getLimiteItens();

    public boolean podeEmprestar() { return quantidadeEmprestada < getLimiteItens(); }

    public String getNome() { return nome; }
    public int getQuantidadeEmprestada() { return quantidadeEmprestada; }

    void registrarEmprestimo() { quantidadeEmprestada++; }
    void registrarDevolucao()  { quantidadeEmprestada--; }

    @Override
    public String toString() {
        return nome + " (" + getClass().getSimpleName() + ", " + quantidadeEmprestada + "/" + getLimiteItens() + ")";
    }
}