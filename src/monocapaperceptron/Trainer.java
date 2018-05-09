/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monocapaperceptron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Miguel Angel Cotrina Espinoza
 * Universidad Tecnologica del Peru
 * Correo: 0820832@utp.edu.pe
 */
public class Trainer {
    //Metodo para entrenamiento individual de neurona
    public Neuron train(Neuron neurona, double[][] entradas, double[] salidaEsperada, int maximoCiclos){
        double error=0;
        double w[] = new double[entradas[0].length];
        double bias = -1+(Math.random()*(2));
        for(int i=0;i<entradas[0].length;i++){
            w[i]= (-1+(Math.random()*(2)));
        }    
        neurona.setW(w);
        neurona.setBias(bias);
        
        for(int i=0;i<maximoCiclos;i++){
            for(int j=0;j<salidaEsperada.length;j++){
                neurona.setX(entradas[j]);
                error = salidaEsperada[j] - neurona.sinapsis();
                neurona.setW(actualizarPesos(entradas[j],neurona.getW(),error));
                neurona.setBias(neurona.getBias()+error);
            }
        }
        return neurona;
    }
    //Metodo para entrenamiento de multiples neuronas en una capa
    public Neuron[] trainers(Neuron[] neurona, double[][] entradas, double[][] salidaEsperada, int maximoCiclos){
        double error=0;
        double w[][] = new double[neurona.length][entradas[0].length];
        double bias[] = new double[neurona.length];
        System.out.println("N° neuronas:  "+neurona.length);
        for(int n=0;n<neurona.length;n++){
            neurona[n] = new Neuron();
            bias[n] = -1+(Math.random()*(2));
            for(int i=0;i<entradas[0].length;i++){
                w[n][i]= (-1+(Math.random()*(2)));
            }    
            neurona[n].setW(w[n]);
            neurona[n].setBias(bias[n]);
        }

        for(int i=0;i<maximoCiclos;i++){
            for(int n=0;n<neurona.length;n++){
                for(int j=0;j<salidaEsperada[n].length;j++){
                    neurona[n].setX(entradas[j]);
                    error = salidaEsperada[n][j] - neurona[n].sinapsis();
                    neurona[n].setW(actualizarPesos(entradas[j],neurona[n].getW(),error));
                    neurona[n].setBias(neurona[n].getBias()+error);
                }
            }
        }
        return neurona;
    }
    private double[] actualizarPesos(double[] entrada, double[] wOriginal, double error ){
        double[] w = new double[wOriginal.length];
        for(int j=0; j<entrada.length;j++){
            w[j] = ((error*entrada[j])+wOriginal[j]); 
        }
        return w;
    }
}
