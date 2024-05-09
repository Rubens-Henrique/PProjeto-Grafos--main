import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class MatrizAdjCriacao {
    
    private static int[][] matrizadj;
    private static boolean ehDirecionado;
    private static int numeroVertice;
    // Construtor da classe para inicializar a matriz

    public MatrizAdjCriacao(int numeroVertice,int tipo) {
        matrizadj = new int[numeroVertice][numeroVertice];
        ehDirecionado = (tipo == 1);
        this.numeroVertice = numeroVertice;

        // Inicializa a matriz com zeros
        for (int i = 0; i < numeroVertice; i++) {
            for (int j = 0; j < numeroVertice; j++) {
                matrizadj[i][j] = 0;
            }
        }
    }
   public boolean ehDirecionado() {
        return ehDirecionado;
    }
    public static int obterNumVertices() {
        return numeroVertice;
    }
    

    // Adiciona uma aresta à matriz de adjacência
    public static void addArestaMatriz(int origem, int destino) {

        if ( !ehDirecionado) {
            matrizadj[origem][destino] = 1;
            matrizadj[destino][origem] = 1; // para grafos não direcionados
        } else {
            matrizadj[origem][destino] = 1; // para grafos direcionados 
        }
    }

    // Remove uma aresta da matriz de adjacência
    public static void removerArestaMatriz(int origem, int destino) {
        if (!ehDirecionado)  {
            matrizadj[origem][destino] = 0;
            matrizadj[destino][origem] = 0; // para grafos não direcionados
        } else {
            matrizadj[origem][destino] = 0; // para grafos direcionados 
        }
    }


    public static boolean grafoSimples() 
    { int numeroVertice = matrizadj.length;
        for (int i=0;i<numeroVertice ;i++)
        {   for (int j=0;j<numeroVertice ;j++)
            if (matrizadj[i][j]>1 || (i==j && matrizadj[i][i]==1))
                {  return false; } 
        } 
        return true; // Grafo é simples


    }

    public static void grafoCompleto() {
        boolean verifica = grafoSimples();
        if (verifica) {
            boolean completo = true;
            for (int i = 0; i < matrizadj.length; i++) {
                for (int j = 0; j < matrizadj[i].length; j++) {
                    if (i != j && matrizadj[i][j] != 1) {
                        completo = false;
                        break;
                    }
                }
                if (!completo) {
                    break;
                }
            }
            if (completo) {
                System.out.println("É um grafo completo");
            } else {
                System.out.println("Não é um grafo completo");
            }
        } else {
            System.out.println("Não é um grafo completo"); // Se o grafo não for simples, não pode ser completo
        }
    }

    // Imprime a matriz
    public static void imprime() {
        Scanner sc = new Scanner(System.in);
    
        int numeroVertice = obterNumVertices(); // Correção aqui
        String[] nomes = new String[numeroVertice];
        int k = 0;
        while (k < numeroVertice) {
            System.out.printf("Digite o nome do %d vértice, ele será associado ao numero %d", k, k);
            nomes[k] = sc.nextLine();
            k++;
        }
    
        System.out.print("      ");
        for (String nome : nomes) {
            System.out.printf("%-7s", nome);
        }
        System.out.println();
    
        for (int i = 0; i < numeroVertice; i++) {
            System.out.printf("%-7s", nomes[i]);
            for (int j = 0; j < numeroVertice; j++) {
                System.out.printf("%-7d", matrizadj[i][j]);
            }
            System.out.println();
        }

    } 
    //Faz a busca em largura do grafo
    public static void largura (int verticeIInicial) { 
        int verticeInicial = verticeIInicial;
        int numVertices = matrizadj.length;
        boolean[] visitados = new boolean[numVertices];
        
        Queue<Integer> fila = new LinkedList<>();
        fila.offer(verticeInicial);
        visitados[verticeInicial] = true;
        
        while (!fila.isEmpty()) {
            int vertice = fila.poll();
            System.out.print(vertice + " ");
            
            for (int vizinho = 0; vizinho < numVertices; vizinho++) {
                if (matrizadj[vertice][vizinho] == 1 && !visitados[vizinho]) {
                    fila.offer(vizinho);
                    visitados[vizinho] = true;
                }
            }
        }
    }
}
//comparaçãoes