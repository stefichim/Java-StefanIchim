package lab6_CoMpulsory;

import javax.swing.JFrame;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class MainFrame extends JFrame{

	//am creat obiecte de tip ConfigPanel, ControlPanel si DrawingPanel
	ConfigPanel configPanel; 
	ControlPanel controlPanel;
	DrawingPanel canvas;
	
	public MainFrame() {
		super("My Drawing Application");
		init();
		}
	
	private void init() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//create the components 
		configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        
		//arrange the components in the container (frame)
		//JFrame uses a BorderLayout by default 
        //this is BorderLayout.CENTER
        
		add(configPanel, NORTH);//am pus partea de configPanel sus
        add(controlPanel, SOUTH);// am pus partea de controlPanel jos
        add(canvas, CENTER);//pe centru pot deena
		//invoke the layout manager
		pack();        
	}
}

