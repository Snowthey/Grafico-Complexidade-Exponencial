public class Operacoes {

    public int caixeiroViajante(int [][] grafo){

        int numVertices = grafo.length;
        boolean[] visitado = new boolean[numVertices];
        int[] caminhoAtual = new int[numVertices];
        int[] melhorCaminho = new int[numVertices];
        int menorDistancia = Integer.MAX_VALUE;

        caminhoAtual[0] = 0;
        visitado[0] = true;
        return permutacao(grafo, visitado, caminhoAtual, 1, numVertices, 0, melhorCaminho, menorDistancia);
    }

    public int permutacao(int[][] grafo, boolean[] visitado, int[] caminhoAtual, int nivel, int numVertices, int distanciaAtual, int[] melhorCaminho, int menorDistancia){
        int operacoes = 1;

        if(nivel == numVertices){
            if(grafo[caminhoAtual[nivel - 1]][caminhoAtual[0]] != 0 && distanciaAtual + grafo[caminhoAtual[nivel - 1]][caminhoAtual[0]] < menorDistancia){
                System.arraycopy(caminhoAtual, 0, melhorCaminho, 0, numVertices);
                menorDistancia = distanciaAtual + grafo[caminhoAtual[nivel - 1]][caminhoAtual[0]];
                operacoes++;
            }
        } else{
            for(int i = 1; i < numVertices; i++){
                if(!visitado[i] && grafo[caminhoAtual[nivel - 1]][i] != 0){
                    visitado[i] = true;
                    caminhoAtual[nivel] = i;
                    operacoes += permutacao(grafo, visitado, caminhoAtual, nivel + 1, numVertices, distanciaAtual + grafo[caminhoAtual[nivel - 1]][i], melhorCaminho, menorDistancia);
                    visitado[i] = false;
                }
                operacoes++;
            }
        }
        return operacoes;
    }
}

