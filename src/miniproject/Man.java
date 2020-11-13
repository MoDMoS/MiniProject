package miniproject;

import javax.swing.ImageIcon;

public class Man{
    public ImageIcon[] im = new ImageIcon[3];
    public int x,y;
    public int count = 0;
    Man(){
        for(int i=0;i<im.length;i++){
            im[i] = new ImageIcon(this.getClass().getResource((i+1)+".png"));
	}
    }
}
