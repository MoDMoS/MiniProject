package miniproject;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
public class block1 {
    Image img;
    public int y = -100,p = 0;
    public int x= (int) ((Math.random()*800));
    public int t=4;
    public int l;
    block1(){
            String imageLocation = "Block1.png";
            URL imageURL = this.getClass().getResource(imageLocation);
            img = Toolkit.getDefaultToolkit().getImage(imageURL);
            runner.start();
    }
    block1(int l){
            String imageLocation = "Block1.png";
            URL imageURL = this.getClass().getResource(imageLocation);
            img = Toolkit.getDefaultToolkit().getImage(imageURL);
            runner.start();
            this.l = l;
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while(true){
                y += t;
                if(y >= 900){
                    img = null;
                    runner = null;
                    x = -500;
                    y = 0;
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
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
