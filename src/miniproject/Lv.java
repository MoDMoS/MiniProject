package miniproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Lv extends JPanel{
    private ImageIcon feild = new ImageIcon(this.getClass().getResource("bgState.png"));
    private ImageIcon easy = new ImageIcon(this.getClass().getResource("easy.png"));
    private ImageIcon Middle = new ImageIcon(this.getClass().getResource("Middle.png"));
    private ImageIcon hard = new ImageIcon(this.getClass().getResource("hard.png"));
    public JButton BEasy = new JButton(easy);
    public JButton BMiddle  = new JButton(Middle);
    public JButton BHard  = new JButton(hard);
    Lv(){
        setLayout(null);
        add(BEasy);
        BEasy.setBounds(400,250,150,90); 
        BEasy.setForeground(Color.ORANGE);
        Font ButtonStart = new Font(BEasy.getFont().getName(),BEasy.getFont().getStyle(),20); 
        BEasy.setFont(ButtonStart);
        BEasy.setBorderPainted(false);
        BEasy.setBorder(null);
        BEasy.setOpaque(false);
        BEasy.setContentAreaFilled(false);
        add(BMiddle);
        BMiddle.setBounds(325,350,300,90); 
        BMiddle.setForeground(Color.ORANGE);
        Font ButtonExit = new Font(BMiddle.getFont().getName(),BMiddle.getFont().getStyle(),20); 
        BMiddle.setFont(ButtonExit);
        BMiddle.setBorderPainted(false);
        BMiddle.setBorder(null);
        BMiddle.setOpaque(false);
        BMiddle.setContentAreaFilled(false);
        add(BHard);
        BHard.setBounds(400,450,150,90); 
        BHard.setForeground(Color.ORANGE);
        Font ButtonHow = new Font(BHard.getFont().getName(),BHard.getFont().getStyle(),20); 
        BHard.setFont(ButtonHow);
        BHard.setBorderPainted(false);
        BHard.setBorder(null);
        BHard.setOpaque(false);
        BHard.setContentAreaFilled(false);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(feild.getImage(),0,0,990,800,this);
    }
}
