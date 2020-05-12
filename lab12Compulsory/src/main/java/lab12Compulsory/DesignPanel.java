package lab12Compulsory;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
    public static final int W = 2000, H = 10000;
    private final MainFrame frame;
    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setLayout(null);
        setPreferredSize(new Dimension(W, H));
    }
    public void addAbsoluteLocation(JComponent comp) {
        Random random = new Random();
        int x = random.nextInt(W);//create a random integer between 0 and W-1
        int y = random.nextInt(H);//create a random integer between 0 and H-1
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;
        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        this.add(comp);
        frame.repaint();
    }
}