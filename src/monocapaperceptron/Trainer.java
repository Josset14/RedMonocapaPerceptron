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
    //Constante de tasa de aprendizaje
    static final int alfa = 1;

    public Neuron train(Neuron neurona, List<List<Double>> entrada, List<Double> valorEsperado, int limiteConvergencia){
        double error=0;

        List<Double> w = new ArrayList<>();
        //Generamos el valor aleatorio para la polarizacion neuronal
        double polarizacion = -1+(Math.random()*(2));
        //Generamos los valores aleatorios para los pesos neuronales
        for(int i=0;i<neurona.cantidadEntradas();i++){
            w.add(-1+(Math.random()*(2)));
        }
        neurona.setW(w);
        neurona.setPolarizacion(polarizacion);
        int contadorEstabilizacionRed = 0;
        for(int i=0;i<limiteConvergencia;i++){
            int validacionEstabilizacionRed = 0;
            for(int j=0;j<valorEsperado.size();j++){
                neurona.setX(entrada.get(j));
                error = valorEsperado.get(j) - neurona.sinapsis();
                neurona.setW(actualizarPesos(entrada.get(j),neurona.getW(),error));
                neurona.setPolarizacion(neurona.getPolarizacion()+error);
                validacionEstabilizacionRed=validacionEstabilizacionRed+(int)Math.abs(error);

            }
            contadorEstabilizacionRed++;
            if(validacionEstabilizacionRed==0){
                break;
            }
            
        }
        System.out.println("Numero de ciclos antes de estabilizacion Sinaptica: "+contadorEstabilizacionRed);
        return neurona;
    }
    private List<Double> actualizarPesos(List<Double> entrada, List<Double> wOriginal, double error ){
        List<Double> w = new ArrayList<>();
        for(int j=0; j<entrada.size();j++){
            w.add((error*entrada.get(j)*alfa)+wOriginal.get(j)); 
        }
        return w;
    }
}

