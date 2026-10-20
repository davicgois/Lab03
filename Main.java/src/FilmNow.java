package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 *
 * @author eliane
 *
 */
public class FilmNow {

    private static final int TAMANHO = 100;

    private Film[] filmes;  //uma representacao simploria da lista de filmes

    private Film[] hotList;

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Film[TAMANHO];
        this.hotList = new Film[10];
    }

    /**
     * Acessa a lista de filmes mantida.
     * @return O array de filmes.
     */
    public String[] getFilmes() {
        String[] stringsFilme = new String[filmes.length];
        for (int i = 0; i < filmes.length; i++) {
            stringsFilme[i] = filmes[i].getNome();

        }
        return stringsFilme;
    }

    /**
     * Acessa os dados de um filme específico.
     * @param posicao Posição do filme no sistema.
     * @return Dados do filme. Null se não há filme na posição.
     */
    public String getFilme(int posicao) {
        String[] stringsFilmes = new String[filmes.length];
        for (int i = 0; i < filmes.length; i++) {
            stringsFilmes[i] = filmes[i].getNome();

        }
        return stringsFilmes[posicao];
    }

    /**
     * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
     * @param posicao Posição do filme.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assitido.
     */
    public String cadastraFilme(int posicao, String nome, String ano, String local) {
        if (!posicaoValida(posicao, TAMANHO)) {
            return "Posicao invalida.";
        }

        if (nome.isEmpty() || local.isEmpty()) {
            return "Filme invalido.";
        }

        Film novo = new Film(nome, ano, local);
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

            Film filme = this.filmes[posicao - 1];
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

    private boolean existeFilme(Film filme) {
        for (Film i : this.filmes) {
            if (i != null && i.equals(filme)) {
                return true;
            }
        }
        return false;
    }

    private boolean estaNaHotList(Film filme) {
        for (Film i : this.hotList) {
            if (i != null && i.equals(filme)) {
                return true;
            }
        }
        return false;
    }

    private boolean filmeJaAdicionado(Film filme) {
        for (Film f : this.filmes) {
            if (f != null && f.equals(filme)) {
                return true;
            }
        }
        return existeFilme(filme) || estaNaHotList(filme);
    }

    public String[] getHot() {
        String[] stringsHot = new String[hotList.length];
        for (int i = 0; i < hotList.length; i++) {
            stringsHot[i] = hotList[i].getNome();

        }
        return stringsHot;
    }
}
