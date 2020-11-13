package miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class homegames extends JPanel{
        private ImageIcon feild = new ImageIcon(this.getClass().getResource("Main.jpg"));
	private ImageIcon exit = new ImageIcon(this.getClass().getResource("Exit.png"));
	private ImageIcon starts = new ImageIcon(this.getClass().getResource("Start.png"));
        private ImageIcon howtoplay = new ImageIcon(this.getClass().getResource("Howtoplay.png"));
	public JButton BStart = new JButton(starts);
	public JButton BExit  = new JButton(exit);
        public JButton BHow  = new JButton(howtoplay);
	homegames(){
            setLayout(null);
            add(BStart);
            BStart.setBounds(400,300,150,90); 
            BStart.setForeground(Color.ORANGE);
            Font ButtonStart = new Font(BStart.getFont().getName(),BStart.getFont().getStyle(),20); 
            BStart.setFont(ButtonStart);
            BStart.setBorderPainted(false);
            BStart.setBorder(null);
            BStart.setOpaque(false);
            BStart.setContentAreaFilled(false);
            add(BExit);
            BExit.setBounds(400,500,150,90); 
            BExit.setForeground(Color.ORANGE);
            Font ButtonExit = new Font(BExit.getFont().getName(),BExit.getFont().getStyle(),20); 
            BExit.setFont(ButtonExit);
            BExit.setBorderPainted(false);
            BExit.setBorder(null);
            BExit.setOpaque(false);
            BExit.setContentAreaFilled(false);
            add(BHow);
            BHow.setBounds(325,400,300,90); 
            BHow.setForeground(Color.ORANGE);
            Font ButtonHow = new Font(BHow.getFont().getName(),BHow.getFont().getStyle(),20); 
            BHow.setFont(ButtonHow);
            BHow.setBorderPainted(false);
            BHow.setBorder(null);
            BHow.setOpaque(false);
            BHow.setContentAreaFilled(false);
	}
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,990,800,this);
	}
}