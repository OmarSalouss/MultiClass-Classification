/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.najah.multiclassclassification;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author YousefHanbali & OmarSalous
 */
public class DrawingPanel extends JPanel {
        
        
        ArrayList<Node> classes = new ArrayList<>();
        ArrayList<Node> copy = new ArrayList<>();
        
        Perceptron[] p;
        
        
        Map<String,Color> label = new HashMap<>();
        
        public DrawingPanel(){
            classes = new ArrayList<>();
            copy = new ArrayList<>();
            label = new HashMap<>();
            label.put("A", Color.RED);
            label.put("B", Color.BLUE);
            label.put("C", Color.YELLOW);
            label.put("D", Color.GREEN);
        }
        
        
        int width = 0;
        int height = 0;
        int r = 30;
        
        public void addNode(Node temp){
            classes.add(temp);
        }
        
        public ArrayList<Node> getNodes(){
            return classes;
        }
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            width = this.getWidth();
            height = this.getHeight();
            g.setColor(Color.WHITE);
            g.fillRect(0,0,width,height);
            
            
            
            for(Node temp:classes){
                g.setColor(label.get(temp.getLabel()));
                g.drawOval((int)temp.getX()-r/2,(int)temp.getY()-r/2, r, r);
                g.drawString(temp.getLabel(), (int)temp.getX(), (int)temp.getY());
            }
            
            if(!(this.p == null)){
                for(int i = 0;i<p.length;i++){
                    g.setColor(label.get(p[i].label));
                    float x2_1 = (float)((p[i].threshold - p[i].w1*-1)/p[i].w2);
                    float x2_2 = (float)((p[i].threshold - p[i].w1*1)/p[i].w2);
                    int x2_1_ = (int)((x2_1 +1)*(height/2));
                    int x2_2_ = (int)((x2_2 +1)*(height/2));
                    g.drawLine(0, x2_1_, width, x2_2_);
                }
            }
            
    }

    public void setP(Perceptron[] p) {
        this.p = p;
    }

}
