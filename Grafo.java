import java.util.ArrayList;

public class Grafo<String> {
    private ArrayList<Vertice<String>> vertices;
    private ArrayList<Aresta<String>> arestas;

    public Grafo(){
        this.vertices = new ArrayList<Vertice<String>>();
        this.arestas = new ArrayList<Aresta<String>>();
    }

    public void adicionarVertice(String dado){
        Vertice<String> novoVertice = new Vertice<String>(dado);
        this.vertices.add(novoVertice);
        System.out.println("vertice: '" +novoVertice.getDado() +"' adicionado.");
    }

    public void adicionarAresta(double peso, String dadoincio, String dadofim){
        Vertice<String> inicio = this.buscaVertice(dadoincio);
        Vertice<String> fim = this.buscaVertice(dadofim);

        if (inicio == null || fim == null) System.out.println("Um dos vértices não foi encontrado");
        else {
            Aresta<String> aresta = new Aresta<String>(peso, inicio, fim);
            inicio.adicionarArestaSaida(aresta);
            fim.adicionarArestaEntrada(aresta);
            this.arestas.add(aresta);
            System.out.println("Aresta adicionada entre " + inicio.getDado() + " e " + fim.getDado());
        }
    }

    public Vertice<String> buscaVertice(String dado){
        Vertice<String> vertice = null;
        for (int i=0; i<this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void buscaEmProfundidade(String pontoPartida, String pontoChegada) {
        Vertice<String> partida = buscaVertice(pontoPartida);
        Vertice<String> chegada = buscaVertice(pontoChegada);
    
        if (partida == null || chegada == null) {
            System.out.println("Ponto de partida ou chegada não encontrado.");
            return;
        }
    
        ArrayList<Vertice<String>> caminhoAtual = new ArrayList<>();
        ArrayList<ArrayList<Vertice<String>>> caminhos = new ArrayList<>();
    
        buscaEmProfundidadeRecursivo(partida, chegada, caminhoAtual, caminhos);
    
        if (caminhos.isEmpty()) {
            System.out.println("Não há caminho entre " + pontoPartida + " e " + pontoChegada + ".");
        } else {
            System.out.println("Caminhos encontrados:");
    
            for (ArrayList<Vertice<String>> caminho : caminhos) {
                double distancia = calcularDistancia(caminho);
                System.out.println("Caminho: " + caminho);
                System.out.println("Distância total: " + distancia + " metros");
                System.out.println();
            }
        }
    }
    
    private void buscaEmProfundidadeRecursivo(Vertice<String> atual, Vertice<String> chegada,
            ArrayList<Vertice<String>> caminhoAtual, ArrayList<ArrayList<Vertice<String>>> caminhos) {
        caminhoAtual.add(atual);
    
        if (atual.equals(chegada)) {
            ArrayList<Vertice<String>> caminhoEncontrado = new ArrayList<>(caminhoAtual);
            caminhos.add(caminhoEncontrado);
        } else {
            for (Aresta<String> aresta : atual.getArestasSaida()) {
                Vertice<String> proximo = aresta.getFim();
                if (!caminhoAtual.contains(proximo)) {
                    buscaEmProfundidadeRecursivo(proximo, chegada, caminhoAtual, caminhos);
                }
            }
        }
    
        caminhoAtual.remove(atual);
    }
    
    private double calcularDistancia(ArrayList<Vertice<String>> caminho) {
        double distancia = 0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            Vertice<String> inicio = caminho.get(i);
            Vertice<String> fim = caminho.get(i + 1);
    
            for (Aresta<String> aresta : inicio.getArestasSaida()) {
                if (aresta.getFim().equals(fim)) {
                    distancia += aresta.getPeso();
                    break;
                }
            }
        }
        return distancia;
    }
    
}
