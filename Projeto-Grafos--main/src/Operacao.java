import java.util.Scanner;


public class Operacao {
    
  
//Lapidar : Posição da lista. 

    public static void operacoes()
    {   
        Scanner sc = new Scanner(System.in);
        int controle2=0;
        int vertice=0;
        String r = "s";
        while (r.equalsIgnoreCase("s")) {
        System.out.println("Qual operação deseja realizar ? \n(1) Criar mais arestas \n(2) Remover arestas \n(3) Vizinhança Vertice (Grafos não direcionados) \n(4) Identificação dos sucessores e predecessores (Grafos direcionados)\n(5) Identificação do grau de algum vértice \n(6) Testar se o grafo é simples \n(7) Testar se o grafo é completo \n(8) Testar se o grafo é regular  \n(9) Testar se o grafo é bipartido \n(10) Imprimir a matriz de adjacencia ");
        controle2=sc.nextInt();
        switch (controle2) {
            case 1:
                Criaçãografo.formandorelaçoes();
                break; 

            case 2:
                Criaçãografo.excluindorelaçoes();
                break;
        

            case 3:
                int resposta = 1;
                while (resposta == 1) { // Ignora a diferença entre maiúsculas e minúsculas
                    System.out.println("Qual o número do vértice que você deseja conhecer a vizinhança? ");
                    vertice = sc.nextInt();
                    System.out.println("Vizinhos do vértice " + vertice + ": " +  ListaAdjacencia.obterVizinhosReais(vertice-1));
                    System.out.println("Escolha o que deseja realizar: \n(1)Conhecer a vizinhança de outro vértice \n(2) Voltar ao menu de operações");
                    resposta = sc.nextInt();
                }
                break;
                
            case 4: 
                resposta = 1;
                while (resposta == 1) 
                { // Ignora a diferença entre maiúsculas e minúsculas
                    System.out.println("Qual o número do vértice que você deseja conhecer os predecessores e sucessores?  ");
                    vertice = sc.nextInt();
                    System.out.println("Sucessores do vértice " + vertice + ": " +   ListaAdjacencia.obterSucessoresReais(vertice-1));
                    System.out.println("Predecessores do vértice " + vertice + ": " +  ListaAdjacencia.obterPredecessoresReais(vertice-1));
                    System.out.println("Escolha o que deseja realizar: \n(1)Conhecer os predecessores e sucessores de outro vértice \n(2) Voltar ao menu de operações");
                    resposta = sc.nextInt();
                }
               break;

               case 5: 
               resposta = 1;
               while (resposta == 1) 
               { // Ignora a diferença entre maiúsculas e minúsculas
                   System.out.println("Qual vértice você deseja conhecer o grau  ?");
                   vertice = sc.nextInt();
                   System.out.println("Grau do vérice " + vertice + ": " +   ListaAdjacencia.obterGrauVertice(vertice-1));
                   System.out.println("Escolha o que deseja realizar: \n(1)Conhecer o grau de outro vértice \n(2) Voltar ao menu de operações");
                   resposta = sc.nextInt();
               }
           break;

            case 6: 
               boolean verifgrafosimples=MatrizAdjCriacao.grafoSimples();
               if(!verifgrafosimples)
               {    System.out.println("Não é um grafo simples");

               } else {  System.out.println("É  um grafo simples");

               }
                break;

            case 7:
                MatrizAdjCriacao.grafoCompleto();
               break;

            case 8:
               ListaAdjacencia.regular();
               boolean verifgrafoRegular=ListaAdjacencia.regular();
               if(!verifgrafoRegular)
               {    System.out.println("Não é um grafo regular");

               } else {  System.out.println("É  um grafo regular");

               }
                break;
            case 9: 
                boolean verifGrafosBipartidos = ListaAdjacencia.ehBipartido();
                if(!verifGrafosBipartidos)
                { System.out.println("O grafo é bipartido");

                } else {  System.out.println("O grafo não é bipartido");

                }
            
                break;

            case 10: 
               MatrizAdjCriacao.imprime();

                    break; 

             case 11: 
                int vi=1;
                 MatrizAdjCriacao.largura(vi);
     
                         break; 

            }
            System.out.println("Deseja realizar mais operações? Digite 's' ou 'n'");
            r = sc.next().toLowerCase(); 
        }

     }
  
}


