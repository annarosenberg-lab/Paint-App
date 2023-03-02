import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *Assignment 01
 *Shape Drawing App using Java's Swift API.
 *
 * @author Anna Rosenberg
 */
public class Main extends JFrame implements ActionListener{
    DrawPanel centerPanel;
    public static void main(String[] args) {
        Main main = new Main();
        main.setSize(500,500);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    /**
     *Setup for all the panels used in the Drawing app
     */
    public Main(){
        super("My Paint App");

        //south
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.CYAN);
        JButton b1 = new JButton("Undo");
        JButton b2 = new JButton("Erase");
        southPanel.add(b1);
        southPanel.add(b2);
        //west
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.PINK);
        String[] colors = {"Black","Red", "Blue", "Green", "Yellow"};
        JComboBox list = new JComboBox(colors);
        JRadioButton rectangle = new JRadioButton("Rectangle");
        JRadioButton circle = new JRadioButton("Circle");
        JRadioButton arc = new JRadioButton("Arc");
        rectangle.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(rectangle);
        group.add(circle);
        group.add(arc);
        GridLayout grid = new GridLayout(7, 1);
        westPanel.setLayout(grid);
        westPanel.add(list);
        westPanel.add(rectangle);
        westPanel.add(circle);
        westPanel.add(arc);
        //center
        centerPanel = new DrawPanel();
        centerPanel.setShape("Rectangle");
        centerPanel.setColor("Black");
        centerPanel.setBackground(Color.gray);

        //frame
        BorderLayout layout = new BorderLayout();
        setLayout (layout);
        add (southPanel, BorderLayout.SOUTH);
        add (westPanel, BorderLayout.WEST);
        add (centerPanel, BorderLayout.CENTER);

        //Listeners
        list.addActionListener(this);
        rectangle.addActionListener(this);
        circle.addActionListener(this);
        arc.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);


    }
    /**
     *Implements the actionPerfromed function to make the buttons and mouse interactive
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("comboBoxChanged")){
            JComboBox tmp = (JComboBox) e.getSource();
            centerPanel.setColor((String)tmp.getSelectedItem());

        }
        if (e.getActionCommand().equals("Rectangle")){
            centerPanel.setShape("Rectangle");
        }
        if (e.getActionCommand().equals("Arc")){
            centerPanel.setShape("Arc");
        }
        if (e.getActionCommand().equals("Circle")){
            centerPanel.setShape("Circle");
        }
        if (e.getActionCommand().equals("Undo")){
            centerPanel.shapes.pop();
            centerPanel.repaint();
        }
        if (e.getActionCommand().equals("Erase")){
            centerPanel.shapes.clear();
            centerPanel.repaint();


        }
    }
}