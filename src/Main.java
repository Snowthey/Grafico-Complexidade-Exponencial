import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Operacoes objOperacoes = new Operacoes();
        Grafico objGrafico;
        Random random = new Random();

        XYSeries series = new XYSeries("Complexidade Quadratica");

        for(int tamanho = 10; tamanho <= 12; tamanho = tamanho + 1){
            int[][] grafo = new int[tamanho][tamanho];

            for(int i = 0; i < tamanho; i++){
                for(int j = 0; j < tamanho; j++){
                    grafo[i][j] = random.nextInt(200);
                }
            }

            int quantidade = objOperacoes.caixeiroViajante(grafo);

            series.add(tamanho, quantidade);
            System.out.println("Quantidade de buscas: " + quantidade);
        }

        objGrafico = new Grafico(series);
        System.out.println("Gráfico gerado com sucesso!");
    }
}