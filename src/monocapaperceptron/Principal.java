/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monocapaperceptron;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel Angel Cotrina Espinoza
 * Universidad Tecnologica del Peru
 * Correo: 0820832@utp.edu.pe
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        operacionBibliotecario();
    }
    
    public static void operacionBibliotecario(){
        // Entrada para las neuronas
        double[][] Entradas =  {{0.7,3},
                                {1.5,5},
                                {2.0,9},
                                {0.9,11},
                                {4.2,0},
                                {2.2,1},
                                {3.6,7},
                                {4.5,6}};
		
        //Salida bidimencional
        double[][] salidaEsperada = {{0,0,0,0,1,1,1,1},{0,0,1,1,0,0,1,1}};
        //Creamos a la matriz de neuronas
        Neuron neurona[] = new Neuron[2];
        //Entrenamos a las neuronas
        Trainer trainer = new Trainer();
        neurona = trainer.trainers(neurona, Entradas, salidaEsperada,100);
        //Probamos la neurona entrenada
        double[] datoPrueba1 = {2.0,9};
        neurona[0].setX(datoPrueba1);
        neurona[1].setX(datoPrueba1);
        System.out.println(neurona[0].toString());
        System.out.println(neurona[1].toString());
        Graficar grafica = new Graficar(500,neurona);
        System.out.println("Salida del Perceptron: "+neurona[0].sinapsis()+" "+neurona[1].sinapsis());
    }
}
