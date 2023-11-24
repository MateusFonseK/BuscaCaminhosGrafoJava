import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = criarGrafo();

        Scanner scanner = new Scanner(System.in);

        
        System.out.println("\n");
        boolean continuar = true;

        while (continuar) {
            System.out.print("Digite o ponto de partida (A até X) ou 'sair' para encerrar: ");
            String pontoPartida = scanner.next().toUpperCase();

            if (pontoPartida.equalsIgnoreCase("sair")) {
                continuar = false;
            } else {
                System.out.print("Digite o ponto de chegada (A até X): ");
                String pontoChegada = scanner.next().toUpperCase();

                System.out.println("Trajeto:");
                grafo.buscaEmProfundidade(pontoPartida, pontoChegada);
            }
        }

        scanner.close();
    }

    private static Grafo<String> criarGrafo() {
        Grafo<String> grafo = new Grafo<String>();

        // Adiciona vértices de A a X
        for (char c = 'A'; c <= 'X'; c++) {
            grafo.adicionarVertice(String.valueOf(c));
        }

        // Adiciona as ligações fornecidas
        grafo.adicionarAresta(300, "A", "B");
        grafo.adicionarAresta(300, "B", "A");
        grafo.adicionarAresta(47, "B", "C");
        grafo.adicionarAresta(47, "C", "B");
        grafo.adicionarAresta(47, "C", "D");
        grafo.adicionarAresta(47, "D", "C");
        grafo.adicionarAresta(62, "C", "D");
        grafo.adicionarAresta(62, "D", "C");
        grafo.adicionarAresta(141, "C", "H");
        grafo.adicionarAresta(141, "H", "C");
        grafo.adicionarAresta(8, "D", "E");
        grafo.adicionarAresta(8, "E", "D");
        grafo.adicionarAresta(138, "H", "I");
        grafo.adicionarAresta(138, "I", "H");
        grafo.adicionarAresta(13, "E", "F");
        grafo.adicionarAresta(13, "F", "E");
        grafo.adicionarAresta(230, "E", "G");
        grafo.adicionarAresta(230, "G", "E");
        grafo.adicionarAresta(153, "I", "J");
        grafo.adicionarAresta(153, "J", "I");
        grafo.adicionarAresta(512, "J", "K");
        grafo.adicionarAresta(512, "K", "J");
        grafo.adicionarAresta(135, "K", "L");
        grafo.adicionarAresta(135, "L", "K");
        grafo.adicionarAresta(15, "L", "M");
        grafo.adicionarAresta(15, "M", "L");
        grafo.adicionarAresta(187, "L", "N");
        grafo.adicionarAresta(187, "N", "L");
        grafo.adicionarAresta(108, "N", "O");
        grafo.adicionarAresta(108, "O", "N");
        grafo.adicionarAresta(82, "O", "P");
        grafo.adicionarAresta(82, "P", "O");
        grafo.adicionarAresta(215, "P", "Q");
        grafo.adicionarAresta(215, "Q", "P");
        grafo.adicionarAresta(97, "Q", "R");
        grafo.adicionarAresta(97, "R", "Q");
        grafo.adicionarAresta(243, "R", "T");
        grafo.adicionarAresta(243, "T", "R");
        grafo.adicionarAresta(33, "R", "S");
        grafo.adicionarAresta(33, "S", "R");
        grafo.adicionarAresta(207, "S", "T");
        grafo.adicionarAresta(207, "T", "S");
        grafo.adicionarAresta(210, "V", "U");
        grafo.adicionarAresta(210, "U", "V");
        grafo.adicionarAresta(22, "T", "U");
        grafo.adicionarAresta(22, "U", "T");
        grafo.adicionarAresta(107, "U", "X");
        grafo.adicionarAresta(107, "X", "U");
        grafo.adicionarAresta(317, "X", "A");
        grafo.adicionarAresta(317, "A", "X");
        grafo.adicionarAresta(370, "V", "A");
        grafo.adicionarAresta(370, "A", "V");        

        return grafo;
    }
}
