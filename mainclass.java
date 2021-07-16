//main class
//swing and multithreading
import java.awt.*;
import javax.swing.*;

//JFrame - required to build a frame
//Runnable - multithreading 
class sframe extends JFrame implements Runnable{

	Thread t; // explicitly creating a thread object
	 
	sframe(String s){
		super(s); // to set the heading of frame
		setLayout(new FlowLayout());
	    ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/welcome.jpg"));
	    // gets the image from disk
		Image im1 = ic1.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
		// adjusting the dimensions
		ImageIcon ic2 = new ImageIcon(im1); 
		// image cannot be directly added to frame, only imageicon is valid
		JLabel jl1 = new JLabel(ic2);
		add(jl1); // add to frame
		t = new Thread(this);
		t.start();
	}
		 
	public void run(){
		try{
	         Thread.sleep(3000); // 3 sec hold
	         this.setVisible(false); // false = hide the frame, this = current frame
	         login lgn = new login(); // calls login class
	    }catch(Exception e){
	    	e.printStackTrace(); 
		}
	}
}

// main class
class mainclass {
	public static void main(String[] args) {
		sframe sf1 = new sframe("Payroll System - Sahaja"); // heading
		sf1.setVisible(true); // true - frame is visible
		// to open the frame gradually and not at once
		int i, x = 1;
		for(i=1; i<=605; i+=5,x+=2){
			sf1.setLocation((700 - ((i+x)/2)), 400 - (i/2)); // location - x,y coordinates
			sf1.setSize(i+x,i); // set the size dynamically
			try{
				Thread.sleep(10);
			}catch(Exception e) { }
		}
	}
}

