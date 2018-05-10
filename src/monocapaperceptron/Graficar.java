/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monocapaperceptron;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author mcotrina
 */
public class Graficar extends Canvas{
    JFrame frame;
    Neuron[] neurona;
    int valorInicio = 0;
    double matriz[][];
    public Graficar(int sizeCuadro, Neuron[] neurona)
    {
        super();
        matriz = new double[neurona.length][4];
        for(int n=0;n<neurona.length;n++){
                matriz[n][0] = valorInicio;
                matriz[n][1] = (-((neurona[n].getW()[0]/neurona[n].getW()[1])*valorInicio)-(neurona[n].getBias()/neurona[n].getW()[1]));   
                matriz[n][2] = sizeCuadro;       
                matriz[n][3] = (-((neurona[n].getW()[0]/neurona[n].getW()[1])*sizeCuadro)-(neurona[n].getBias()/neurona[n].getW()[1]));        
        }

        this.neurona = neurona; 
        super.setSize(sizeCuadro,sizeCuadro);
        super.setBackground(Color.WHITE);
        frame = new JFrame("Grafica de clases del Perceptron");
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(
        new WindowAdapter() {public void windowClosing( WindowEvent evt ) { System.exit( 0 );} } );
    }
 
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i=0;i<this.neurona.length;i++){
            int x1 = (int)this.matriz[i][0];
            int y1 = (int)this.matriz[i][1];
            int x2 = (int)this.matriz[i][2];
            int y2 = (int)this.matriz[i][3];
            System.out.println("X1: "+x1+" Y1: "+y1+" X2: "+x2+" Y2: "+y2);
            g.drawLine(x1,y1,x2,y2); 
        }
    }

}
