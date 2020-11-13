package miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Howtoplay extends JPanel{
    private ImageIcon feild = new ImageIcon(this.getClass().getResource("Howtoplay.jpg"));
    private ImageIcon next = new ImageIcon(this.getClass().getResource("Close.png"));
    public JButton Bclose = new JButton(next);
    Howtoplay(){
        setLayout(null);
        add(Bclose);
        Bclose.setBounds(800,700,150,90); 
        Bclose.setForeground(Color.ORANGE);
        Font ButtonStart = new Font(Bclose.getFont().getName(),Bclose.getFont().getStyle(),20); 
        Bclose.setFont(ButtonStart);
        Bclose.setBorderPainted(false);
        Bclose.setBorder(null);
        Bclose.setOpaque(false);
        Bclose.setContentAreaFilled(false);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(feild.getImage(),0,0,990,800,this);
    }
}
