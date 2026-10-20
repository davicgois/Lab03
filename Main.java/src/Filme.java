public class Filme {

    private String nome;

    private String ano;

    private String local;

    public Filme(String nome, String ano, String local) {
        this.nome = nome;
        this.ano = ano;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public String getAno() {
        return ano;
    }

    public String getLocal() {
        return local;
    }

    public String detalhar() {
        return this.toString() + "\n" + this.local;
    }

    @Override
    public String toString() {
        return this.nome + ", " + this.ano;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Filme)) {
            return false;
        }

        Filme oFilme = (Filme) o;
        return (this.nome.equals(oFilme.getNome()) && this.ano.equals(oFilme.getAno()));
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode() + this.ano.hashCode();
    }

}