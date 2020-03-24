package lab6_CoMpulsory;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	final MainFrame frame;
	JButton saveBtn = new JButton("Save");
	//create all buttons (Load, Reset, Exit) ...TODO
	// JButton loadBtn = new JButton("Load");
	 JButton resetBtn = new JButton("Reset");
	 JButton exitBtn = new JButton("Exit");
	
	public ControlPanel(MainFrame frame) {
		this.frame = frame; 
		init();
	}
	private void init() { 
		//change the default layout manager (just for fun)
		setLayout(new GridLayout(1, 4));
		
		//add all buttons...TODO

        add(saveBtn);
       // add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        
		//configure listeners for all buttons
        
		saveBtn.addActionListener(this::save);
		//loadBtn.addActionListener(this::load);
		//ati spus ca butonul de load nu este neaparat necesar
		
	    resetBtn.addActionListener(this::reset);
	    exitBtn.addActionListener(this::exit);
		
		//...TODO
	} 
	private void save(ActionEvent e) {
			try {
				ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
		} catch (IOException ex) { System.err.println(ex); }
	}
	
	private void reset(ActionEvent e) {
		//aici am facut ca in functia createOffscreenImage(), doar ca a trebuit sa adaug frame.canvas, iar in loc de W si H sa pun dimensiunea exacta
		frame.canvas.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		frame.canvas.graphics = frame.canvas.image.createGraphics();
		frame.canvas.graphics.setColor(Color.WHITE);  //fill the image with white
		frame.canvas.graphics.fillRect(0, 0, 800, 600);
        frame.canvas.repaint();//ca sa imi faca din nou ecranul alb

	}
	private void exit(ActionEvent e)
    {
        System.exit(0);
    }
		
}
