public abstract class ItemBiblioteca {
    private final int codigo;
    private final String titulo;
    private boolean disponivel = true;

    protected ItemBiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public abstract int getPrazoDias();
    public abstract double getMultaPorDia();

    public double calcularMulta(int diasAtraso) {
        return diasAtraso > 0 ? diasAtraso * getMultaPorDia() : 0.0;
    }

    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }

    void marcarEmprestado() { disponivel = false; }
    void marcarDevolvido()  { disponivel = true; }

    @Override
    public String toString() {
        return String.format("[%d] %-8s %-28s prazo: %2d dias | multa: R$ %.2f/dia | %s",
                codigo, getClass().getSimpleName(), titulo, getPrazoDias(),
                getMultaPorDia(), disponivel ? "disponível" : "emprestado");
    }
}