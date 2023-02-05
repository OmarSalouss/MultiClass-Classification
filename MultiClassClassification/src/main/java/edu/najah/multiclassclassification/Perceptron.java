/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.najah.multiclassclassification;

import java.util.Random;

/**
 *
 * @author YousefHanbali & OmarSalous
 */
public class Perceptron {
    double w1,w2;
    double output;
    double threshold;
    double error;
    String label;
    
    public Perceptron(){
        Random rand = new Random();
        w1 = rand.nextFloat()*2 -1;
        w2 = rand.nextFloat()*2 -1;
        threshold = rand.nextFloat()*2 -1;
        System.out.println("w1 = "+w1);
        System.out.println("w2 = "+w2);
    }
    
    public void calculateOutput(float x1,float x2){
        if( (w1*x1+w2*x2-threshold) >= 0){
            output = 1;
        }else output = 0;
    }
    
    public void calculateError(float expected){
        error = expected-output;
    }
    
    public void weightCorrection(float x1,float x2,double learningRate){
        w1 = w1 + learningRate*error*x1;
        w2 = w2 + learningRate*error*x2;
    }
    
}
