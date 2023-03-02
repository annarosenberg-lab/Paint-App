import java.awt.*;
import java.util.Objects;
/**
 *Assignment 01
 *Shape Drawing App using Java's Swift API.
 *
 * @author Anna Rosenberg
 */


/**
 *Setup for Arc shape
 */
public class Arc extends Shape{
    /**
     *Definition of Arc object
     */
    public Arc(int x1, int x2, int y1, int y2, String c){
        super(x1, x2, y1, y2, c);
    }
    /**
     *Draws the Arc object
     */
    @Override
    public void draw(Graphics g){
        int dy = Math.min(y2, y1) - Math.max(y2, y1);
        int dx = Math.min(x2, x1) - Math.max(x2, x1);
        int radiusX = (int)Math.sqrt(Math.pow(dx, 2)+Math.pow(dy,2));
        int radiusY = (int)(radiusX)/2;
        int length = (int)Math.atan2(dy, dx);
        length = (int)(Math.toDegrees(length));
        if (Objects.equals(c, "Red")) g.setColor(Color.red);
        if (Objects.equals(c, "Black")) g.setColor(Color.black);
        if (Objects.equals(c, "Yellow")) g.setColor(Color.yellow);
        if (Objects.equals(c, "Blue")) g.setColor(Color.blue);
        if (Objects.equals(c, "Green")) g.setColor(Color.green);
        g.fillArc(Math.min(x2, x1), Math.min(y2, y1), radiusX, radiusY, 0, length);
        g.setColor(Color.black);
        g.drawArc(Math.min(x2, x1), Math.min(y2, y1), radiusX, radiusY, 0, length);


    }
    /**
     *Draws the Arc outline
     */
    public void drawOutline(Graphics g) {
        int dy = Math.min(y2, y1) - Math.max(y2, y1);
        int dx = Math.min(x2, x1) - Math.max(x2, x1);
        int radiusX = (int)Math.sqrt(Math.pow(dx, 2)+Math.pow(dy,2));
        int radiusY = (int)(radiusX)/2;
        int length = (int)Math.atan2(dy, dx);
        length = (int)(Math.toDegrees(length));
        g.setColor(Color.white);
        g.fillArc(Math.min(x2, x1), Math.min(y2, y1), radiusX, radiusY, 0, length);
        g.setColor(Color.black);
        g.drawArc(Math.min(x2, x1), Math.min(y2, y1), radiusX, radiusY, 0, length);
    }
}
