package miniproject;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class HPPlus extends block1{
    Image img;
    
    HPPlus(int l){
        String imageLocation = "RedHeart.png";
        URL imageURL1 = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL1);
        runner.start();
        this.l = l;
    }
    Thread runner = new Thread(new Runnable() {
	public void run() {
            while(true){
		p += t;
		if(p>= 900){
                    img = null;
                    runner = null;
                    x = -500;
                    p = 0;
                }
                try{
                    runner.sleep(l);
                }catch(InterruptedException e){}
            }
	}
    });

    public Image getImage(){
	return img;
    }
}
