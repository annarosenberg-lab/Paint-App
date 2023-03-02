import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;
/**
 *Assignment 01
 *Shape Drawing App using Java's Swift API.
 *
 * @author Anna Rosenberg
 */


/**
 *Setup for the center panel that the shapes will be drawn on
 */
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
    private int x1, x2, y1, y2;
    private String color;
    private boolean drawing;
    private String shape;

    private Shape tempOutline;
    public Stack<Shape> shapes = new Stack<Shape>();


    /**
     *Draws the panel
     */
    public DrawPanel(){
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    /**
     *Sets the shape
     */
    public void setShape(String shape){
        this.shape = shape;
    }
    /**
     *Sets the color of the shape
     */
    public void setColor(String color){
        this.color = color;
    }

    /**
     *draws all the shapes on the center panel
     */
    public void paintComponent(Graphics g){
        setBackground(Color.LIGHT_GRAY);
        super.paintComponent(g);
        if (drawing){
            tempOutline.drawOutline(g);
        }
        if(shapes!=null){
            for(Shape shape: shapes) shape.draw(g);
        }
    }
    /**
     *Get position every time mouse is pressed
     */
    public void mousePressed(MouseEvent e){
        drawing =true;
        x1 = e.getX();
        y1 = e.getY();
    }
    /**
     *Get position and selected shape every time mouse is released
     */
    public void mouseReleased(MouseEvent e) {
        drawing = false;
        x2 = e.getX();
        y2 = e.getY();
        if(shape.equals("Rectangle")) {shapes.push(new Rectangle(x1, x2, y1,y2,color));}
        if(shape.equals("Circle")) {shapes.push(new Circle(x1, x2, y1,y2,color));}
        if(shape.equals("Arc")) {shapes.push(new Arc(x1, x2, y1,y2,color));}
        repaint();
    }
    /**
     *Get position and shape outline as mouse is dragged
     */
    public void mouseDragged(MouseEvent e) {
        if(shape.equals("Rectangle")) {tempOutline = (new Rectangle(x1, x2, y1,y2,color));}
        if(shape.equals("Circle")) {tempOutline = (new Circle(x1, x2, y1,y2,color));}
        if(shape.equals("Arc")) {tempOutline = (new Arc(x1, x2, y1,y2,color));}
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }
    /**
     *Override mouseClicked, mouseEntered, mouseExited and mouseMoved methods
     */
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
}
