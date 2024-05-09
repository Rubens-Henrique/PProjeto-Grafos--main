import java.util.ArrayList;
import java.util.List;

public class ListaAdjacencia {

    private static List<List<Integer>> listaAdj; // Lista de adjacência para grafos não direcionados
    // Para grafos direcionados
    private static List<List<Integer>> predecessores;
    private static List<List<Integer>> sucessores;

    private static int numVertices;
    private static boolean ehDirecionado;

    public ListaAdjacencia(int numVertices, int tipo) {
        this.numVertices = numVertices;
        // Define se o grafo é direcionado ou não baseado no tipo fornecido
        ehDirecionado = (tipo == 1);
        predecessores = new ArrayList<>();
        sucessores = new ArrayList<>();
        // Inicializa listas de adjacência se o grafo for não direcionado
        if (!ehDirecionado) {
            listaAdj = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                listaAdj.add(new ArrayList<>());
            }
        }
        // Inicializa listas de predecessores e sucessores
        else{
            for (int i = 0; i < numVertices; i++) {
                predecessores.add(new ArrayList<>());
                sucessores.add(new ArrayList<>());
            }
        }
    }

    public static void addArestaLista(int v1, int v2) {
        
        // Se o grafo não for direcionado, adiciona também nas listas de adjacência dos vértices
        if (!ehDirecionado) {
            listaAdj.get(v1).add(v2);
            listaAdj.get(v2).add(v1);
        }
        // Adiciona v2 como sucessor de v1 e v1 como predecessor de v2
        else {
            sucessores.get(v1).add(v2);
            predecessores.get(v2).add(v1);
        }
    }

    public static void removerArestaLista(int v1, int v2) {
    
        // Se o grafo não for direcionado, remove também das listas de adjacência dos vértices
        if (!ehDirecionado) {
            listaAdj.get(v1).remove((Integer) v2);
            listaAdj.get(v2).remove((Integer) v1);
        }
        // Remove v2 da lista de sucessores de v1 e v1 da lista de predecessores de v2
        else {
            sucessores.get(v1).remove((Integer) v2);
            predecessores.get(v2).remove((Integer) v1);
        }
    }

    public int obterNumVertices() {
        return numVertices;
    }

    public boolean ehDirecionado() {
        return ehDirecionado;
    }

    public static List<Integer> obterVizinhosReais(int v) {
        // Verifica se o grafo é direcionado
        if (ehDirecionado) {
            System.out.println("O grafo é direcionado.");
            return null; // Retorna null pois o grafo é direcionado
        }
        
        // Como o grafo não é direcionado, retorna a lista de adjacência do vértice
        // Obter os valores reais dos vértices, pois a lista começa da posição 0
        List<Integer> verticesReais = valoresReaisVertices(listaAdj.get(v));
    
        // Retorna a lista de vizinhos com os valores reais dos vértices
        return verticesReais;
    }

    public static List<Integer> obterPredecessoresReais(int v) {
        // Verifica se o grafo é direcionado
        if (!ehDirecionado) {
            return null; // Retorna null pois o grafo é não direcionado
        }
        
        List<Integer> verticesReais = valoresReaisVertices(predecessores.get(v));
    
        // Retorna a lista de vizinhos com os valores reais dos vértices
        return verticesReais;
    }

    public static List<Integer> obterSucessoresReais(int v) {
        // Verifica se o grafo é direcionado
        if (!ehDirecionado) {
            System.out.println("O grafo é não direcionado.");
            return null; // Retorna null pois o grafo é não direcionado
        }
        
        List<Integer> verticesReais = valoresReaisVertices(sucessores.get(v));
        return verticesReais;
    }

    public static int obterGrauVertice(int v) {
        if (ehDirecionado) {
            return predecessores.get(v).size() + sucessores.get(v).size();
        } else {
            return listaAdj.get(v).size();
        }
    }

    public static boolean regular() {
        int grau = obterGrauVertice(0);
        for (int i = 1; i < numVertices; i++) {
            if (obterGrauVertice(i) != grau) {
                return false;
            }
        }
        return true;
    }

    // Método para verificar se o grafo é bipartido
    public static boolean ehBipartido() {
        int[] coloracao = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            coloracao[i] = -1;
        }
        for (int i = 0; i < numVertices; i++) {
            if (coloracao[i] == -1) {
                if (!verificarBipartidoUtil(i, coloracao)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean verificarBipartidoUtil(int vertice, int[] coloracao) {
        coloracao[vertice] = 1;
        List<Integer> vizinhos;
        if (!ehDirecionado) {
            vizinhos = obterVizinhos(vertice);
        } else {
            List<Integer> sucessores = obterSucessores(vertice);
            List<Integer> predecessores = obterPredecessores(vertice);
            vizinhos = new ArrayList<>(sucessores);
            vizinhos.addAll(predecessores);
        }
    
        for (int vizinho : vizinhos) {
            if (coloracao[vizinho] == -1) {
                coloracao[vizinho] = 1 - coloracao[vertice];
                if (!verificarBipartidoUtil(vizinho, coloracao)) {
                    return false;
                }
            } else if (coloracao[vizinho] == coloracao[vertice]) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> obterSucessores(int v) {
        return sucessores.get(v);
    }

    public static List<Integer> obterPredecessores(int v) {
        return predecessores.get(v);
    }

    public static List<Integer> obterVizinhos(int v) {
        return listaAdj.get(v);
    }

    public static List<Integer> valoresReaisVertices(List<Integer> vertices) {
        List<Integer> verticesReais = new ArrayList<>();
        for (int v : vertices) {
            verticesReais.add(v + 1); // Adiciona 1 ao valor do vértice
        }
        return verticesReais;
    }

}
