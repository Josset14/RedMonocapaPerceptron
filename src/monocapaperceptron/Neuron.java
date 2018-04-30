/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monocapaperceptron;

import java.util.List;

/**
 *
 * @author MAC
 */
public class Neuron {
    
    private int[] entradas; 
    private List<Double> x;
    private List<Double> w;
    private double polarizacion;
    
    public Neuron(int nEntradas) {
        this.entradas = new int[nEntradas]; 
    }
    public int cantidadEntradas(){
            return this.entradas.length;
    }
    public int sinapsis(){

        if(this.entradas.length == this.x.size() && this.x.size() == this.w.size()){
            return funcionActivacion(pNeto()+this.polarizacion);
        }else{
            System.out.println("ERROR Entradas: "+this.entradas.length+" X: "+this.x.size()+" W: "+this.w.size());
            return 0;
        }
    }
    public void setX(List<Double> x){
        this.x=x;
    }
    public List<Double> getX(){
        return this.x;
    }
    public void setW(List<Double> w){
        this.w=w;
    }
    public List<Double> getW(){
        return this.w;
    }
    public void setPolarizacion(Double polarizacion){
        this.polarizacion= polarizacion;
    }
    public Double getPolarizacion(){
        return this.polarizacion;
    }
    private double pNeto(){
        double pNeto=0;
        for(int i=0;i<this.w.size();i++){
            pNeto =pNeto +(this.w.get(i)*this.x.get(i));
        }
        return pNeto;
    }
    private int funcionActivacion(double n){
        if(n>=0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Neuron{" + "entradas=" + entradas.length + ", x=" + x + ", w=" + w + ", polatizacion=" + polarizacion + '}'; 
    }
    
    
}

