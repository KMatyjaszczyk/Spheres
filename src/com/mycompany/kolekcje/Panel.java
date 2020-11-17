package com.mycompany.kolekcje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Panel extends JPanel {
    private ArrayList<Kula> listaKul;
    private int size = 60;
    private Timer timer;
    private final int DELAY = 15;
    private String message = "";
    //dla 30fps -> 1s/30 = 0,033s
    public Panel() {
        listaKul = new ArrayList<>();
        setBackground(Color.BLACK);
        addMouseListener(new Event());
        addMouseWheelListener(new Event());
        timer = new Timer(DELAY, new Event());
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Kula k : listaKul) {
            g.setColor(k.color);
            g.drawOval(k.x, k.y, k.size, k.size);
        }
        g.setColor(Color.YELLOW);
        g.drawString("Liczba kulek: " + Integer.toString(listaKul.size()),40,40);
        g.drawString("Rozmiar kuli: " + size,40,60);
        g.drawString(message,40,80);
    }

    private class Event implements MouseListener,
            ActionListener, MouseWheelListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            message = "Kliknąłeś myszkę";
        }
        @Override
        public void mousePressed(MouseEvent e) {
            listaKul.add(new Kula(e.getX(), e.getY(), size));
            repaint();
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            message = "Puściłeś myszkę";
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            message = "Dzięki że wróciłeś!";
        }
        @Override
        public void mouseExited(MouseEvent e) {
            message = "Wróć!";
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Kula k : listaKul) {
                k.update();
            }
            repaint();
        }
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            int scroll = e.getWheelRotation();
            if (scroll < 0) {
                size++;
                System.out.println("Kułko w gure, rozmiar++");
            }
            else {
                System.out.println("Kułko w duł, rozmiar--");
                size--;
            }
        }
    }

    private class Kula {
        public int x, y, size, xspeed, yspeed;
        public Color color;
        private final int MAX_SPEED = 5;
        public Kula(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            color = new Color((float) Math.random(), (float)
                    Math.random(), (float) Math.random());
            xspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
            while (xspeed == 0) xspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
            yspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
            while (yspeed == 0) yspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
        }
        public void update() {
            x += xspeed;
            y += yspeed;
            if (x <= 0 || x >= getWidth()-size) {
                xspeed = -xspeed;
            }
            if (y <= 0 || y >= getHeight()-size) {
                yspeed = -yspeed;
            }
            for (Kula k : listaKul) {
                double odleglosc =  Math.pow((k.x+(size/2.0) - this.x)+(size/2.0), 2) + Math.pow((k.y+(size/2.0) - this.y+(size/2.0)), 2);
                double sumaPromieni = Math.pow(((double)k.size/2 + (double)this.size/2), 2);
                if (odleglosc <= sumaPromieni) {
                    int robxspeed, robyspeed;
                    robxspeed = this.xspeed;
                    robyspeed = this.yspeed;
                    this.xspeed = k.xspeed;
                    this.yspeed = k.yspeed;
                    k.xspeed = robxspeed;
                    k.yspeed = robyspeed;
                }
            }
        }
    }
}
