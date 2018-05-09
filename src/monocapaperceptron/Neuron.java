/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monocapaperceptron;

import java.util.Arrays;
import java.util.List;

/**
 * @author Miguel Angel Cotrina Espinoza
 * Universidad Tecnologica del Peru
 * Correo: 0820832@utp.edu.pe
 */
public class Neuron {

    private double[] x;
    private double[] w;
    private double bias;
    
    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double[] getW() {
        return w;
    }

    public void setW(double[] w) {
        this.w = w;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }
    public int sinapsis(){
        double pNeto=0;
        //Calculamos el peso neto
        if(w.length==x.length){
            for(int i=0;i<this.w.length;i++){
                pNeto =pNeto +(this.w[i]*this.x[i]);
            }
            return hardlim(pNeto+this.bias);
        }else{
            System.out.println("ERROR Entradas no iguales  X: "+this.x.length+" W: "+this.w.length);
            return 0;
        }
    }
    private int hardlim(double n){
        if(n>=0){
            return 1;
        }else{
            return 0;
        }
    }
    @Override
    public String toString() {
        return "Neuron{" + "x=" + Arrays.toString(x) + ", w=" + Arrays.toString(w) + ", bias=" + bias + '}';
    }
}
