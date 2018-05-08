/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monocapaperceptron;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAC
 */
public class Trainer {
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
    
    private double[] actualizarPesos(double[] entrada, double[] wOriginal, double error ){
        double[] w = new double[wOriginal.length];
        for(int j=0; j<entrada.length;j++){
            w[j] = ((error*entrada[j])+wOriginal[j]); 
        }
        return w;
    }
}
