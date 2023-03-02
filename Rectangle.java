import java.awt.*;
import java.util.Objects;
/**
 *Assignment 01
 *Shape Drawing App using Java's Swift API.
 *
 * @author Anna Rosenberg
 */

/**
 *Setup for Rectangle shape
 */
public class Rectangle extends Shape{
    /**
     *Definition of Rectangle object
     */
    public Rectangle(int x1, int x2, int y1, int y2, String c){
        super(x1, x2, y1, y2, c);
    }
    /**
     *Draws the Rectangle object
     */
    @Override
    public void draw(Graphics g){
        if (Objects.equals(c, "Red")) g.setColor(Color.red);
        if (Objects.equals(c, "Black")) g.setColor(Color.black);
        if (Objects.equals(c, "Yellow")) g.setColor(Color.yellow);
        if (Objects.equals(c, "Blue")) g.setColor(Color.blue);
        if (Objects.equals(c, "Green")) g.setColor(Color.green);
        g.fillRect(Math.min(x2, x1), Math.min(y2, y1), (x2>x1)?x2-x1:x1-x2, (y2>y1)?y2-y1:y1-y2);
        g.setColor(Color.black);
        g.drawRect(Math.min(x2, x1), Math.min(y2, y1), (x2>x1)?x2-x1:x1-x2, (y2>y1)?y2-y1:y1-y2);
    }
    /**
     *Draws the Rectangle outline
     */
    public void drawOutline(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(Math.min(x2, x1), Math.min(y2, y1), (x2>x1)?x2-x1:x1-x2, (y2>y1)?y2-y1:y1-y2);
        g.setColor(Color.black);
        g.drawRect(Math.min(x2, x1), Math.min(y2, y1), (x2>x1)?x2-x1:x1-x2, (y2>y1)?y2-y1:y1-y2);
    }
}
