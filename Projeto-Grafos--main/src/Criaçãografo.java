import java.util.Scanner;

public class Criaçãografo {
    
    private static int numeroVertice=0;
    
    public static void Criando () {
        Scanner sc = new Scanner(System.in);

        //variáveis
        int tipo=0;
    
        System.out.println("Quantos vértices deseja ter? ");
        numeroVertice=sc.nextInt();
        while (numeroVertice<=0) 
        {   System.out.println("Digite um valor acima de 0 ");
            numeroVertice=sc.nextInt();  
        }
       
        System.out.println("Que tipo de grafo deseja montar? Digite: \n(1) Grafo direcionado  \n(2) Grafo não direcionado ");
        tipo=sc.nextInt(); 
        MatrizAdjCriacao grafoM = new MatrizAdjCriacao(numeroVertice,tipo);
        ListaAdjacencia grafoL = new ListaAdjacencia(numeroVertice,tipo);
        formandorelaçoes();
    
    }
    public String [] obterNomes;


    public static void formandorelaçoes() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite as arestas nesse formato: 1,3/4,5/2,4/ ");
        String arestas = sc.nextLine();
        String[] pares = arestas.split("/");
        int quantidadeAresta = pares.length;
        //variavel 2 
        int origem=0;
        int destino=0;
        // 4,1
        for(int i=0;i<quantidadeAresta;i++) 
        {   
            String[] vertices = pares[i].split(",");
            origem= Integer.parseInt(vertices[0]);
            destino= Integer.parseInt(vertices[1]);
            MatrizAdjCriacao.addArestaMatriz(origem-1,destino-1);
            ListaAdjacencia.addArestaLista(origem-1, destino-1);
        
        }   
    

    }
//excluindo relações 
   
    public static void excluindorelaçoes() {

        Scanner sc = new Scanner(System.in);

        System.out.printf("Digite os vértices que tem relação entre si: 1,3/4,5/2,4/");
        String arestas = sc.nextLine().trim();
        String[] pares = arestas.split("/");
        int quantidadeAresta = pares.length;
        //variavel 2 
        int origem=0;
        int destino=0;
        
        for(int i=0;i<quantidadeAresta;i++) 
        {   String[] vertices = pares[i].split(",");
            origem= Integer.parseInt(vertices[0].trim());
            destino= Integer.parseInt(vertices[1].trim());
            MatrizAdjCriacao.removerArestaMatriz(origem-1, destino-1);
            ListaAdjacencia.removerArestaLista(origem-1,destino-1);
        }

    }
    

    
}




    
