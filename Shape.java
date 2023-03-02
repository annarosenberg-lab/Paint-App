import java.awt.*;
/**
 *Assignment 01
 *Shape Drawing App using Java's Swift API.
 *
 * @author Anna Rosenberg
 */


/**
 *Setup for the Shape class
 */
public class Shape{
    int x1, x2, y1, y2;
    String c;
    /**
     *Definition of shape
     */
    public Shape(int x1, int x2, int y1, int y2, String c){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.c = c;

    }
    /**
     *Empty draw method
     */
    public void draw(Graphics g){

    }
    /**
     *Empty drawOutline method
     */
    public void drawOutline(Graphics g){

    }

}
