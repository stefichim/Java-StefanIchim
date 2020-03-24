package lab6_CoMpulsory;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigPanel extends JPanel {
	final MainFrame frame;
	JLabel label;         // we’re drawing regular polygons  
	JSpinner sidesField;  // number of sides
	JComboBox colorCombo; // the color of the shape
	JSpinner sizeField;
	JLabel sizeLabel;
	JLabel sidesLabel;
	JLabel colorLabel;
	public ConfigPanel(MainFrame frame) {
		this.frame = frame;
		init();
		}
	private void init() {
		//create the label and the spinner
		sidesLabel = new JLabel("Number of sides:");
		sizeLabel = new JLabel("Size:");
		sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		sidesField.setValue(6); //default number of sides
		//create the colorCombo, containing the values: Random and Black
		 
	
        sizeField = new JSpinner(new SpinnerNumberModel(0, 0, 500, 1));
        sizeField.setValue(50);
        
        
        String[] colorString = {"Random", "Black"};
        colorLabel = new JLabel("Color:");
        colorCombo = new JComboBox(colorString);
        
		add(sidesLabel); //JPanel uses FlowLayout by default
		add(sidesField);
		
		add(colorCombo);    
		add(sizeLabel);
	    add(sizeField);
	    add(colorLabel);
	}
}
