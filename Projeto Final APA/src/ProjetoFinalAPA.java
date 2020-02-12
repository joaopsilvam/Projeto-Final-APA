import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjetoFinalAPA {
    static String nome;
    static int dimensao;
    static int capacidade;
    static int[] demandas;
    static int[][] custos;
    
    static int[] retirarEspaços(String[] array){
        List<Integer> temp = new ArrayList();
        for(int i = 0; i < array.length; i++){
            if(!array[i].equals("")){
                temp.add(Integer.parseInt(array[i]));
            }
        }
        int[] fim = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            fim[i] = temp.get(i);
        }
        return fim;
    }
    
    static void carregarArquivo(String path){
        File file = new File(path);
        try {
            FileReader reader = new FileReader(file);
            BufferedReader input = new BufferedReader(reader);
            String linha;
            while ((linha = input.readLine()) != null) {
                if(linha.startsWith("NAME: ")){
                    nome = linha.split(" ")[1];
                }
                else if(linha.startsWith("DIMENSION: ")){
                    dimensao = Integer.parseInt(linha.split(" ")[1]);
                }
                else if(linha.startsWith("CAPACITY: ")){
                    capacidade = Integer.parseInt(linha.split(" ")[1]);
                }
                else if(linha.startsWith("DEMAND_SECTION:")){
                    demandas  = new int[dimensao];
                    for(int i = 0; i < dimensao; i++){
                        linha = input.readLine();
                        demandas[i] = Integer.parseInt(linha.split(" ")[linha.split(" ").length-1]);
                    }
                }    
                else if(linha.startsWith("EDGE_WEIGHT_SECTION")){
                    custos  = new int[dimensao][dimensao];
                    for(int i = 0; i < dimensao; i++){
                        linha = input.readLine();
                        custos[i] = retirarEspaços(linha.split(" "));
                        //System.out.println(Arrays.toString(custos[i]));
                    }
                }    
                
                //System.out.println(linha);
            }
            input.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

    public static void main(String[] args) {
        carregarArquivo("C:/Users/joaop/Documents/NetBeansProjects/Projeto Final APA/build/classes/Instâncias/P-n16-k8.txt");
        System.out.println(nome);
        System.out.println(dimensao);
        System.out.println(capacidade);
        System.out.println("Demandas -> "+Arrays.toString(demandas));
        System.out.println("Custos ->");
        for(int i = 0; i < dimensao; i++){
            System.out.println(Arrays.toString(custos[i]));

        }
    }
    
}
