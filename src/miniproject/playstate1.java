package miniproject;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class playstate1 extends JPanel implements ActionListener{
    
	private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("Project(BG.1).jpg"));
        private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("City Noon.jpg"));
	private final ImageIcon imgstate3 = new ImageIcon(this.getClass().getResource("City Night.jpg"));
	private final ImageIcon pause = new ImageIcon(this.getClass().getResource("puse.png"));
	private final ImageIcon resum = new ImageIcon(this.getClass().getResource("resum.png"));
	private final ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
        private final ImageIcon BlackHeart = new ImageIcon(this.getClass().getResource("heartBalck1.png"));
        private final ImageIcon RedHeart = new ImageIcon(this.getClass().getResource("RedHeart1.png"));
        private final ImageIcon Worker = new ImageIcon(this.getClass().getResource("Worker.gif"));
	Man m = new Man();
        
	homegames hg = new homegames();
	ImageIcon feildover = new ImageIcon(this.getClass().getResource("Gameover.jpg"));
        ImageIcon feildwin = new ImageIcon(this.getClass().getResource("YouWin.jpg"));
	ImageIcon img_paralyze = new ImageIcon(this.getClass().getResource("7.1.png"));
        JButton BStartover = new JButton(back);
	JButton BExitover  = new JButton(back);
	
	public JButton BExithome  = new JButton(back); 
	public ArrayList<block1> block1 = new ArrayList<block1>();
	public ArrayList<block2> block2 = new ArrayList<block2>();
	public ArrayList<Freeze> freeze = new ArrayList<Freeze>();
        public ArrayList<HPPlus> Hp = new ArrayList<HPPlus>();
        public ArrayList<Clock> Clock = new ArrayList<Clock>();
        
        
	public int times;
	public int HP = 3;
	public int rs = 1;
        public int distanceP;
        public int u,l=30,p=10,o = 1;
	boolean timestart = true;
	boolean startball = false;
        boolean check = true;
	
	Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
                        Thread.sleep(1);
                    }catch(Exception e){}
                        repaint();
		}
            }
	});
	Thread tBlock1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                    try{
                        if(startball == false){
                            if(rs == 1){
                                Thread.sleep((long)(Math.random()*10000));
                            }
                            if(rs == 2){
                                Thread.sleep((long)(Math.random()*5000));
                            }
                            if(rs == 3){
                                Thread.sleep((long)(Math.random()*3000));
                            }
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    if(startball == false){
                        block1.add(new block1(l));
                    }
		}
            }
	});
	Thread tBlock2 = new Thread(new Runnable(){
            public void run() {
		while(true){
                    try{
                        if(startball==false){
                            if(rs == 1){
                                Thread.sleep((long)(Math.random()*10000));
                            }
                            if(rs == 2){
                                Thread.sleep((long)(Math.random()*5000));
                            }
                            if(rs == 3){
                                Thread.sleep((long)(Math.random()*3000));
                            }
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    if(startball == false){
                        block2.add(new block2(l));
                    }
		}
            }
	});
	
	Thread Freeze = new Thread(new Runnable(){
            public void run() {
            	while(true){
                    try{
                        if(startball==false){
                            if(rs == 1){
                                Thread.sleep((long)(Math.random()*12000));
                            }
                            if(rs == 2){
                                Thread.sleep((long)(Math.random()*7000));
                            }
                            if(rs == 3){
                                Thread.sleep((long)(Math.random()*5000));
                            }
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    if(startball == false){
                        freeze.add(new Freeze(l));
                    }
		}
            }
	});
        Thread HpPlus = new Thread(new Runnable(){
            public void run() {
            	while(true){
                    try{
                        if(startball==false){
                            if(rs == 1){
                                Thread.sleep((long)(Math.random()*12000));
                            }
                            if(rs == 2){
                                Thread.sleep((long)(Math.random()*15000));
                            }
                            if(rs == 3){
                                Thread.sleep((long)(Math.random()*17000));
                            }
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    if(startball == false){
                        Hp.add(new HPPlus(l));
                    }
		}
            }
	});
        Thread clock = new Thread(new Runnable(){
            public void run() {
            	while(true){
                    try{
                        if(startball==false){
                            if(rs == 1){
                                Thread.sleep((long)(Math.random()*17000));
                            }
                            if(rs == 2){
                                Thread.sleep((long)(Math.random()*15000));
                            }
                            if(rs == 3){
                                Thread.sleep((long)(Math.random()*12000));
                            }
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    if(startball == false){
                        Clock.add(new Clock(l));
                    }
		}
            }
	});
        Thread tTime = new Thread(new Runnable(){
            public void run() {
		while(true){
                    if(timestart == false){
                        times = (times-1) ;
                    }
                    u++;
                    if(u == 10){
                        u = 0;
                        if(l <= 5) l = 10;
                        if(times == 30) l = 30;
                        l -= 5;
                    }
                    if(u == 2){
                        p = 10;
                    }
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
		}
            }
	});
	
	playstate1(){
		this.setFocusable(true);
		this.setLayout(null);
		BExithome.setBounds(920,70,40,40);
		BExithome.addActionListener(this);
		BExithome.addActionListener(this);
		this.add(BExithome);
		
		this.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
                        if(a==KeyEvent.VK_LEFT){
                            m.x-=p;
                            m.count++;
                        }
                        else if(a == KeyEvent.VK_RIGHT){
                           m.x+=p;
                           m.count++;
                       }
                        if(m.count>2){
                            m.count=0;
                        }
                    }
                    public void keyReleased(KeyEvent e){
			m.count=0;
		    }
		});
		m.x = 400;
		actor.start();
	}
	
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(HP<=0){
                this.remove(BExithome);
                this.setLayout(null);
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
            }else if(times <= 0){
                check = false;
                this.setLayout(null);
                g.drawImage(feildwin.getImage(),0,0,1000,800,this);
            }else if(times <= 20){
                if(rs == 3){
                    this.setLayout(null);

                    g.drawImage(imgstate3.getImage(),0,0,1000,800,this);
                    g.drawImage(m.im[m.count].getImage(), 650,m.x,200,200, this);
                    if(m.x<=50){
                        m.x+=p;
                    }
                    if(m.x>=800){
                        m.x-=p;
                    }  
                    //========================================Block1================= 
                    for(int i=0 ; i<block1.size();i++){
                        g.drawImage(block1.get(i).getImage(),block1.get(i).getY(),block1.get(i).getX(),70,70,this);
                    }
                    for(int j=0 ; j<block1.size();j++){
                        distanceP = (int)Math.sqrt((Math.pow(Math.abs(block1.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block1.get(j).getY())-600),2)));
                        if(distanceP<60){
                            block1.remove(j);
                            HP = HP-1;
                        }
                    }
                    //========================Block2=========================
                    for(int i=0 ; i<block2.size();i++){
                        g.drawImage(block2.get(i).getImage(),block2.get(i).getY(),block2.get(i).getX(),70,70,this);
                     }
                    for(int j=0 ; j<block2.size();j++){
                        distanceP = (int)Math.sqrt((Math.pow(Math.abs(block2.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block2.get(j).getY())-600),2)));
                        if(distanceP<60){
                            block2.remove(j);
                            HP = HP-1;
                        }
                    }
                    //=================================Freeze=============
                    for(int i=0 ; i<freeze.size();i++){
                        g.drawImage(freeze.get(i).getImage(),freeze.get(i).getY(),freeze.get(i).getX(),100,100,this);
                    }
                    for(int j=0 ; j<freeze.size();j++){
                        distanceP = (int)Math.sqrt((Math.pow(Math.abs(freeze.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((freeze.get(j).getY())-600),2)));
                        if(distanceP < 60){
                            freeze.remove(j);
                            p = 1;
                        }
                    }
                    //=================================HPPlus=============
                    for(int i=0 ; i<Hp.size();i++){
                        g.drawImage(Hp.get(i).getImage(),Hp.get(i).getY(),Hp.get(i).getX(),50,50,this);
                    }
                    for(int j=0 ; j<Hp.size();j++){
                        distanceP = (int)Math.sqrt((Math.pow(Math.abs(Hp.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Hp.get(j).getY())-600),2)));
                        if(distanceP < 60){
                            Hp.remove(j);
                            HP = HP+1;
                        } 
                    }
                    //=================================Clock=============
                    for(int i=0 ; i<Clock.size();i++){
                        g.drawImage(Clock.get(i).getImage(),Clock.get(i).getY(),Clock.get(i).getX(),50,50,this);
                    }
                    for(int j=0 ; j<Clock.size();j++){
                        distanceP = (int)Math.sqrt((Math.pow(Math.abs(Clock.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Clock.get(j).getY())-600),2)));
                        if(distanceP < 60){
                            Clock.remove(j);
                            times = times+10;
                        } 
                    }
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
                    g.drawString("Mode:Hard",700,50);
                    g.drawString("Time "+times,400,50);
                    if(HP>3) HP = 3;
                    if(HP<=3){
                        g.drawImage(RedHeart.getImage(), 200, 1, 100, 100, this);
                        g.drawImage(RedHeart.getImage(), 100, 1, 100, 100, this);
                        g.drawImage(RedHeart.getImage(), 1, 1, 100, 100, this);
                        if(HP == 2) g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                        if(HP == 1){
                            g.drawImage(BlackHeart.getImage(), 100, 1, 100, 100, this);
                            g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                        }
                }
		g.drawImage(Worker.getImage(), 430, 270, 150, 150, this);
	    }else if(rs == 2){
                this.setLayout(null);
                
                g.drawImage(imgstate2.getImage(),0,0,1000,800,this);
                g.drawImage(m.im[m.count].getImage(), 650,m.x,200,200, this);
		if(m.x<=50){
                    m.x+=p;
   		}
   		if(m.x>=800){
                    m.x-=p;
   		}  
		//========================================Block1================= 
                for(int i=0 ; i<block1.size();i++){
                    g.drawImage(block1.get(i).getImage(),block1.get(i).getY(),block1.get(i).getX(),70,70,this);
 		}
                for(int j=0 ; j<block1.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block1.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block1.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block1.remove(j);
                        HP = HP-1;
                    }
                }
		//========================Block2=========================
		for(int i=0 ; i<block2.size();i++){
		    g.drawImage(block2.get(i).getImage(),block2.get(i).getY(),block2.get(i).getX(),70,70,this);
		 }
		for(int j=0 ; j<block2.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block2.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block2.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block2.remove(j);
                        HP = HP-1;
                    }
                }
		//=================================Freeze=============
		for(int i=0 ; i<freeze.size();i++){
		    g.drawImage(freeze.get(i).getImage(),freeze.get(i).getY(),freeze.get(i).getX(),100,100,this);
		}
		for(int j=0 ; j<freeze.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(freeze.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((freeze.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        freeze.remove(j);
                        p = 1;
                    }
                }
                //=================================HPPlus=============
		for(int i=0 ; i<Hp.size();i++){
		    g.drawImage(Hp.get(i).getImage(),Hp.get(i).getY(),Hp.get(i).getX(),50,50,this);
		}
		for(int j=0 ; j<Hp.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Hp.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Hp.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        Hp.remove(j);
                        HP = HP+1;
                    } 
                }
                //=================================Clock=============
                for(int i=0 ; i<Clock.size();i++){
		    g.drawImage(Clock.get(i).getImage(),Clock.get(i).getY(),Clock.get(i).getX(),50,50,this);
		}
		for(int j=0 ; j<Clock.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Clock.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Clock.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        Clock.remove(j);
                        times = times+10;
                    } 
                }
		g.setColor(Color.BLACK);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("Mode:Middle",700,50);
		g.drawString("Time "+times,400,50);
                if(HP>3) HP = 3;
                if(HP<=3){
                    g.drawImage(RedHeart.getImage(), 200, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 100, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 1, 1, 100, 100, this);
                    if(HP == 2) g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    if(HP == 1){
                        g.drawImage(BlackHeart.getImage(), 100, 1, 100, 100, this);
                        g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    }
                }
		g.drawImage(Worker.getImage(), 430, 270, 150, 150, this);
	    }else if(rs == 1){
                this.setLayout(null);
                
                g.drawImage(imgstate1.getImage(),0,0,1000,800,this);
                g.drawImage(m.im[m.count].getImage(), 650,m.x,200,200, this);
		if(m.x<=50){
                    m.x+=p;
   		}
   		if(m.x>=800){
                    m.x-=p;
   		}  
		//========================================Block1================= 
                for(int i=0 ; i<block1.size();i++){
                    g.drawImage(block1.get(i).getImage(),block1.get(i).getY(),block1.get(i).getX(),70,70,this);
 		}
                for(int j=0 ; j<block1.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block1.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block1.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block1.remove(j);
                        HP = HP-1;
                    }
                }
		//========================Block2=========================
		for(int i=0 ; i<block2.size();i++){
		    g.drawImage(block2.get(i).getImage(),block2.get(i).getY(),block2.get(i).getX(),70,70,this);
		 }
		for(int j=0 ; j<block2.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block2.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block2.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block2.remove(j);
                        HP = HP-1;
                    }
                }
		//=================================Freeze=============
		for(int i=0 ; i<freeze.size();i++){
		    g.drawImage(freeze.get(i).getImage(),freeze.get(i).getY(),freeze.get(i).getX(),100,100,this);
		}
		for(int j=0 ; j<freeze.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(freeze.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((freeze.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        freeze.remove(j);
                        p = 1;
                    }
                }
                //=================================HPPlus=============
		for(int i=0 ; i<Hp.size();i++){
		    g.drawImage(Hp.get(i).getImage(),Hp.get(i).getY(),Hp.get(i).getX(),50,50,this);
		}
		for(int j=0 ; j<Hp.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Hp.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Hp.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        Hp.remove(j);
                        HP = HP+1;
                    } 
                }
                //=================================Clock=============
                for(int i=0 ; i<Clock.size();i++){
		    g.drawImage(Clock.get(i).getImage(),Clock.get(i).getY(),Clock.get(i).getX(),50,50,this);
		}
		for(int j=0 ; j<Clock.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Clock.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Clock.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        Clock.remove(j);
                        times = times+10;
                    } 
                }
		g.setColor(Color.BLACK);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("Mode:Easy",700,50);
		g.drawString("Time "+times,400,50);
                if(HP>3) HP = 3;
                if(HP<=3){
                    g.drawImage(RedHeart.getImage(), 200, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 100, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 1, 1, 100, 100, this);
                    if(HP == 2) g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    if(HP == 1){
                        g.drawImage(BlackHeart.getImage(), 100, 1, 100, 100, this);
                        g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    }
                }
		g.drawImage(Worker.getImage(), 430, 270, 150, 150, this);
            }
            }else{
                if(rs == 3){
                this.setLayout(null);
                
                g.drawImage(imgstate3.getImage(),0,0,1000,800,this);
                g.drawImage(m.im[m.count].getImage(), m.x, 600,200,200, this);
		if(m.x<-50){
                    m.x+=p;
   		}
   		if(m.x>=850){
                    m.x-=p;
   		}  
		//========================================Block1================= 
                for(int i=0 ; i<block1.size();i++){
                    g.drawImage(block1.get(i).getImage(),block1.get(i).getX(),block1.get(i).getY(),70,70,this);
 		}
                for(int j=0 ; j<block1.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block1.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block1.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block1.remove(j);
                        HP = HP-1;
                    }
                }
		//========================Block2=========================
		for(int i=0 ; i<block2.size();i++){
		    g.drawImage(block2.get(i).getImage(),block2.get(i).getX(),block2.get(i).getY(),70,70,this);
		 }
		for(int j=0 ; j<block2.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block2.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block2.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block2.remove(j);
                        HP = HP-1;
                    }
                }
		//=================================Freeze=============
		for(int i=0 ; i<freeze.size();i++){
		    g.drawImage(freeze.get(i).getImage(),freeze.get(i).getX(),freeze.get(i).getY(),100,100,this);
		}
		for(int j=0 ; j<freeze.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(freeze.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((freeze.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        freeze.remove(j);
                        p = 1;
                    }
                }
                //=================================HPPlus=============
		for(int i=0 ; i<Hp.size();i++){
		    g.drawImage(Hp.get(i).getImage(),Hp.get(i).getX(),Hp.get(i).getY(),50,50,this);
		}
		for(int j=0 ; j<Hp.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Hp.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Hp.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        Hp.remove(j);
                        HP = HP+1;
                    } 
                }
                //=================================Clock=============
                for(int i=0 ; i<Clock.size();i++){
		    g.drawImage(Clock.get(i).getImage(),Clock.get(i).getX(),Clock.get(i).getY(),50,50,this);
		}
		for(int j=0 ; j<Clock.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Clock.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Clock.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        Clock.remove(j);
                        times = times+10;
                    } 
                }
		g.setColor(Color.WHITE);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("Mode:Hard",700,50);
		g.drawString("Time "+times,400,50);
                if(HP>3) HP = 3;
                if(HP<=3){
                    g.drawImage(RedHeart.getImage(), 200, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 100, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 1, 1, 100, 100, this);
                    if(HP == 2) g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    if(HP == 1){
                        g.drawImage(BlackHeart.getImage(), 100, 1, 100, 100, this);
                        g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    }
                }
		g.drawImage(Worker.getImage(), 430, 270, 150, 150, this);
	    }else if(rs == 2){
                this.setLayout(null);
                
                g.drawImage(imgstate2.getImage(),0,0,1000,800,this);
                g.drawImage(m.im[m.count].getImage(), m.x, 600,200,200, this);
		if(m.x<-50){
                    m.x+=p;
   		}
   		if(m.x>=850){
                    m.x-=p;
   		}  
		//========================================Block1================= 
                for(int i=0 ; i<block1.size();i++){
                    g.drawImage(block1.get(i).getImage(),block1.get(i).getX(),block1.get(i).getY(),70,70,this);
 		}
                for(int j=0 ; j<block1.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block1.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block1.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block1.remove(j);
                        HP = HP-1;
                    }
                }
		//========================Block2=========================
		for(int i=0 ; i<block2.size();i++){
		    g.drawImage(block2.get(i).getImage(),block2.get(i).getX(),block2.get(i).getY(),70,70,this);
		 }
		for(int j=0 ; j<block2.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block2.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block2.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block2.remove(j);
                        HP = HP-1;
                    }
                }
		//=================================Freeze=============
		for(int i=0 ; i<freeze.size();i++){
		    g.drawImage(freeze.get(i).getImage(),freeze.get(i).getX(),freeze.get(i).getY(),100,100,this);
		}
		for(int j=0 ; j<freeze.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(freeze.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((freeze.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        freeze.remove(j);
                        p = 1;
                    }
                }
                //=================================HPPlus=============
		for(int i=0 ; i<Hp.size();i++){
		    g.drawImage(Hp.get(i).getImage(),Hp.get(i).getX(),Hp.get(i).getY(),50,50,this);
		}
		for(int j=0 ; j<Hp.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Hp.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Hp.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        Hp.remove(j);
                        HP = HP+1;
                    } 
                }
                //=================================Clock=============
                for(int i=0 ; i<Clock.size();i++){
		    g.drawImage(Clock.get(i).getImage(),Clock.get(i).getX(),Clock.get(i).getY(),50,50,this);
		}
		for(int j=0 ; j<Clock.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Clock.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Clock.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        Clock.remove(j);
                        times = times+10;
                    } 
                }
		g.setColor(Color.BLACK);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("Mode:Middle",700,50);
		g.drawString("Time "+times,400,50);
                if(HP>3) HP = 3;
                if(HP<=3){
                    g.drawImage(RedHeart.getImage(), 200, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 100, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 1, 1, 100, 100, this);
                    if(HP == 2) g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    if(HP == 1){
                        g.drawImage(BlackHeart.getImage(), 100, 1, 100, 100, this);
                        g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    }
                }
		g.drawImage(Worker.getImage(), 430, 270, 150, 150, this);
	    }else if(rs == 1){
                g.drawImage(imgstate1.getImage(),0,0,1000,800,this);
                g.drawImage(m.im[m.count].getImage(), m.x, 600,200,200, this);
		if(m.x<-50){
                    m.x+=p;
   		}
   		if(m.x>=850){
                    m.x-=p;
   		}
		//========================================Block1================= 
                for(int i=0 ; i<block1.size();i++){
                    g.drawImage(block1.get(i).getImage(),block1.get(i).getX(),block1.get(i).getY(),70,70,this);
 		}
                for(int j=0 ; j<block1.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block1.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block1.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block1.remove(j);
                        HP = HP-1;
                    } 
                }
		//========================Block2=========================
		for(int i=0 ; i<block2.size();i++){
		    g.drawImage(block2.get(i).getImage(),block2.get(i).getX(),block2.get(i).getY(),70,70,this);
		 }
		for(int j=0 ; j<block2.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(block2.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((block2.get(j).getY())-600),2)));
                    if(distanceP<60){
                        block2.remove(j);
                        HP = HP-1;
                    } 
                }
		//=================================Freeze=============
		for(int i=0 ; i<freeze.size();i++){
		    g.drawImage(freeze.get(i).getImage(),freeze.get(i).getX(),freeze.get(i).getY(),100,100,this);
		}
		for(int j=0 ; j<freeze.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(freeze.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((freeze.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        freeze.remove(j);
                        p = 1;
                    } 
                }
                //=================================HPPlus=============
		for(int i=0 ; i<Hp.size();i++){
		    g.drawImage(Hp.get(i).getImage(),Hp.get(i).getX(),Hp.get(i).getY(),50,50,this);
		}
		for(int j=0 ; j<Hp.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Hp.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Hp.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        Hp.remove(j);
                        HP = HP+1;
                    } 
                }
                //=================================Clock=============
                for(int i=0 ; i<Clock.size();i++){
		    g.drawImage(Clock.get(i).getImage(),Clock.get(i).getX(),Clock.get(i).getY(),50,50,this);
		}
		for(int j=0 ; j<Clock.size();j++){
                    distanceP = (int)Math.sqrt((Math.pow(Math.abs(Clock.get(j).getX()-(m.x+50)),2))+(Math.pow(Math.abs((Clock.get(j).getY())-600),2)));
                    if(distanceP < 60){
                        times = times+10;
                        Clock.remove(j);
                    } 
                }
		g.setColor(Color.BLACK);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("Mode:Easy",700,50);
		g.drawString("Time "+times,400,50);
                if(HP>3) HP = 3;
                if(HP<=3){
                    g.drawImage(RedHeart.getImage(), 200, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 100, 1, 100, 100, this);
                    g.drawImage(RedHeart.getImage(), 1, 1, 100, 100, this);
                    if(HP == 2) g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    if(HP == 1){
                        g.drawImage(BlackHeart.getImage(), 100, 1, 100, 100, this);
                        g.drawImage(BlackHeart.getImage(), 200, 1, 100, 100, this);
                    }
                }
		g.drawImage(Worker.getImage(), 430, 70, 150, 150, this);
	    }
            }
        }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== BStartover){		
                    this.setSize(1000,800);
                    this.add(hg);
                    this.setLocation(null);
                    timestart = true;
                    startball = true;
		}else if(e.getSource() == BExitover){
                    System.exit(0);
		}		
	}
}
