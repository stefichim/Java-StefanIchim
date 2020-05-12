package lab12Compulsory;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class MainFrame extends JFrame {
	DesignPanel designPanel;
	ControlPanel controlPanel;
    public MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super();
        this.setLayout(new BorderLayout());
        rootPane.setPreferredSize(new Dimension(2000, 1000));
        init();
        addComponents();
        this.setVisible(true);
    }
    private void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.controlPanel = new ControlPanel(this);
        this.designPanel = new DesignPanel(this);
        pack();
    }

    private void addComponents(){
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(designPanel, BorderLayout.CENTER);
    }
    
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        MainFrame mainFrame = new MainFrame();

    }
}