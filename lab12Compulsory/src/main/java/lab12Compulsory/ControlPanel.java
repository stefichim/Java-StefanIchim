package lab12Compulsory;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel textLabel = new JLabel("Text");
    private final JTextField textField = new JTextField(10);
    private final JLabel classLabel = new JLabel("Nume de clasa");
    private final JTextField classField = new JTextField(30);
    private final JButton createButton = new JButton("Adauga o componenta");
    public ControlPanel(MainFrame frame) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.frame = frame;
        init();
    }
    private void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        add(classLabel);
        add(textLabel); 
        add(textField);
        add(classField); 
        add(createButton);
        ActionListener listener = null;
		createButton.addActionListener(listener);{
            JComponent comp = createDynamicComponent(classField.getText());
            if (comp != null) {
                setComponentText(comp, textField.getText());
                frame.designPanel.addAbsoluteLocation(comp);
            }
        };

    }
    private JComponent createDynamicComponent(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

            Class myclass = Class.forName(className);
            return (JComponent) myclass.newInstance();
    }

    private void setComponentText(JComponent comp, String text) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //implement this method
        Class myclass = comp.getClass();
        Method a = null;
            a = myclass.getMethod("setText", String.class);
            a.invoke(comp, text);
        
    }
}