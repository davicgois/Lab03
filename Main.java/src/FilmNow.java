public class FilmNow {

    private Filme[] filmes;

    private Filme[] hotList;


    public FilmNow() {
        this.filmes = new Filme[100];
        this.hotList = new Filme[10];
    }

    public String adicionaFilme(int posicao, String nome, String ano, String local) {
        if (!posicaoValida(posicao, 100)) {
            return "Posicao invalida.";
        }

        if (nome.isEmpty() || local.isEmpty()) {
            return "Filme invalido.";
        }

        Filme novo = new Filme(nome, ano, local);
        if (filmeJaAdicionado(novo)) {
            return "Filme ja adicionado.";
        }

        this.filmes[posicao - 1] = novo;
        return "Filme adicionado.";

    }

    public String mostraTodos() {
        String saida = "";
        for (int i = 0; i < filmes.length; i++) {

            if (filmes[i] != null) {
                saida += (i + 1) + " - " + filmes[i] + "\n";
            }

        }
        return saida;

    }

    public String detalhaFilme(int posicao) {
        if (!posicaoValida(posicao, 100) || this.filmes[posicao - 1] == null) {
            return "POSIÇÃO INVÁLIDA!";
        }

        Filme filme = this.filmes[posicao - 1];
        String detalhes = filme.detalhar();

        if (estaNaHotList(filme)) {
            return "🔥 " + detalhes;
        }
        return detalhes;
    }

    public void atribuiHot(int posicaoFilme, int posicaoHot) {
        hotList[posicaoHot - 1] = filmes[posicaoFilme -1];

    }

    public void removeHot(int posicaoHot) {
        hotList[posicaoHot - 1] = null;

    }

    public String exibeHotList() {
        String saida = "";
        for (int i = 0; i < hotList.length; i++) {

            if (hotList[i] != null) {
                saida += (i + 1) + " - " + hotList[i] + "\n";
            }

        }
        return saida;

    }


    private boolean posicaoValida(int posicao, int limite) {
        return posicao >= 1 && posicao <= limite;
    }

    private boolean existeFilme(Filme filme) {
        for (Filme i : this.filmes) {
            if (i != null && i.equals(filme)) {
                return true;
            }
        }
        return false;
    }

    private boolean estaNaHotList(Filme filme) {
        for (Filme i : this.hotList) {
            if (i != null && i.equals(filme)) {
                return true;
            }
        }
        return false;
    }

    private boolean filmeJaAdicionado(Filme filme) {
        for (Filme f : this.filmes) {
            if (f != null && f.equals(filme)) {
                return true;
            }
        }
        return existeFilme(filme) || estaNaHotList(filme);
    }
}


