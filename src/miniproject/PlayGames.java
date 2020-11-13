package miniproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class PlayGames extends JFrame implements ActionListener{  
	homegames homegames1 = new homegames();
	playstate1 state1 = new playstate1();
        Howtoplay how = new Howtoplay();
        Lv lv = new Lv();
        int u = 0;
	public PlayGames(){
		this.setSize(1000,800);
		this.add(homegames1);
		homegames1.BExit.addActionListener(this);
                homegames1.BStart.addActionListener(this);
                homegames1.BHow.addActionListener(this);
                state1.BExithome.addActionListener(this);
                how.Bclose.addActionListener(this);
                lv.BEasy.addActionListener(this);
                lv.BMiddle.addActionListener(this);
                lv.BHard.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
            if(e.getSource()== homegames1.BStart){
		this.setLocationRelativeTo(null);
		this.remove(homegames1);
                this.setSize(1000,840);
                this.add(lv);
                lv.requestFocusInWindow();
                if(u == 0){
                    state1.startball=false;
                    state1.timestart=false;
                    state1.tBlock1.start();
                    state1.tBlock2.start();
                    state1.Freeze.start();
                    state1.HpPlus.start();
                    state1.tTime.start();
                    state1.clock.start();
                }
            }else if(e.getSource() == lv.BEasy){
                this.setLocationRelativeTo(null);
		this.remove(lv);
                this.setSize(1000,840);
                this.add(state1);
                state1.check = true;
                state1.requestFocusInWindow();
		state1.HP =3;
		state1.times = 50;
		state1.startball=false;
		state1.timestart=false;
                state1.tBlock1.resume();
		state1.tBlock2.resume();
		state1.Freeze.resume();
                state1.HpPlus.resume();
                state1.tTime.resume();
                state1.clock.resume();
                state1.rs = 1;
                state1.l = 30;
                u = 1;
            }else if(e.getSource() == lv.BMiddle){
                this.setLocationRelativeTo(null);
		this.remove(lv);
                this.setSize(1000,840);
                this.add(state1);
                state1.check = true;
                state1.requestFocusInWindow();
		state1.HP =3;
		state1.times = 50;
		state1.startball=false;
		state1.timestart=false;
                state1.tBlock1.resume();
		state1.tBlock2.resume();
		state1.Freeze.resume();
                state1.HpPlus.resume();
                state1.tTime.resume();
                state1.clock.resume();
                state1.rs = 2;
                state1.l = 30;
                u = 1;
            }else if(e.getSource() == lv.BHard){
                this.setLocationRelativeTo(null);
		this.remove(lv);
                this.setSize(1000,840);
                this.add(state1);
                state1.check = true;
                state1.requestFocusInWindow();
		state1.HP =3;
		state1.times = 50;
		state1.startball=false;
		state1.timestart=false;
                state1.tBlock1.resume();
		state1.tBlock2.resume();
		state1.Freeze.resume();
                state1.HpPlus.resume();
                state1.tTime.resume();
                state1.clock.resume();
                state1.rs = 3;
                state1.l = 30;
                u = 1;
            }else if(e.getSource() == homegames1.BHow){
		this.setLocationRelativeTo(null);
		this.remove(homegames1);
                this.setSize(1000,840);
                this.add(how);
            }else if(e.getSource() == how.Bclose){
		this.setLocationRelativeTo(null);
		this.remove(how);
                this.setSize(1000,840);
                this.add(homegames1);
            }else if(e.getSource() == state1.BExithome){
		this.setLocationRelativeTo(null);
		this.remove(state1);
                this.setSize(1000,840);
                this.add(homegames1);
                state1.check = false;
                homegames1.requestFocusInWindow();
                state1.startball=true;
		state1.timestart=true;
		state1.tBlock1.suspend();
		state1.tBlock2.suspend();
		state1.Freeze.suspend();
                state1.HpPlus.suspend();
                state1.clock.suspend();
            }else if(e.getSource() == homegames1.BExit){
		System.exit(0);
            }
            this.validate();
            this.repaint();
	}
        
     public static void main(String[] args) {
            JFrame jf = new PlayGames();
            jf.setSize(1000,800);
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);
    }    
        
        
	
}
